package kr.or.connect.reservation.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.or.connect.reservation.dto.Categories;
import kr.or.connect.reservation.dto.DisplayInfos;
import kr.or.connect.reservation.dto.Products;
import kr.or.connect.reservation.dto.Promotions;
import kr.or.connect.reservation.dto.ReservationCommentInfos;
import kr.or.connect.reservation.service.CategoryService;
import kr.or.connect.reservation.service.DisplayInfoImageService;
import kr.or.connect.reservation.service.ProductImageService;
import kr.or.connect.reservation.service.ProductPriceService;
import kr.or.connect.reservation.service.ProductService;
import kr.or.connect.reservation.service.PromotionService;
import kr.or.connect.reservation.service.ReservationCommentService;

@RestController
@RequestMapping(path="/api")
public class ReservationApiController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private PromotionService promotionService;
	
	@Autowired
	private ProductImageService productImageService;
	
	@Autowired
	private DisplayInfoImageService displayInfoImageService;
	
	@Autowired
	private ProductPriceService productPriceService;
	
	@Autowired
	private ReservationCommentService reservationCommentService;
	
	
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
	@GetMapping("/products")
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
	
	@ApiOperation(value="전시 정보 구하기")
	@ApiResponses({
		@ApiResponse(code = 200, message = "정상 처리"),
		@ApiResponse(code = 500, message = "예외 발생")
	})
	@GetMapping("/displayinfos/{displayId}")
	public DisplayInfos getDisplayInfos(@PathVariable(name="displayId")int displayId, HttpServletRequest requset) {
		
		DisplayInfos displayInfos = new DisplayInfos();
		
		displayInfos.setProducts(productService.getProducts(displayId));
		displayInfos.setProductImages(productImageService.getImages(displayId));
		displayInfos.setDisplayInfoImages(displayInfoImageService.getImages(displayId));
		displayInfos.setAvgScore((int)productService.getAverageScore(displayId));
		displayInfos.setProductPrices(productPriceService.getPrices(displayId));
		
		return displayInfos;
	}
	
	@ApiOperation(value="댓글 목록 구하기")
	@ApiResponses({
		@ApiResponse(code = 200, message = "정상 처리"),
		@ApiResponse(code = 500, message = "예외 발생")
	})
	@GetMapping("/displayinfos")
	public ReservationCommentInfos getComments(@RequestParam(name="productId", required=false, defaultValue="0")int productId, @RequestParam(name="start", required=false, defaultValue="0")int start) {
		
		ReservationCommentInfos reservationCommentInfos = new ReservationCommentInfos();
		reservationCommentInfos.setTotalCount(reservationCommentService.getTotalCount(productId));
		reservationCommentInfos.setReservationuserComments(reservationCommentService.getReservationComments(productId,start));
		
		return reservationCommentInfos;
	}
}
