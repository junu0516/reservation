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
	public UserEntity getUser(String userEmail) {
		
		User user = userDao.getUser(userEmail);
		System.out.println("user : "+user);
		
		return new UserEntity(user.getUserEmail(),user.getPassword());
	}

	@Override
	@Transactional
	public List<UserRoleEntity> getUserRoles(String userEmail) {
		
		User user = userDao.getUser(userEmail);
		String userId = user.getUserId();
		
		List<UserRole> userRoles = userRoleDao.getUserRoles(userId);
		List<UserRoleEntity> userRoleEntities = new ArrayList<>();
		
		for(UserRole userRole : userRoles) {
			userRoleEntities.add(new UserRoleEntity(userId, userRole.getRoleName()));
		}
		
		return userRoleEntities;
	}

	@Override
	public User getUserByEmail(String loginEmail) {
		
		User user = userDao.getUser(loginEmail);
		
		return user;
	}

}
