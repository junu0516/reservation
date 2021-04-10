package kr.or.connect.reservation.dto;

public class ReservationInsertion {
	
	PriceInsertion prices;
	int productId;
	int displayInfoId;
	String reservationYearMonthDay;
	int userId;
	
	public ReservationInsertion() {
		
	}
	
	public ReservationInsertion(PriceInsertion prices, int productId, int displayInfoId, String reservationYearMonthDay,
			int userId) {
		super();
		this.prices = prices;
		this.productId = productId;
		this.displayInfoId = displayInfoId;
		this.reservationYearMonthDay = reservationYearMonthDay;
		this.userId = userId;
	}

	public PriceInsertion getPrices() {
		return prices;
	}

	public void setPrices(PriceInsertion prices) {
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

	public String getReservationYearMonthDay() {
		return reservationYearMonthDay;
	}

	public void setReservationYearMonthDay(String reservationYearMonthDay) {
		this.reservationYearMonthDay = reservationYearMonthDay;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ReservationInsertion [prices=" + prices + ", productId=" + productId + ", displayInfoId="
				+ displayInfoId + ", reservationYearMonthDay=" + reservationYearMonthDay + ", userId=" + userId + "]";
	}
	
}
