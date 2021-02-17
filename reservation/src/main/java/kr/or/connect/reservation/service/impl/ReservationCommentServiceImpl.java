package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ReservationCommentDao;
import kr.or.connect.reservation.dto.ReservationComment;
import kr.or.connect.reservation.service.ReservationCommentService;

@Service
public class ReservationCommentServiceImpl implements ReservationCommentService {

	@Autowired
	ReservationCommentDao reservationCommentDao;
	
	@Override
	@Transactional
	public int getTotalCount(int productId) {
		
		return reservationCommentDao.getTotalCount(productId);
	}

	@Override
	@Transactional
	public List<ReservationComment> getReservationComments(int productId, int start) {
	
		return reservationCommentDao.getReservationComments(productId,start);
	}

}
