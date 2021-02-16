package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.ProductImage;

public interface ProductImageService {

	List<ProductImage> getImages(int displayId);

}
