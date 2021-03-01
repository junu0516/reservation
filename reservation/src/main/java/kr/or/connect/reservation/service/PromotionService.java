package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.Promotion;

public interface PromotionService {

	List<Promotion> getPromotions();
	
	int getPromotionCount();
}
