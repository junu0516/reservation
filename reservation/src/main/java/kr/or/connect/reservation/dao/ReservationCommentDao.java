package kr.or.connect.reservation.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.ReservationComment;

import static kr.or.connect.reservation.dao.sqls.ReservationCommentDaoSqls.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ReservationCommentDao {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ReservationComment> rowMapper = BeanPropertyRowMapper.newInstance(ReservationComment.class);
	
	public ReservationCommentDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public int getTotalCount(int productId) {
		
		if(productId==0) {
			return jdbc.queryForObject(SELECT_COUNT_ALL, Collections.emptyMap(), Integer.class);
		}else {
			Map<String,?> paramForProductId = Collections.singletonMap("productId", productId);
			return jdbc.queryForObject(SELECT_COUNT, paramForProductId, Integer.class);
		}
		
	}

	public List<ReservationComment> getReservationComments(int productId, int start) {
		
		if(productId==0) {
			Map<String,?> paramForStart = Collections.singletonMap("start", start);
			return jdbc.query(SELECT_COMMENTS_ALL,paramForStart,rowMapper);
		}else {
			Map<String,Integer> params = new HashMap<>();
			params.put("productId", productId);
			params.put("start", start);
			return jdbc.query(SELECT_COMMENTS,params,rowMapper);
		}		
	}

}
