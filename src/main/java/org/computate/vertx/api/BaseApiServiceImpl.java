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
package org.computate.vertx.api;

import org.computate.vertx.openapi.ComputateOAuth2AuthHandlerImpl;

import com.hubspot.jinjava.Jinjava;

import io.vertx.core.WorkerExecutor;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.authorization.AuthorizationProvider;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import io.vertx.ext.web.client.WebClient;
import io.vertx.kafka.client.producer.KafkaProducer;
import io.vertx.mqtt.MqttClient;
import io.vertx.amqp.AmqpSender;
import io.vertx.rabbitmq.RabbitMQClient;
import io.vertx.pgclient.PgPool;
import io.vertx.core.Vertx;

public abstract class BaseApiServiceImpl extends BaseApiServiceModel {

	public BaseApiServiceImpl(Vertx vertx, JsonObject config, WorkerExecutor workerExecutor, ComputateOAuth2AuthHandlerImpl oauth2AuthHandler, PgPool pgPool, KafkaProducer<String, String> kafkaProducer, MqttClient mqttClient, AmqpSender amqpSender, RabbitMQClient rabbitmqClient, WebClient webClient) {
		this.vertx = vertx;
		this.eventBus = vertx.eventBus();
		this.config = config;
		this.workerExecutor = workerExecutor;
		this.oauth2AuthHandler = oauth2AuthHandler;
		this.pgPool = pgPool;
		this.kafkaProducer = kafkaProducer;
		this.mqttClient = mqttClient;
		this.amqpSender = amqpSender;
		this.rabbitmqClient = rabbitmqClient;
		this.webClient = webClient;
	}

	public BaseApiServiceImpl(Vertx vertx, JsonObject config, WorkerExecutor workerExecutor, ComputateOAuth2AuthHandlerImpl oauth2AuthHandler, PgPool pgPool, KafkaProducer<String, String> kafkaProducer, MqttClient mqttClient, AmqpSender amqpSender, RabbitMQClient rabbitmqClient, WebClient webClient, OAuth2Auth oauth2AuthenticationProvider, AuthorizationProvider authorizationProvider) {
		this.vertx = vertx;
		this.eventBus = vertx.eventBus();
		this.config = config;
		this.workerExecutor = workerExecutor;
		this.oauth2AuthHandler = oauth2AuthHandler;
		this.pgPool = pgPool;
		this.kafkaProducer = kafkaProducer;
		this.mqttClient = mqttClient;
		this.amqpSender = amqpSender;
		this.rabbitmqClient = rabbitmqClient;
		this.webClient = webClient;
		this.oauth2AuthenticationProvider = oauth2AuthenticationProvider;
		this.authorizationProvider = authorizationProvider;
	}

	public BaseApiServiceImpl(Vertx vertx, JsonObject config, WorkerExecutor workerExecutor, ComputateOAuth2AuthHandlerImpl oauth2AuthHandler, PgPool pgPool, KafkaProducer<String, String> kafkaProducer, MqttClient mqttClient, AmqpSender amqpSender, RabbitMQClient rabbitmqClient, WebClient webClient, OAuth2Auth oauth2AuthenticationProvider, AuthorizationProvider authorizationProvider, Jinjava jinjava) {
		this.vertx = vertx;
		this.eventBus = vertx.eventBus();
		this.config = config;
		this.workerExecutor = workerExecutor;
		this.oauth2AuthHandler = oauth2AuthHandler;
		this.pgPool = pgPool;
		this.kafkaProducer = kafkaProducer;
		this.mqttClient = mqttClient;
		this.amqpSender = amqpSender;
		this.rabbitmqClient = rabbitmqClient;
		this.webClient = webClient;
		this.oauth2AuthenticationProvider = oauth2AuthenticationProvider;
		this.authorizationProvider = authorizationProvider;
		this.jinjava = jinjava;
	}
}
