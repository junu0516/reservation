package kr.or.connect.reservation.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.or.connect.reservation.dto.Price;
import kr.or.connect.reservation.dto.Reservation;
import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.dto.ReservationInsertion;
import kr.or.connect.reservation.dto.Reservations;
import kr.or.connect.reservation.dto.User;
import kr.or.connect.reservation.service.ReservationService;
import kr.or.connect.reservation.service.UserService;

@RestController
@RequestMapping(path="/api")
public class ReservationController {
	
	//service Bean 선언
	@Autowired
	UserService userService;
	
	@Autowired
	ReservationService reservationService;
	
	@ApiOperation(value="주문 정보 구하기")
	@ApiResponses({
		@ApiResponse(code = 200, message = "정상 처리"),
		@ApiResponse(code = 500, message = "예외 발생")
	})
	@PostMapping("/reservationInfos")
	public ReservationInfo insertReservationInfos(@RequestBody ReservationInsertion reservationInsertion) {
		
		ReservationInfo reservationInfo = reservationService.insertReservationInfo(reservationInsertion);
		
		return reservationInfo;
	}
	
	@ApiOperation(value="예약 등록하기")
	@ApiResponses({
		@ApiResponse(code = 200, message = "정상 처리"),
		@ApiResponse(code = 500, message = "예외 발생")
	})
	@GetMapping("/reservationInfos")
	public Reservations selectReservatios(Principal principal) {
		
		String loginEmail = principal.getName();
		User user = userService.getUserByEmail(loginEmail);
		int userId = Integer.parseInt(user.getUserId());
		
		List<Reservation> reservationList = reservationService.selectReservations(userId);
		Reservations reservations = new Reservations();
		reservations.setSize(reservationList.size());
		reservations.setItems(reservationList);
		
		return reservations;
	}
	
	@ApiOperation(value="예약 취소하기")
	@ApiResponses({
		@ApiResponse(code = 200, message = "정상 처리"),
		@ApiResponse(code = 500, message = "예외 발생")
	})
	@PutMapping("/reservationInfos")
	public String cancelReservation(@RequestBody Integer id) {
		
		String result = reservationService.cancelReservation(id);

		return result;
	}
}
