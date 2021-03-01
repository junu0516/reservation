package kr.or.connect.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.or.connect.reservation.dto.Promotions;
import kr.or.connect.reservation.service.PromotionService;

@RestController
@RequestMapping(path="/api")
public class PromotionController {
	
	@Autowired
	private PromotionService promotionService;
	
	@ApiOperation(value="프로모션 정보 구하기")
	@ApiResponses({
		@ApiResponse(code = 200, message = "정상 처리"),
		@ApiResponse(code = 500, message = "예외 발생")
	})
	@GetMapping("/promotions")
	public Promotions getPromotions() {
		Promotions promotions = new Promotions();
		
		promotions.setSize(promotionService.getPromotionCount());
		promotions.setItems(promotionService.getPromotions());
		
		return promotions;
	}
}
