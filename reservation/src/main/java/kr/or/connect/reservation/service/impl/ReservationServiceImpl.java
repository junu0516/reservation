package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ReservationDao;
import kr.or.connect.reservation.dto.Price;
import kr.or.connect.reservation.dto.PriceInsertion;
import kr.or.connect.reservation.dto.Reservation;
import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.dto.ReservationInsertion;
import kr.or.connect.reservation.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	ReservationDao reservationDao;

	@Override
	@Transactional
	public ReservationInfo insertReservationInfo(ReservationInsertion reservationInsertion) {
		
		System.out.println("service");
		
		//예약정보 먼저 등록 후 예약정보 id 반환
		int reservationInfoId = reservationDao.insertReservationInfo(reservationInsertion);
		
		//예약정보 id를 포함시켜서 가격정보 등록 
		PriceInsertion priceInsertion = reservationInsertion.getPrices();
		int priceInfoId = reservationDao.insertPriceInfo(priceInsertion,reservationInfoId);
		
		
		//가격정보를 포함한 최종 예약정보 조회하여 반환
		Price priceInfo = reservationDao.selectPriceInfo(priceInfoId);
		ReservationInfo reservationInfo = reservationDao.selectReservationInfo(reservationInfoId);
		reservationInfo.setPrices(priceInfo);
		
		return reservationInfo;
	}

	@Override
	public List<Reservation> selectReservations(int userId) {
		
		List<Reservation> reservations = reservationDao.selectReservations(userId);
		
		return reservations;
	}

	@Override
	@Transactional
	public String cancelReservation(Integer id) {
		
		int updateCount = reservationDao.cancelReservation(id);

		String result = "";
		if(updateCount>0) {
			result = "success";
		}else {
			result = "fail";
		}
		
		return result;
	}
}
