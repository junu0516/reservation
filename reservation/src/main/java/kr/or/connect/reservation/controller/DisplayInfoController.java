package kr.or.connect.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.or.connect.reservation.dto.DisplayInfos;
import kr.or.connect.reservation.dto.ReservationCommentInfos;
import kr.or.connect.reservation.service.DisplayInfoImageService;
import kr.or.connect.reservation.service.ProductImageService;
import kr.or.connect.reservation.service.ProductPriceService;
import kr.or.connect.reservation.service.ProductService;
import kr.or.connect.reservation.service.ReservationCommentService;

@RestController
@RequestMapping(path="/api")
public class DisplayInfoController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductImageService productImageService;
	
	@Autowired
	private ProductPriceService productPriceService;
	
	@Autowired
	private ReservationCommentService reservationCommentService;
	
	@Autowired
	private DisplayInfoImageService displayInfoImageService;
	
	@ApiOperation(value="전시 정보 구하기")
	@ApiResponses({
		@ApiResponse(code = 200, message = "정상 처리"),
		@ApiResponse(code = 500, message = "예외 발생")
	})
	@GetMapping("/displayinfos/{displayId}")
	public DisplayInfos getDisplayInfos(@PathVariable int displayId) {
		
		DisplayInfos displayInfos = new DisplayInfos();
		
		displayInfos.setProducts(productService.getProducts(displayId));
		displayInfos.setProductImages(productImageService.getImages(displayId));
		displayInfos.setDisplayInfoImages(displayInfoImageService.getImages(displayId));
		displayInfos.setAvgScore(productService.getAverageScore(displayId));
		displayInfos.setProductPrices(productPriceService.getPrices(displayId));
		
		return displayInfos;
	}
	
	@ApiOperation(value="댓글 목록 구하기")
	@ApiResponses({
		@ApiResponse(code = 200, message = "정상 처리"),
		@ApiResponse(code = 500, message = "예외 발생")
	})
	@GetMapping("/displayinfos")
	public ReservationCommentInfos getComments(@RequestParam(defaultValue="0")int productId, @RequestParam(defaultValue="0")int start) {
		
		ReservationCommentInfos reservationCommentInfos = new ReservationCommentInfos();
		reservationCommentInfos.setTotalCount(reservationCommentService.getTotalCount(productId));
		reservationCommentInfos.setReservationuserComments(reservationCommentService.getReservationComments(productId,start));
		
		return reservationCommentInfos;
	}
}
