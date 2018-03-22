package com.song.howdo.model;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Table(name = "howdo_user")
public class User extends BaseEntity {

	private String account;
	private String password;
	private String nickname;
	private String email;
	private String headPic;
	private Date birthday;
	private String signature;
	private String address;
	private String sex;
	
	@Transient
	private String remember;
	@Transient
	private String followed;//判断是否被关注
	@Transient
	private int age;
	@Transient
	private String constellation;
	@Transient
	private Long articleNum;
	@Transient
	private Long observedNum;
	@Transient
	private Long commentNum;
	@Transient
	private Long collectNum;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHeadPic() {
		return headPic;
	}
	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}
	public String getRemember() {
		return remember;
	}
	public void setRemember(String remember) {
		this.remember = remember;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getFollowed() {
		return followed;
	}

	public void setFollowed(String followed) {
		this.followed = followed;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getConstellation() {
		return constellation;
	}

	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}

	public Long getArticleNum() {
		return articleNum;
	}

	public void setArticleNum(Long articleNum) {
		this.articleNum = articleNum;
	}

	public Long getObservedNum() {
		return observedNum;
	}

	public void setObservedNum(Long observedNum) {
		this.observedNum = observedNum;
	}

	public Long getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(Long commentNum) {
		this.commentNum = commentNum;
	}

	public Long getCollectNum() {
		return collectNum;
	}

	public void setCollectNum(Long collectNum) {
		this.collectNum = collectNum;
	}
}
