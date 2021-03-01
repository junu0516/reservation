package kr.or.connect.reservation.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.service.PromotionService;

public class PromotionControllerTest {

	@InjectMocks
	public PromotionController promotionController;
	
	@Mock
	private PromotionService promotionService;
	
	private MockMvc mockMvc;
	
	@Before
	public void createController() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(promotionController).addFilters(new CharacterEncodingFilter("UTF-8",true)).build();
		
	}
	
	@Test
	public void getPromotions() throws Exception{
		
		Promotion promotion = new Promotion(1,1,1,"전시","너를 위한 선물",61);
		
		when(promotionService.getPromotions()).thenReturn(Arrays.asList(promotion));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/promotions").contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print());
		
		verify(promotionService).getPromotions();
	}
}
