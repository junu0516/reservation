package kr.or.connect.reservation.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.DisplayInfoImage;

import static kr.or.connect.reservation.dao.sqls.DisplayInfoImageDaoSqls.*;

@Repository
public class DisplayInfoImageDao {

	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<DisplayInfoImage> rowMapper = BeanPropertyRowMapper.newInstance(DisplayInfoImage.class);

	public DisplayInfoImageDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
								.withTableName("display_info_image")
								.usingGeneratedKeyColumns("id");		
	}
	
	public List<DisplayInfoImage> getImage(int displayId) {
		
		Map<String,Integer> param = new HashMap<>();
		param.put("displayId", displayId);
		
		return jdbc.query(SELECT_DISPLAY_INFO_IMAGE,param,rowMapper);
	}

}
