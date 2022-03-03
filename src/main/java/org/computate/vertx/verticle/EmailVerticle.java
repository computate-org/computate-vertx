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

import org.apache.commons.lang3.StringUtils;
import org.computate.vertx.config.ComputateVertxConfigKeys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Promise;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.mail.MailClient;
import io.vertx.ext.mail.MailConfig;
import io.vertx.ext.mail.MailMessage;
import io.vertx.ext.web.templ.handlebars.HandlebarsTemplateEngine;

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

	private HandlebarsTemplateEngine templateEngine;

	@Override
	public void start(Promise<Void> startPromise) throws Exception {
		configureEmail().onSuccess(config -> {
			configureTemplateEngine().onSuccess(templateEngine -> {
				startPromise.complete();
			}).onFailure(ex -> {
				startPromise.fail(ex);
			});
		}).onFailure(ex -> {
			startPromise.fail(ex);
		});
		vertx.eventBus().consumer(MAIL_EVENTBUS_ADDRESS).handler(mailSender());
	}

	private Handler<Message<Object>> mailSender() {
		return new Handler<Message<Object>>() {

			@Override
			public void handle(Message<Object> event) {

				try {
					JsonObject params = ((JsonObject)event.body()).getJsonObject("context").getJsonObject("params");
					JsonObject body = params.getJsonObject("body");
					JsonObject headers = params.getJsonObject("header");
					String mailTemplate = headers.getString(MAIL_HEADER_TEMPLATE);
					String templatePath = config().getString(ComputateVertxConfigKeys.TEMPLATE_PATH);
	
					body.put(ComputateVertxConfigKeys.STATIC_BASE_URL, config().getString(ComputateVertxConfigKeys.STATIC_BASE_URL));
					body.put(ComputateVertxConfigKeys.SITE_BASE_URL, config().getString(ComputateVertxConfigKeys.STATIC_BASE_URL));
					body.put(ComputateVertxConfigKeys.AUTH_URL, config().getString(ComputateVertxConfigKeys.AUTH_URL));
					body.put(ComputateVertxConfigKeys.AUTH_REALM, config().getString(ComputateVertxConfigKeys.AUTH_REALM));
					body.put("staticBaseUrl", config().getString(ComputateVertxConfigKeys.STATIC_BASE_URL));
					body.put("siteBaseUrl", config().getString(ComputateVertxConfigKeys.SITE_BASE_URL));
					templateEngine.render(body, String.format("%s/%s", templatePath, mailTemplate)).onSuccess(buffer -> {
	
						String mailFrom = headers.getString(MAIL_HEADER_FROM);
						if(StringUtils.isBlank(mailFrom)) {
							mailFrom = fallbackMailFrom;
						}
	
						String mailTo = headers.getString(MAIL_HEADER_TO);
						if(StringUtils.isBlank(mailTo)) {
							mailTo = fallbackMailTo;
						}
	
						String mailSubject = headers.getString(MAIL_HEADER_SUBJECT);
						if(StringUtils.isBlank(mailSubject)) {
							mailSubject = fallbackMailSubject;
						}
	
						String html = buffer.toString();
						LOG.debug("Sending mail from={}, to={}, subject={}", mailFrom, mailTo, mailSubject);
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
					}).onFailure(ex -> {
						LOG.error("Rendering email template failed. ", ex);
						event.reply(null);
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
			mailConfig.setHostname(config().getString(ComputateVertxConfigKeys.EMAIL_HOST));
			mailConfig.setPort(config().getInteger(ComputateVertxConfigKeys.EMAIL_PORT));
			mailConfig.setSsl(config().getBoolean(ComputateVertxConfigKeys.EMAIL_SSL));
			mailConfig.setUsername(config().getString(ComputateVertxConfigKeys.EMAIL_USERNAME));
			mailConfig.setPassword(config().getString(ComputateVertxConfigKeys.EMAIL_PASSWORD));
			this.fallbackMailFrom = config().getString(ComputateVertxConfigKeys.EMAIL_FROM);
			this.fallbackMailTo = config().getString(ComputateVertxConfigKeys.EMAIL_ADMIN);
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

	/**	
	 * Val.Fail.enUS:The template engine was not configured properly. 
	 * Val.Complete.enUS:The template engine was configured properly. 
	 */
	private Future<HandlebarsTemplateEngine> configureTemplateEngine() {
		Promise<HandlebarsTemplateEngine> promise = Promise.promise();
		try {
			templateEngine = HandlebarsTemplateEngine.create(vertx);
			LOG.info(configureTemplateEngineComplete);
			promise.complete(templateEngine);
		} catch(Exception ex) {
			LOG.error(configureTemplateEngineFail, ex);
			promise.fail(ex);
		}
		return promise.future();
	}
}
