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

import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.service.ProductService;

public class ProductControllerTest {
	
	@InjectMocks
	public ProductController productController;
	
	@Mock
	private ProductService productService;
	
	private MockMvc mockMvc;
	
	@Before
	public void createController() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(productController).addFilters(new CharacterEncodingFilter("UTF-8",true)).build();
		
	}
	
	@Test
	public void getProducts() throws Exception{
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Product product = new Product(21,3,21,"콘서트","5TARDIUM 2018","Surrealistic EDM Festival with Magnificent Stage and Performances. 2 Days, 10 Artists for 5th Anniversary!","","2017년 12월 12일(토) 12PM","장소 추후 공개","서울특별시 중구 태평로1가 31","서울특별시 중구 세종대로 110","010-3360-7846","","",timestamp,timestamp,113);
		
		when(productService.getProducts(0,0)).thenReturn(Arrays.asList(product));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/products").param("categoryId","0").param("start", "0").contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print());
		
		verify(productService).getProducts(0,0);	
	}
}
