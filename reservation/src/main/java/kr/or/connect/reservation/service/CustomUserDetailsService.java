package kr.or.connect.reservation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.service.security.CustomUserDetails;
import kr.or.connect.reservation.service.security.UserDbService;
import kr.or.connect.reservation.service.security.UserEntity;
import kr.or.connect.reservation.service.security.UserRoleEntity;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserDbService userDbService;

	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {

		UserEntity userEntity = userDbService.getUser(userEmail);
		System.out.println("userEntity : "+userEntity);
		if(userEntity == null) {
			throw new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다.");
		}
		
		CustomUserDetails customUserDetails = new CustomUserDetails();
		customUserDetails.setUsername(userEntity.getId());
		customUserDetails.setPassword(userEntity.getPassword());
		
		List<UserRoleEntity> userRoles = userDbService.getUserRoles(userEmail);
		List<GrantedAuthority> authorities = new ArrayList<>();
		System.out.println(userRoles);
		if(userRoles != null) {
			for(UserRoleEntity userRole : userRoles) {
				authorities.add(new SimpleGrantedAuthority(userRole.getRoleName()));
			}
		}
		
		customUserDetails.setAuthorities(authorities);
		customUserDetails.setEnabled(true);
		customUserDetails.setAccountNonExpired(true);
		customUserDetails.setAccountNonLocked(true);
		customUserDetails.setCredentialsNonExpired(true);
		
		return customUserDetails;
	}
}
