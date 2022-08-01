package com.javatpoint.beans;

public class LectureVO {
	private int id;
	private String category;
	private String title;
	private String content;
	private String link;
	public LectureVO() {
		
	}
	public LectureVO(int id, String category, String title, String content, String link) {
		super();
		this.id = id;
		this.category = category;
		this.title = title;
		this.content = content;
		this.link = link;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
