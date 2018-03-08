package com.song.howdo.model;

import javax.persistence.Table;

@Table(name = "howdo_concern")
public class Concern extends BaseEntity {

	private Long userId;
	private Long observed;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getObserved() {
		return observed;
	}
	public void setObserved(Long observed) {
		this.observed = observed;
	}
	
	
	
}
