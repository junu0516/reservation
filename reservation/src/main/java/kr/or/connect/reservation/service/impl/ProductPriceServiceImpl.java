package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ProductPriceDao;
import kr.or.connect.reservation.dto.ProductPrice;
import kr.or.connect.reservation.service.ProductPriceService;

@Service
public class ProductPriceServiceImpl implements ProductPriceService {
	
	@Autowired
	ProductPriceDao productPriceDao;
	
	@Override
	public List<ProductPrice> getPrices(int displayId) {
		
		return productPriceDao.getPrices(displayId);
	}
	
}
