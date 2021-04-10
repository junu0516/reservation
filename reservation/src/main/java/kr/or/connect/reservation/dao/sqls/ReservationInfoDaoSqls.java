package kr.or.connect.reservation.dao.sqls;

public class ReservationInfoDaoSqls {
	
	public static String SELECT_RESERVATION_INFO = "select * from reservation_info "
											+ "where id = :id";
	
	public static String SELECT_RESERVATION_INFO_PRICE = "select * from reservation_info_price "
														+ "where id = :id";
}
