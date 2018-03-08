package com.song.howdo.model;

import javax.persistence.Table;

@Table(name = "howdo_file")
public class File extends BaseEntity {

	private String name;
	private String path;
	private String type;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
