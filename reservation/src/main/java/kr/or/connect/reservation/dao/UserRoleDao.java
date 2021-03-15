package kr.or.connect.reservation.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.UserRole;
import static kr.or.connect.reservation.dao.sqls.UserRoleDaoSqls.*;

@Repository
public class UserRoleDao {
	
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<UserRole> rowMapper = BeanPropertyRowMapper.newInstance(UserRole.class);
	
	public UserRoleDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<UserRole> getUserRoles(String userId){
		Map<String,Object> param = new HashMap<>();
		param.put("userId", userId);
		
		return jdbc.query(SELECT_ALL_BY_ID,param,rowMapper);
	}
}
