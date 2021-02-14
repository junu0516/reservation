package kr.or.connect.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.or.connect.reservation.dto.Categories;
import kr.or.connect.reservation.dto.Products;
import kr.or.connect.reservation.dto.Promotions;
import kr.or.connect.reservation.service.CategoryService;
import kr.or.connect.reservation.service.ProductService;
import kr.or.connect.reservation.service.PromotionService;

@RestController
@RequestMapping(path="/api")
public class ReservationApiController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private PromotionService promotionService;
	
	
	@ApiOperation(value="카테고리 목록 구하기")
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
	
	@ApiOperation(value="상품 목록 구하기")
	@ApiResponses({
		@ApiResponse(code = 200, message = "정상 처리"),
		@ApiResponse(code = 500, message = "예외 발생")
	})
	@GetMapping("/displayinfos")
	public Products getProducts(@RequestParam(name="categoryId",required=false,defaultValue="0")int categoryId, @RequestParam(name="start", required=false, defaultValue="0")int start) {
		Products products = new Products();
		
		products.setItems(productService.getProducts(categoryId,start));
		products.setTotalCount(productService.getTotalCount(categoryId));
		
		return products;
	}
	
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
