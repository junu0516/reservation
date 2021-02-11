package kr.or.connect.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.or.connect.reservation.dto.PlusResult;
import kr.or.connect.reservation.service.ReservationService;

@RestController
@RequestMapping(path="/api/reservation")
public class ReservationApiController {
	
	@Autowired
	private ReservationService reservationService;
	
	@ApiOperation(value="덧셈 테스트")
	@ApiResponses({
		@ApiResponse(code = 200, message="정상 처리됨"),
		@ApiResponse(code = 500, message ="예외 발생")
	})
	@GetMapping("/plus")
	public PlusResult plus(@RequestParam("value1") int value1, @RequestParam("value2") int value2) {
		PlusResult plusResult = new PlusResult();
		
		plusResult.setValue1(value1);
		plusResult.setValue2(value2);
		plusResult.setOperation("PLUS");
		plusResult.setResult(reservationService.plus(value1, value2));
		
		return plusResult;
	}
}
