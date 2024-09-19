/*
 * Copyright (c) 2018-2022 Computate Limited Liability Company in Utah, USA. 
 *
 * This program and the accompanying materials are made available under the
 * terms of the GNU GENERAL PUBLIC LICENSE Version 3 which is available at
 * 
 * https://www.gnu.org/licenses/gpl-3.0.en.html
 * 
 * You may not propagate or modify a covered work except as expressly provided 
 * under this License. Any attempt otherwise to propagate or modify it is void, 
 * and will automatically terminate your rights under this License (including 
 * any patent licenses granted under the third paragraph of section 11).
 */
package org.computate.vertx.verticle;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.commons.lang3.StringUtils;
import org.computate.vertx.config.ComputateConfigKeys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.MultiMap;
import io.vertx.core.Promise;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.mail.MailClient;
import io.vertx.ext.mail.MailConfig;
import io.vertx.ext.mail.MailMessage;

import com.google.common.io.Resources;
import com.hubspot.jinjava.Jinjava;
import com.hubspot.jinjava.loader.FileLocator;

/**
 * Keyword: classSimpleNameMailVerticle
 */ 
public class EmailVerticle extends EmailVerticleGen<AbstractVerticle> {
	private static final Logger LOG = LoggerFactory.getLogger(EmailVerticle.class);

	public static final String MAIL_EVENTBUS_ADDRESS = "mail.outbox";
	public static final String MAIL_HEADER_FROM = "mail.from";
	public static final String MAIL_HEADER_TO = "mail.to";
	public static final String MAIL_HEADER_SUBJECT = "mail.subject";
	public static final String MAIL_HEADER_TEMPLATE = "mail.template";
	private MailClient mailClient;
	private String fallbackMailFrom;
	private String fallbackMailTo;
	private String fallbackMailSubject;

	Jinjava jinjava;

	@Override
	public void start(Promise<Void> startPromise) throws Exception {
		configureJinjava().onSuccess(jinjava -> {
			configureEmail().onSuccess(config -> {
				startPromise.complete();
			}).onFailure(ex -> {
				startPromise.fail(ex);
			});
		}).onFailure(ex -> {
			startPromise.fail(ex);
		});
		vertx.eventBus().consumer(MAIL_EVENTBUS_ADDRESS).handler(mailSender());
	}

	/**
	 **/
	public Future<Jinjava> configureJinjava() {
		Promise<Jinjava> promise = Promise.promise();

		try {
			jinjava = new Jinjava();
			String templatePath = config().getString(ComputateConfigKeys.TEMPLATE_PATH);
			if(!StringUtils.isBlank(templatePath))
				jinjava.setResourceLocator(new FileLocator(new File(templatePath)));
			promise.complete(jinjava);
		} catch(Exception ex) {
			LOG.error("Jinjava failed to initialize.", ex);
			promise.fail(ex);
		}

		return promise.future();
	}

	private Handler<Message<Object>> mailSender() {
		return new Handler<Message<Object>>() {

			@Override
			public void handle(Message<Object> event) {

				try {
					JsonObject body = new JsonObject(event.body().toString());
					MultiMap headers = event.headers();
					String emailTemplate = headers.get(MAIL_HEADER_TEMPLATE);

					String siteTemplatePath = config().getString(ComputateConfigKeys.TEMPLATE_PATH);
					Path resourceTemplatePath = Path.of(siteTemplatePath, emailTemplate);
					String template = siteTemplatePath == null ? Resources.toString(Resources.getResource(resourceTemplatePath.toString()), StandardCharsets.UTF_8) : Files.readString(resourceTemplatePath, Charset.forName("UTF-8"));
					String renderedTemplate = jinjava.render(template, body.getMap());
					Buffer buffer = Buffer.buffer(renderedTemplate);
	
					String mailFrom = headers.get(MAIL_HEADER_FROM);
					if(StringUtils.isBlank(mailFrom)) {
						mailFrom = fallbackMailFrom;
					}
	
					String mailTo = headers.get(MAIL_HEADER_TO);
					if(StringUtils.isBlank(mailTo)) {
						mailTo = fallbackMailTo;
					}
	
					String mailSubject = headers.get(MAIL_HEADER_SUBJECT);
					if(StringUtils.isBlank(mailSubject)) {
						mailSubject = fallbackMailSubject;
					}
	
					String html = buffer.toString();
					LOG.info("Sending mail from={}, to={}, subject={}", mailFrom, mailTo, mailSubject);
					MailMessage message = new MailMessage();
					message.setFrom(mailFrom);
					message.setTo(mailTo);
					message.setSubject(mailSubject);
					message.setHtml(html);
					mailClient.sendMail(message, result -> {
						if(result.succeeded()) {
							LOG.info(result.result().toString());
							event.reply(html);
						} else {
							LOG.error("sendMail failed. ", result.cause());
							event.reply(null);
						}
					});
				} catch(Exception ex) {
					LOG.error("Rendering email template failed. ", ex);
					event.reply(null);
				}
			}
		};
	}

	private Future<Void> configureEmail() {
		Promise<Void> promise = Promise.promise();
		try {
			MailConfig mailConfig = new MailConfig();
			mailConfig.setHostname(config().getString(ComputateConfigKeys.EMAIL_HOST));
			mailConfig.setPort(config().getInteger(ComputateConfigKeys.EMAIL_PORT));
			mailConfig.setSsl(config().getBoolean(ComputateConfigKeys.EMAIL_SSL));
			mailConfig.setUsername(config().getString(ComputateConfigKeys.EMAIL_USERNAME));
			mailConfig.setPassword(config().getString(ComputateConfigKeys.EMAIL_PASSWORD));
			mailConfig.setAuthMethods(config().getString(ComputateConfigKeys.EMAIL_AUTH_METHOD));
			this.fallbackMailFrom = config().getString(ComputateConfigKeys.EMAIL_FROM);
			this.fallbackMailTo = config().getString(ComputateConfigKeys.EMAIL_ADMIN);
			this.fallbackMailSubject = "";
			this.mailClient = MailClient.createShared(vertx, mailConfig);
			LOG.info("The email was configured successfully. ");
			promise.complete();
		} catch(Exception ex) {
			LOG.error("The email was not configured successfully. ", ex);
			promise.fail(ex);
		}
		return promise.future();
	}
}
