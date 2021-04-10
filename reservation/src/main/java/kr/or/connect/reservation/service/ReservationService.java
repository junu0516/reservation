package kr.or.connect.reservation.service;

import java.util.HashMap;

import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.dto.ReservationInsertion;

public interface ReservationService {

	ReservationInfo insertReservationInfo(ReservationInsertion reservationInsertion);


}
