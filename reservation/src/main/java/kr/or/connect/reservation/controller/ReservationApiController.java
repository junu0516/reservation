package kr.or.connect.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.or.connect.reservation.dto.Categories;
import kr.or.connect.reservation.service.CategoryService;

@RestController
@RequestMapping(path="/api")
public class ReservationApiController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	@ApiOperation(value="카테고리 리스트 테스트")
	@ApiResponses({
		@ApiResponse(code = 200, message = "정상 처리"),
		@ApiResponse(code = 500, message = "예외 발생")
	})
	@GetMapping("/categories")
	public Categories getCategories() {
		Categories categories = new Categories();
		categories.setItems(categoryService.getCategories());
		categories.setSize(categories.getItems().size());
		
		return categories;
	}
	
}
