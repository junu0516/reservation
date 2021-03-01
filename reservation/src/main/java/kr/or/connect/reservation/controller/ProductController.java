package kr.or.connect.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.or.connect.reservation.dto.Products;
import kr.or.connect.reservation.service.ProductService;

@RestController
@RequestMapping(path="/api")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@ApiOperation(value="상품 목록 구하기")
	@ApiResponses({
		@ApiResponse(code = 200, message = "정상 처리"),
		@ApiResponse(code = 500, message = "예외 발생")
	})
	@GetMapping("/products")
	public Products getProducts(@RequestParam(defaultValue="0")int categoryId, @RequestParam(defaultValue="0")int start) {
		Products products = new Products();
		
		products.setItems(productService.getProducts(categoryId,start));
		products.setTotalCount(productService.getTotalCount(categoryId));
		
		return products;
	}
	
}
