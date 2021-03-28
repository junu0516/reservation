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
	
	UserDao userDao;
	UserRoleDao userRoleDao;
	
	public UserServiceImpl(UserDao userDao, UserRoleDao userRoleDao) {
		
		this.userDao = userDao;
		this.userRoleDao = userRoleDao;
	}
	
	@Override
	@Transactional
	public UserEntity getUser(String userEmail) {
		System.out.println("userServiceImpl 진입");
		User user = userDao.getUser(userEmail);
		System.out.println("user 생성");
		System.out.println("user : "+user);
		return new UserEntity(user.getUserEmail(),user.getPassword());
	}

	@Override
	@Transactional
	public List<UserRoleEntity> getUserRoles(String userId) {
		List<UserRole> userRoles = userRoleDao.getUserRoles(userId);
		List<UserRoleEntity> userRoleEntities = new ArrayList<>();
		
		for(UserRole userRole : userRoles) {
			userRoleEntities.add(new UserRoleEntity(userId, userRole.getRoleName()));
		}
		
		return userRoleEntities;
	}

}
