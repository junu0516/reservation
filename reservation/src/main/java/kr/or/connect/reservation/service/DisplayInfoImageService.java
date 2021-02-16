package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.DisplayInfoImage;

public interface DisplayInfoImageService {

	List<DisplayInfoImage> getImages(int displayId);

}
