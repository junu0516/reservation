package kr.or.connect.reservation.dto;


public class ReservationInfo {
	
	private int id;
	private int productId;
	private int cancelFlag;
	private int displayInfoId;
	private int userId;
	private String reservationDate;
	private String createDate;
	private String modifyDate;
	private Price prices;
	
	public ReservationInfo() {
		
	}

	public ReservationInfo(int id, int productId, int cancelFlag, int displayInfoId, int userId, String reservationDate,
			String createDate, String modifyDate, Price prices) {
		super();
		this.id = id;
		this.productId = productId;
		this.cancelFlag = cancelFlag;
		this.displayInfoId = displayInfoId;
		this.userId = userId;
		this.reservationDate = reservationDate;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.prices = prices;
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

	public int getCancelFlag() {
		return cancelFlag;
	}

	public void setCancelFlag(int cancelFlag) {
		this.cancelFlag = cancelFlag;
	}

	public int getDisplayInfoId() {
		return displayInfoId;
	}

	public void setDisplayInfoId(int displayInfoId) {
		this.displayInfoId = displayInfoId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Price getPrices() {
		return prices;
	}

	public void setPrices(Price prices) {
		this.prices = prices;
	}

	@Override
	public String toString() {
		return "ReservationInfo [id=" + id + ", productId=" + productId + ", cancelFlag=" + cancelFlag
				+ ", displayInfoId=" + displayInfoId + ", userId=" + userId + ", reservationDate=" + reservationDate
				+ ", createDate=" + createDate + ", modifyDate=" + modifyDate + ", prices=" + prices + "]";
	}
	
}
