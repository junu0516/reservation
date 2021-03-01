package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.DisplayInfoImageDao;
import kr.or.connect.reservation.dto.DisplayInfoImage;
import kr.or.connect.reservation.service.DisplayInfoImageService;

@Service
public class DisplayInfoImageServiceImpl implements DisplayInfoImageService {
	
	@Autowired
	DisplayInfoImageDao displayInfoImageDao;
	
	@Override
	public List<DisplayInfoImage> getImages(int displayId) {
		return displayInfoImageDao.getImage(displayId);
	}

}
