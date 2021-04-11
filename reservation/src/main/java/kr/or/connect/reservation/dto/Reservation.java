package kr.or.connect.reservation.dto;

public class Reservation {
	
	private int id;
	private int productId;
	private int displayInfoId;
	private int cancelFlag;
	private String productDescription;
	private String productContent;
	private int userId;
	private int sumPrice;
	private String reservationDate;
	private String createDate;
	private String modifyDate;
	
	public Reservation() {
		
	}

	public Reservation(int id, int productId, int displayInfoId, int cancelFlag, String productDescription,
			String productContent, int userId, int sumPrice, String reservationDate, String createDate,
			String modifyDate) {
		super();
		this.id = id;
		this.productId = productId;
		this.displayInfoId = displayInfoId;
		this.cancelFlag = cancelFlag;
		this.productDescription = productDescription;
		this.productContent = productContent;
		this.userId = userId;
		this.sumPrice = sumPrice;
		this.reservationDate = reservationDate;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
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

	public int getDisplayInfoId() {
		return displayInfoId;
	}

	public void setDisplayInfoId(int displayInfoId) {
		this.displayInfoId = displayInfoId;
	}

	public int getCancelFlag() {
		return cancelFlag;
	}

	public void setCancelFlag(int cancelFlag) {
		this.cancelFlag = cancelFlag;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductContent() {
		return productContent;
	}

	public void setProductContent(String productContent) {
		this.productContent = productContent;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(int sumPrice) {
		this.sumPrice = sumPrice;
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

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", productId=" + productId + ", displayInfoId=" + displayInfoId
				+ ", cancelFlag=" + cancelFlag + ", productDescription=" + productDescription + ", productContent="
				+ productContent + ", userId=" + userId + ", sumPrice=" + sumPrice + ", reservationDate="
				+ reservationDate + ", createDate=" + createDate + ", modifyDate=" + modifyDate + "]";
	}
	
}
