package kr.or.connect.reservation.dto;

public class ReservationComment {
	
	private int id;
	private int productId;
	private int reservationInfoId;
	private int score;
	private String reservationEmail;
	private String comment;
	private String createDate;
	private String modifyDate;
	
	public ReservationComment() {
		
	}

	public ReservationComment(int id, int productId, int reservationInfoId, int score, String reservationEmail,
			String comment, String createDate, String modifyDate) {
		super();
		this.id = id;
		this.productId = productId;
		this.reservationInfoId = reservationInfoId;
		this.score = score;
		this.reservationEmail = reservationEmail;
		this.comment = comment;
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

	public int getReservationInfoId() {
		return reservationInfoId;
	}

	public void setReservationInfoId(int reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getReservationEmail() {
		return reservationEmail;
	}

	public void setReservationEmail(String reservationEmail) {
		this.reservationEmail = reservationEmail;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
		return "ReservationComment [id=" + id + ", productId=" + productId + ", reservationInfoId=" + reservationInfoId
				+ ", score=" + score + ", reservationEmail=" + reservationEmail + ", comment=" + comment
				+ ", createDate=" + createDate + ", modifyDate=" + modifyDate+ "]";
	}

}
