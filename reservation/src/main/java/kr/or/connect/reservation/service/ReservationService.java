package kr.or.connect.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.CategoryDao;
import kr.or.connect.reservation.dto.Categories;

@Service
public class ReservationService {
	
	@Autowired
	CategoryDao categoryDao;
	
	public int plus(int value1, int value2) {
		return value1+value2;
	}
	
}
