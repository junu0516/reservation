package kr.or.connect.reservation.dto;

import java.time.*;

public class Product {
	
	private int id;
	private int categoryId;
	private String description;
	private String content;
	private String event;
	private LocalDate createDate;
	private LocalDate modifyDate;
	
	public Product() {
		
	}
	
	public Product(int id, int categoryId, String description, String content, String event, LocalDate createDate,
			LocalDate modifyDate) {
		this.id = id;
		this.categoryId = categoryId;
		this.description = description;
		this.content = content;
		this.event = event;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getEvent() {
		return event;
	}
	
	public void setEvent(String event) {
		this.event = event;
	}
	
	public LocalDate getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	
	public LocalDate getModifyDate() {
		return modifyDate;
	}
	
	public void setModifyDate(LocalDate modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", categoryId=" + categoryId + ", description=" + description + ", content="
				+ content + ", event=" + event + ", createDate=" + createDate + ", modifyDate=" + modifyDate + "]";
	}

}
