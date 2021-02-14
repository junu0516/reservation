package kr.or.connect.reservation.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Product;
import static kr.or.connect.reservation.dao.sqls.ProductDaoSqls.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

@Repository
public class ProductDao {
	
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class);
	
	public ProductDao(DataSource dataSource) {
		
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
								.withTableName("product")
								.usingGeneratedKeyColumns("id");
	}
	
	public List<Product> getProducts(int categoryId, int start){
	
		if(categoryId==0) {
			Map<String,?> paramForStart = Collections.singletonMap("start", start);
			return jdbc.query(SELECT_PRODUCTS_ALL,paramForStart,rowMapper);
		}else {
			Map<String,Integer> params = new HashMap<>();
			params.put("categoryId", categoryId);
			params.put("start", start);
			return jdbc.query(SELECT_PRODUCTS,params,rowMapper);			
		}
		
	}

	public int getTotalCount(int categoryId) {
		
		if(categoryId==0) {
			return jdbc.queryForObject(SELECT_COUNT_ALL,Collections.emptyMap(),Integer.class);
		}else {
			Map<String,?> paramForCategoryId = Collections.singletonMap("categoryId", categoryId);
			return jdbc.queryForObject(SELECT_COUNT,paramForCategoryId,Integer.class);
		}
	}
}
