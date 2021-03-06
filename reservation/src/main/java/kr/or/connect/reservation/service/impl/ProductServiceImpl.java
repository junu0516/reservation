package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ProductDao;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao productDao;

	@Override
	public List<Product> getProducts(int categoryId, int start) {
		return productDao.getProducts(categoryId,start);
	}

	@Override
	public int getTotalCount(int categoryId) {
		return productDao.getTotalCount(categoryId);
	}

	@Override
	public List<Product> getProducts(int displayId) {
		return productDao.getProducts(displayId);
	}

	@Override
	public int getAverageScore(int displayId) {
		return productDao.getAverageScore(displayId);
	}

}
