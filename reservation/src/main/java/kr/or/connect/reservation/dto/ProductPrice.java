package kr.or.connect.reservation.dto;

import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class ProductPrice {
	private int id;
	private int productId;
	private String priceTypeName;
	private int price;
	private double discountRate;
	private String createDate;
	private String modifyDate;
	
	public ProductPrice() {
		
	}

	public ProductPrice(int id, int productId, String priceTypeName, int price, double discountRate,
			Timestamp createDate, Timestamp modifyDate) {
		super();
		this.id = id;
		this.productId = productId;
		this.priceTypeName = priceTypeName;
		this.price = price;
		this.discountRate = discountRate;
		this.createDate = createDate.toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		this.modifyDate = modifyDate.toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getPriceTypeName() {
		return priceTypeName;
	}

	public void setPriceTypeName(String priceTypeName) {
		this.priceTypeName = priceTypeName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
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

	@Override
	public String toString() {
		return "ProductPrice [id=" + id + ", productId=" + productId + ", priceTypeName=" + priceTypeName + ", price="
				+ price + ", discountRate=" + discountRate + ", createDate=" + createDate + ", modifyDate=" + modifyDate
				+ "]";
	}
	
}
