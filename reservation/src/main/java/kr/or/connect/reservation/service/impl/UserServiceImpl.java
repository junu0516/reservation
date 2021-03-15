package kr.or.connect.reservation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.UserDao;
import kr.or.connect.reservation.dao.UserRoleDao;
import kr.or.connect.reservation.dto.User;
import kr.or.connect.reservation.dto.UserRole;
import kr.or.connect.reservation.service.UserService;
import kr.or.connect.reservation.service.security.UserEntity;
import kr.or.connect.reservation.service.security.UserRoleEntity;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	UserRoleDao userRoleDao;
	
	@Override
	@Transactional
	public UserEntity getUser(String userId) {
		
		User user = userDao.getUser(userId);
		
		return new UserEntity(user.getUserId(),user.getPassword());
	}

	@Override
	public List<UserRoleEntity> getUserRoles(String userId) {
		List<UserRole> userRoles = userRoleDao.getUserRoles(userId);
		List<UserRoleEntity> userRoleEntities = new ArrayList<>();
		
		for(UserRole userRole : userRoles) {
			userRoleEntities.add(new UserRoleEntity(userId, userRole.getRoleName()));
		}
		
		return userRoleEntities;
	}

}
