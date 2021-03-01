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

import kr.or.connect.reservation.dto.Categories;
import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.service.CategoryService;

public class CategoryControllerTest {

	@InjectMocks
	public CategoryController categoryController;
	
	@Mock
	private CategoryService categoryService;
	
	private MockMvc mockMvc;
	
	@Before
	public void createController() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(categoryController).addFilters(new CharacterEncodingFilter("UTF-8",true)).build();
		
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
}
