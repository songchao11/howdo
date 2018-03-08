package com.song.howdo.model;

import javax.persistence.Table;

@Table(name = "howdo_role")
public class Role extends BaseEntity {

	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	
}
