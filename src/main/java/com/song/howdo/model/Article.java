package com.song.howdo.model;

import javax.persistence.Table;

@Table(name = "howdo_article")
public class Article extends BaseEntity {

	private String title;
	private String content;
	private String isPublish;
	private Long userId;
	private String enableFlag;
	private Long cateId;
	private Long readNum;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getIsPublish() {
		return isPublish;
	}
	public void setIsPublish(String isPublish) {
		this.isPublish = isPublish;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getEnableFlag() {
		return enableFlag;
	}
	public void setEnableFlag(String enableFlag) {
		this.enableFlag = enableFlag;
	}
	public Long getCateId() {
		return cateId;
	}
	public void setCateId(Long cateId) {
		this.cateId = cateId;
	}
	public Long getReadNum() {
		return readNum;
	}
	public void setReadNum(Long readNum) {
		this.readNum = readNum;
	}
	
	
	
}
