package kr.or.connect.reservation.dto;

import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Product {
	
	private int id;
	private int categoryId;
	private int displayInfoId;
	private String name;
	private String description;
	private String content;
	private String event;
	private String openingHours;
	private String placeName;
	private String placeLot;
	private String placeStreet;
	private String tel;
	private String homepage;
	private String email;
	private String createDate;
	private String modifyDate;
	private int fileId;
	
	public Product() {
		
	}
	
	public Product(int id, int categoryId, int displayInfoId, String name, String description, String content,
			String event, String openingHours, String placeName, String placeLot, String placeStreet, String tel,
			String homepage, String email, Timestamp createDate, Timestamp modifyDate, int fileId) {

		this.id = id;
		this.categoryId = categoryId;
		this.displayInfoId = displayInfoId;
		this.name = name;
		this.description = description;
		this.content = content;
		this.event = event;
		this.openingHours = openingHours;
		this.placeName = placeName;
		this.placeLot = placeLot;
		this.placeStreet = placeStreet;
		this.tel = tel;
		this.homepage = homepage;
		this.email = email;
		this.createDate = createDate.toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		this.modifyDate = modifyDate.toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		this.fileId = fileId;
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

	public int getDisplayInfoId() {
		return displayInfoId;
	}

	public void setDisplayInfoId(int displayInfoId) {
		this.displayInfoId = displayInfoId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getOpeningHours() {
		return openingHours;
	}

	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getPlaceLot() {
		return placeLot;
	}

	public void setPlaceLot(String placeLot) {
		this.placeLot = placeLot;
	}

	public String getPlaceStreet() {
		return placeStreet;
	}

	public void setPlaceStreet(String placeStreet) {
		this.placeStreet = placeStreet;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate.toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate.toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", categoryId=" + categoryId + ", displayInfoId=" + displayInfoId + ", name="
				+ name + ", description=" + description + ", content=" + content + ", event=" + event
				+ ", openingHours=" + openingHours + ", placeName=" + placeName + ", placeLot=" + placeLot
				+ ", placeStreet=" + placeStreet + ", tel=" + tel + ", homepage=" + homepage + ", email=" + email
				+ ", createDate=" + createDate + ", modifyDate=" + modifyDate + ", fileId=" + fileId + "]";
	}
	
}
