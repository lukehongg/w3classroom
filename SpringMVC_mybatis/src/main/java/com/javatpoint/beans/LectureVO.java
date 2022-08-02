package com.javatpoint.beans;

public class LectureVO {
	
	private int lectureID;
	private String category;
	private String title;
	private String content;
	private String link;
	
	public LectureVO() {
		
	}
	
	public LectureVO(int lectureID, String category, String title, String content, String link) {
		super();
		this.lectureID = lectureID;
		this.category = category;
		this.title = title;
		this.content = content;
		this.link = link;
	}


	public int getLectureID() {
		return lectureID;
	}
	public void setLectureID(int lectureID) {
		this.lectureID = lectureID;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
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
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	
}
