package kr.or.connect.reservation.controller;

import java.security.Principal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@ApiOperation(value="예약 등록하기")
	@ApiResponses({
		@ApiResponse(code = 200, message = "정상 처리"),
		@ApiResponse(code = 500, message = "예외 발생")
	})
	@PostMapping("/reservationInfos")
	public ReservationInfo insertReservationInfos(@RequestBody ReservationInsertion reservationInsertion) {
		
		//요청 Body예제와 같은 형식으로 요청 메시지가 나와야 함
		/*
		 * 요청 Body 예제
		 * 
		 * {
		 * "prices":[
		 * 	  {
		 * 		"count":2, 
		 * 		"productPriceId":3
		 * 	  }
		 * 	],
		 * "productId":1,
		 * "displayInfoId":1,
		 * "reservationYearMonthDay": "2020.01.02",
		 * "userId": 1 
		 * }
		 * */
		
		ReservationInfo reservationInfo = reservationService.insertReservationInfo(reservationInsertion);
		
		return reservationInfo;
	}
	
	@ApiOperation(value="예약 등록하기")
	@ApiResponses({
		@ApiResponse(code = 200, message = "정상 처리"),
		@ApiResponse(code = 500, message = "예외 발생")
	})
	@GetMapping("/reservationInfos")
	public Reservations selectReservatios() {
		
		
		
		return null;
	} 
}
