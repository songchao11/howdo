package com.song.howdo.model;

import javax.persistence.Table;

@Table(name = "howdo_praise")
public class Praise extends BaseEntity {

	private Long artId;
	private Long userId;
	public Long getArtId() {
		return artId;
	}
	public void setArtId(Long artId) {
		this.artId = artId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
	
}
