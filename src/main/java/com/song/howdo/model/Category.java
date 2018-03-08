package com.song.howdo.model;

import javax.persistence.Table;

@Table(name = "howdo_category")
public class Category extends BaseEntity {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
