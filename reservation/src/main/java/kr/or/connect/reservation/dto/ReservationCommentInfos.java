package kr.or.connect.reservation.dto;

import java.util.List;

public class ReservationCommentInfos {
	private int totalCount;
	private final int commentCount = 5;
	private List<ReservationComment> reservationuserComments;
	
	public ReservationCommentInfos() {
		
	}
	
	public ReservationCommentInfos(int totalCount, List<ReservationComment> reservationuserComments) {
		super();
		this.totalCount = totalCount;
		this.reservationuserComments = reservationuserComments;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<ReservationComment> getReservationuserComments() {
		return reservationuserComments;
	}

	public void setReservationuserComments(List<ReservationComment> reservationuserComments) {
		this.reservationuserComments = reservationuserComments;
	}

	public int getCommentCount() {
		return commentCount;
	}

	@Override
	public String toString() {
		return "ReservationCommentInfos [totalCount=" + totalCount + ", commentCount=" + commentCount
				+ ", reservationuserComments=" + reservationuserComments + "]";
	}
	
}
