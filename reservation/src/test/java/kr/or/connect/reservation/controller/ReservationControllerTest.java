package kr.or.connect.reservation.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

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

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.connect.reservation.dto.Price;
import kr.or.connect.reservation.dto.PriceInsertion;
import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.dto.ReservationInsertion;
import kr.or.connect.reservation.service.ReservationService;

public class ReservationControllerTest {
	
	@InjectMocks
	public ReservationController reservationController;
	
	@Mock
	private ReservationService reservationService;
	
	private MockMvc mockMvc;
	
	private ObjectMapper objectMapper;
	
	
	@Before
	public void createController() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(reservationController).addFilters(new CharacterEncodingFilter("UTF-8",true)).build();
		objectMapper = new ObjectMapper();
	}
	
	@Test
	public void getReservationInfo() throws Exception{
		
		ReservationInsertion reservationInsertion = new ReservationInsertion();
		PriceInsertion priceInsertion = new PriceInsertion();
		
		priceInsertion.setCount(2);
		priceInsertion.setProductPriceId(3);
		
		reservationInsertion.setDisplayInfoId(1);
		reservationInsertion.setProductId(1);
		reservationInsertion.setUserId(1);
		reservationInsertion.setReservationYearMonthDay(Timestamp.valueOf(LocalDateTime.now()).toString());
		reservationInsertion.setPrices(priceInsertion);
		
		ReservationInfo reservationInfo = new ReservationInfo();
		reservationInfo.setId(0);
		reservationInfo.setProductId(1);
		reservationInfo.setCancelFlag(0);
		reservationInfo.setDisplayInfoId(1);
		reservationInfo.setUserId(1);
		reservationInfo.setReservationDate("1577890800000");
		reservationInfo.setCreateDate("1584369835893");
		reservationInfo.setModifyDate("1584369835893");
		
		Price priceInfo = new Price();
		priceInfo.setId(21);
		priceInfo.setRereservationInfoId(17);
		priceInfo.setProductPriceId(3);
		priceInfo.setCount(2);
		
		reservationInfo.setPrices(priceInfo);

		String content = objectMapper.writeValueAsString(reservationInsertion);
		
		when(reservationService.insertReservationInfo(reservationInsertion)).thenReturn(reservationInfo);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/reservationInfos").content(content).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(requestBuilder)
			   .andExpect(status().isOk())
			   .andDo(print());
	
		verify(reservationService).insertReservationInfo(reservationInsertion);
		
	}
}
