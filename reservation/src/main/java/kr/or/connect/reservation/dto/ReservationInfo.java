package kr.or.connect.reservation.dto;

import java.util.ArrayList;

public class ReservationInfo {
	
	ArrayList<Price> prices;
	int productId;
	int displayInfoId;
	String reservationyearMonthDay;
	int userId;
	
	public ReservationInfo() {
		
	}
	
	public ReservationInfo(ArrayList<Price> prices, int productId, int displayInfoId, String reservationyearMonthDay,
			int userId) {
		super();
		this.prices = prices;
		this.productId = productId;
		this.displayInfoId = displayInfoId;
		this.reservationyearMonthDay = reservationyearMonthDay;
		this.userId = userId;
	}

	public ArrayList<Price> getPrices() {
		return prices;
	}

	public void setPrices(ArrayList<Price> prices) {
		this.prices = prices;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getDisplayInfoId() {
		return displayInfoId;
	}

	public void setDisplayInfoId(int displayInfoId) {
		this.displayInfoId = displayInfoId;
	}

	public String getReservationyearMonthDay() {
		return reservationyearMonthDay;
	}

	public void setReservationyearMonthDay(String reservationyearMonthDay) {
		this.reservationyearMonthDay = reservationyearMonthDay;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ReservationInfo [prices=" + prices + ", productId=" + productId + ", displayInfoId=" + displayInfoId
				+ ", reservationyearMonthDay=" + reservationyearMonthDay + ", userId=" + userId + "]";
	}
	
}
