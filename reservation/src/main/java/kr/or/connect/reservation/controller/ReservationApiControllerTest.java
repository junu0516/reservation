package kr.or.connect.reservation.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.config.MvcConfig;
import kr.or.connect.reservation.dto.Categories;
import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.DisplayInfoImage;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.ProductPrice;
import kr.or.connect.reservation.dto.Products;
import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.dto.ReservationComment;
import kr.or.connect.reservation.service.CategoryService;
import kr.or.connect.reservation.service.DisplayInfoImageService;
import kr.or.connect.reservation.service.ProductImageService;
import kr.or.connect.reservation.service.ProductPriceService;
import kr.or.connect.reservation.service.ProductService;
import kr.or.connect.reservation.service.PromotionService;
import kr.or.connect.reservation.service.ReservationCommentService;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes= {MvcConfig.class, ApplicationConfig.class})
public class ReservationApiControllerTest {

		@InjectMocks
		public ReservationApiController reservationApiController;
		
		@Mock
		private CategoryService categoryService;
		
		@Mock
		private ProductService productService;
		
		@Mock
		private PromotionService promotionService;
		
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
			mockMvc = MockMvcBuilders.standaloneSetup(reservationApiController).addFilters(new CharacterEncodingFilter("UTF-8",true)).build();
			
		}
		
		@Test
		public void getCategories() throws Exception{
			
			Categories categories = new Categories();
			Category category = new Category(1,"전시",10);
			categories.setItems(Arrays.asList(category));
			categories.setSize(1);			
			
			when(categoryService.getCategories()).thenReturn(categories.getItems());
			
			RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/categories").contentType(MediaType.APPLICATION_JSON);
			mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print());
			
			verify(categoryService).getCategories();
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
		
		@Test
		public void getPromotions() throws Exception{
			
			Promotion promotion = new Promotion(1,1,1,"전시","너를 위한 선물",61);
			
			when(promotionService.getPromotions()).thenReturn(Arrays.asList(promotion));
			
			RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/promotions").contentType(MediaType.APPLICATION_JSON);
			mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print());
			
			verify(promotionService).getPromotions();
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
