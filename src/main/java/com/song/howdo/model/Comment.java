package com.song.howdo.model;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Table(name = "howdo_comment")
public class Comment extends BaseEntity {

	private String content;
	private Long userId;
	private Long artId;
	private Long parId;

	@Transient
	private String nickname;
	@Transient
	private String headPic;
	@Transient
	private List<Comment> childComm;

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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getHeadPic() {
		return headPic;
	}

	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}

	public List<Comment> getChildComm() {
		return childComm;
	}

	public void setChildComm(List<Comment> childComm) {
		this.childComm = childComm;
	}
}
