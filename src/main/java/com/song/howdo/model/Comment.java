package com.song.howdo.model;

import javax.persistence.Table;

@Table(name = "howdo_comment")
public class Comment extends BaseEntity {

	private String content;
	private Long userId;
	private Long artId;
	private Long parId;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
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
	public Long getParId() {
		return parId;
	}
	public void setParId(Long parId) {
		this.parId = parId;
	}
	
	
	
}
