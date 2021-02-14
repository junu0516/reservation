package kr.or.connect.reservation.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Category;
import static kr.or.connect.reservation.dao.sqls.CategoryDaoSqls.*;

import java.util.Collections;
import java.util.List;

@Repository
public class CategoryDao {
	
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Category> rowMapper = BeanPropertyRowMapper.newInstance(Category.class);
	  
	public CategoryDao(DataSource dataSource) {
		
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
								.withTableName("category")
								.usingGeneratedKeyColumns("id");
	}
	
	public List<Category> getCategories(){
		
		return jdbc.query(SELECT_ALL, Collections.emptyMap(),rowMapper);
	}
	
}
