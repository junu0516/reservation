package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.ReservationComment;

public interface ReservationCommentService {

	int getTotalCount(int productId);

	List<ReservationComment> getReservationComments(int productId, int start);

}
