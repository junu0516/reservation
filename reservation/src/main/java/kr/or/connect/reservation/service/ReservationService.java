package kr.or.connect.reservation.service;

import java.util.HashMap;
import java.util.List;

import kr.or.connect.reservation.dto.Reservation;
import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.dto.ReservationInsertion;

public interface ReservationService {

	ReservationInfo insertReservationInfo(ReservationInsertion reservationInsertion);

	List<Reservation> selectReservations(int userId);

	String cancelReservation(Integer id);


}
