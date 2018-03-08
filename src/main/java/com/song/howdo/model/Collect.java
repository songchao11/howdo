package com.song.howdo.model;

import javax.persistence.Table;

@Table(name = "howdo_collect")
public class Collect extends BaseEntity {

	private Long userId;
	private Long artId;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getArtId() {
		return artId;
	}
	public void setArtId(Long artId) {
		this.artId = artId;
	}
	
	
	
}
