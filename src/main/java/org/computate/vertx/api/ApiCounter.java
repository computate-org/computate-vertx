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

	public void incrementTotalNum(Long num) {
		this.totalNum += num;
	}

	public void setTotalNum(Long totalNum) {
		this.totalNum = totalNum;
	}

	private Long totalNumOld;

	public Long getTotalNumOld() {
		return totalNumOld;
	}

	public void setTotalNumOld(Long totalNumOld) {
		this.totalNumOld = totalNumOld;
	}

	private Long queueNum;

	public Long getQueueNum() {
		return queueNum;
	}

	public void incrementQueueNum() {
		this.queueNum++;
	}

	public void incrementQueueNum(Long num) {
		this.queueNum += num;
	}

	public void decrementQueueNum() {
		this.queueNum--;
	}

	public void decrementQueueNum(Long num) {
		this.queueNum -= num;
	}

	public void setQueueNum(Long countNum) {
		this.queueNum = countNum;
	}

	private Long queueNumOld;

	public Long getQueueNumOld() {
		return queueNumOld;
	}

	public void setQueueNumOld(Long countNumOld) {
		this.queueNumOld = countNumOld;
	}
}
