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

/**
 * Keyword: classSimpleNameApiCounter
 */
public class ApiCounter {

	public ApiCounter() {
		totalNum = 0L;
		queueNum = 0L;
	}

	private Long totalNum;

	public Long getTotalNum() {
		return totalNum;
	}

	public void incrementTotalNum() {
		this.totalNum++;
	}

	public void setTotalNum(Long totalNum) {
		this.totalNum = totalNum;
	}

	private Long queueNum;

	public Long getQueueNum() {
		return queueNum;
	}

	public void incrementQueueNum() {
		this.queueNum++;
	}

	public void decrementQueueNum() {
		this.queueNum--;
	}

	public void setQueueNum(Long countNum) {
		this.queueNum = countNum;
	}
}
