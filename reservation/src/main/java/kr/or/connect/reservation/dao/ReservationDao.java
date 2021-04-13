package kr.or.connect.reservation.dao;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Price;
import kr.or.connect.reservation.dto.PriceInsertion;
import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.dto.ReservationInsertion;

import static kr.or.connect.reservation.dao.sqls.ReservationInfoDaoSqls.*;

@Repository
public class ReservationDao {
	
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert priceInsertAction;
	private SimpleJdbcInsert reservationInsertAction;
	private RowMapper<Price> rowMapperForPriceInfo = BeanPropertyRowMapper.newInstance(Price.class);
	private RowMapper<ReservationInfo> rowMapperForReservationInfo = BeanPropertyRowMapper.newInstance(ReservationInfo.class);
	
	public ReservationDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.priceInsertAction = new SimpleJdbcInsert(dataSource)
								.withTableName("reservation_info_price")
								.usingGeneratedKeyColumns("id");
		this.reservationInsertAction = new SimpleJdbcInsert(dataSource)
								.withTableName("reservation_info")
								.usingGeneratedKeyColumns("id");
	}

	public int insertReservationInfo(ReservationInsertion reservationInsertion) {
		
		Map<String,Object> params = new HashMap<>();
		params.put("product_id", String.valueOf(reservationInsertion.getProductId()));
		params.put("display_info_id", String.valueOf(reservationInsertion.getDisplayInfoId()));
		params.put("user_id", String.valueOf(reservationInsertion.getUserId()));
		params.put("cancel_flag", 0);
		params.put("reservation_date", reservationInsertion.getReservationYearMonthDay());
		params.put("create_date", Timestamp.valueOf(LocalDateTime.now()));
		params.put("modify_date", Timestamp.valueOf(LocalDateTime.now()));
		
		return reservationInsertAction.executeAndReturnKey(params).intValue();
	}
	public int insertPriceInfo(PriceInsertion priceInsertion, int reservationInfoId) {
		
		Map<String,Object> params = new HashMap<>();
		params.put("reservation_info_id", reservationInfoId);
		params.put("product_price_id", priceInsertion.getProductPriceId());
		params.put("count", priceInsertion.getCount());
		
		return priceInsertAction.executeAndReturnKey(params).intValue();
	}
	
	public Price selectPriceInfo(int priceInfoId) {
		
		Map<String,Integer> param = new HashMap<>();
		param.put("id", priceInfoId);
		
		return jdbc.queryForObject(SELECT_RESERVATION_INFO_PRICE,param,rowMapperForPriceInfo);
	}

	public ReservationInfo selectReservationInfo(int reservationInfoId) {
		
		Map<String,Integer> param = new HashMap<>();
		param.put("id", reservationInfoId);
		
		return jdbc.queryForObject(SELECT_RESERVATION_INFO, param, rowMapperForReservationInfo);
	}

	
}
