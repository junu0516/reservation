package kr.or.connect.reservation.dao.sqls;

public class ReservationInfoDaoSqls {
	
	public static String SELECT_RESERVATION_INFO = "select * from reservation_info "
											+ "where id = :id";
	
	public static String SELECT_RESERVATION_INFO_PRICE = "select * from reservation_info_price "
														+ "where id = :id";
	
	public static String SELECT_ALL_RESERVATIONS = "select "
													+ "reservation_info.id as id, "
													+ "reservation_info.product_id as productId, "
													+ "reservation_info.display_info_id as displayInfoId, "
													+ "reservation_info.cancel_flag as cancelFlag, "
													+ "product.description as productDescription, "
													+ "product.content as productContent, "
													+ "reservation_info.user_id as userId, "
													+ "sum(distinct product_price.price * reservation_info_price.count) as sumPrice, "
													+ "reservation_info.reservation_date as reservationDate, "
													+ "reservation_info.create_date as createDate, "
													+ "reservation_info.modify_date as modifyDate "
													+ "from reservation_info "
													+ "join reservation_info_price on reservation_info_price.reservation_info_id = reservation_info.id "
													+ "join product on reservation_info.product_id = product.id "
													+ "join product_price on product_price.product_id = reservation_info.product_id "
													+ "where reservation_info.user_id = :userId "
													+ "group by reservation_info.id";
	
	public static String UPDATE_CANCELING_RESERVATION = "update reservation_info "
														+ "set cancel_flag=1 "
														+ "where id = :id";
}
