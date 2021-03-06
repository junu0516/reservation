package kr.or.connect.reservation.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.User;
import static kr.or.connect.reservation.dao.sqls.UserDaoSqls.*;

@Repository
public class UserDao {
	
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<User> rowMapper = BeanPropertyRowMapper.newInstance(User.class);
	
	public UserDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public User getUser(String userEmail) {
		
		System.out.println("DB에서 유저정보 접근 시도 / "+"userEmail : "+userEmail);
		Map<String,String> param = new HashMap<>();
		param.put("userEmail", userEmail);
		System.out.println("param 추가");
		
		return jdbc.queryForObject(SELECT_USER, param,rowMapper);
	}
}
