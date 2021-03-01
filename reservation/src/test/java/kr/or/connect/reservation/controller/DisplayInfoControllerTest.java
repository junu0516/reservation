package kr.or.connect.reservation.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import kr.or.connect.reservation.dto.DisplayInfoImage;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.ProductPrice;
import kr.or.connect.reservation.dto.ReservationComment;
import kr.or.connect.reservation.service.DisplayInfoImageService;
import kr.or.connect.reservation.service.ProductImageService;
import kr.or.connect.reservation.service.ProductPriceService;
import kr.or.connect.reservation.service.ProductService;
import kr.or.connect.reservation.service.ReservationCommentService;

public class DisplayInfoControllerTest {
	
	@InjectMocks
	public DisplayInfoController displayInfoController;
	
	@Mock
	private ProductService productService;
	
	@Mock
	private ProductImageService productImageService;
	
	@Mock
	private DisplayInfoImageService displayInfoImageService;
	
	@Mock
	private ProductPriceService productPriceService;
	
	@Mock
	private ReservationCommentService reservationCommentService;
	
	private MockMvc mockMvc;
	
	@Before
	public void createController() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(displayInfoController).addFilters(new CharacterEncodingFilter("UTF-8",true)).build();
	}
	
	@Test
	public void getProductImages() throws Exception{
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		ProductImage productImage = new ProductImage(1,2,"ma",61,"1_ma_2.png","img/1_ma_2.png","image/png",0,timestamp,timestamp);
		
		when(productImageService.getImages(1)).thenReturn(Arrays.asList(productImage));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/displayinfos/1").contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print());
		
		verify(productImageService).getImages(1);
	}
	
	@Test
	public void getDisplayInfoImages() throws Exception{
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		DisplayInfoImage displayInfoImage = new DisplayInfoImage(1,1,1,"1_map_1.png","img_map/1_map_1.png","image/png",0,timestamp,timestamp);
		
		when(displayInfoImageService.getImages(1)).thenReturn(Arrays.asList(displayInfoImage));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/displayinfos/1").contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print());
		
		verify(displayInfoImageService).getImages(1);
	}
	
	@Test
	public void getProductPrices() throws Exception{
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		ProductPrice productPrice = new ProductPrice(3,1,"B",2000,50,timestamp,timestamp);
		
		when(productPriceService.getPrices(1)).thenReturn(Arrays.asList(productPrice));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/displayinfos/1").contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print());
		
		verify(productPriceService).getPrices(1);
	}
	
	@Test
	public void getReservationCommentInfos() throws Exception{
		
		ReservationComment reservationComment = new ReservationComment(15,1,15,5,"dorosi@connect.co.kr","즐거움!!!", "2020-03-16 15:49:48.0", "2020-03-16 15:49:48.0");
		
		when(reservationCommentService.getReservationComments(1,0)).thenReturn(Arrays.asList(reservationComment));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/displayinfos").param("productId","1").param("start", "0").contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print());
		
		verify(reservationCommentService).getReservationComments(1, 0);
	}
	
}
