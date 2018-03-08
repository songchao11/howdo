package com.song.howdo.model;

import javax.persistence.Table;

@Table(name = "howdo_art_file")
public class ArtFile extends BaseEntity {

	private Long artId;
	private Long fileId;
	public Long getArtId() {
		return artId;
	}
	public void setArtId(Long artId) {
		this.artId = artId;
	}
	public Long getFileId() {
		return fileId;
	}
	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}
	
	
	
}
