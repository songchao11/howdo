package com.song.howdo.model;

import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "howdo_article")
public class Article extends BaseEntity {

	private String title;
	private String content;
	private String isPublish;
	private String isComment;
	private Long userId;
	private String enableFlag;
	private Long cateId;
	private Long readNum;

	@Transient
	private Long commentNum;
	@Transient
	private Long praiseNum;
	@Transient
	private Long collectNum;
	@Transient
	private String category;

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

	public Long getPraiseNum() {
		return praiseNum;
	}

	public void setPraiseNum(Long praiseNum) {
		this.praiseNum = praiseNum;
	}

	public Long getCollectNum() {
		return collectNum;
	}

	public void setCollectNum(Long collectNum) {
		this.collectNum = collectNum;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getIsComment() {
		return isComment;
	}

	public void setIsComment(String isComment) {
		this.isComment = isComment;
	}

	public Long getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(Long commentNum) {
		this.commentNum = commentNum;
	}

	@Override
	public String toString() {
		return "Article{" +
				"title='" + title + '\'' +
				", content='" + content + '\'' +
				", isPublish='" + isPublish + '\'' +
				", userId=" + userId +
				", enableFlag='" + enableFlag + '\'' +
				", cateId=" + cateId +
				", readNum=" + readNum +
				", commentNum=" + commentNum +
				'}';
	}
}
