/*
 * Copyright Computate Limited Liability Company in Utah, USA. 
 * SPDX-License-Identifier: AGPL-3.0
 * This program and the accompanying materials are made available under the
 * terms of the GNU AFFERO GENERAL PUBLIC LICENSE which is available at
 * 
 * https://www.gnu.org/licenses/agpl-3.0.html
 * 
 * You may not propagate or modify a covered work except as expressly provided 
 * under this License. Any attempt otherwise to propagate or modify it is void, 
 * and will automatically terminate your rights under this License (including 
 * any patent licenses granted under the third paragraph of section 11).
 */
package org.computate.vertx.api;

import org.computate.i18n.I18n;
import org.computate.vertx.openapi.ComputateOAuth2AuthHandlerImpl;

import com.hubspot.jinjava.Jinjava;

import io.vertx.amqp.AmqpClient;
import io.vertx.amqp.AmqpSender;
import io.vertx.core.Vertx;
import io.vertx.core.WorkerExecutor;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.authorization.AuthorizationProvider;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import io.vertx.ext.web.client.WebClient;
import io.vertx.kafka.client.producer.KafkaProducer;
import io.vertx.mqtt.MqttClient;
import io.vertx.rabbitmq.RabbitMQClient;
import io.vertx.sqlclient.Pool;

public interface BaseApiServiceInterface {

	public void setOauth2AuthHandler(ComputateOAuth2AuthHandlerImpl oauth2AuthHandler);
	public void setVertx(Vertx vertx);
	public void setEventBus(EventBus eventBus);
	public void setConfig(JsonObject config);
	public void setWorkerExecutor(WorkerExecutor workerExecutor);
	public void setPgPool(Pool pgPool);
	public void setKafkaProducer(KafkaProducer<String, String> kafkaProducer);
	public void setMqttClient(MqttClient mqttClient);
	public void setAmqpClient(AmqpClient amqpClient);
	public void setAmqpSender(AmqpSender amqpSender);
	public void setRabbitmqClient(RabbitMQClient rabbitmqClient);
	public void setWebClient(WebClient webClient);
	public void setOauth2AuthenticationProvider(OAuth2Auth oauth2AuthenticationProvider);
	public void setAuthorizationProvider(AuthorizationProvider authorizationProvider);
	public void setJinjava(Jinjava jinjava);
	public void setI18n(JsonObject i18n);
}
