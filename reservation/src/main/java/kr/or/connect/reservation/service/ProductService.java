package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.Product;

public interface ProductService {
	
	public List<Product> getProducts(int categoryId, int start);
	
	public int getTotalCount(int categoryId);

}
