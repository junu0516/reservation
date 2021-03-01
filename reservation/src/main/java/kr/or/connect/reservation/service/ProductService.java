package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.Product;

public interface ProductService {
	
	List<Product> getProducts(int categoryId, int start);
	
	int getTotalCount(int categoryId);

	List<Product> getProducts(int displayId);

	int getAverageScore(int displayId);

}
