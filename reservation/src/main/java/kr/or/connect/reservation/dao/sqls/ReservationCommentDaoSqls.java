package kr.or.connect.reservation.dao.sqls;

public class ReservationCommentDaoSqls {
	
	public static String SELECT_COUNT = "select "
									+ "count(*) as totalCount "
									+ "from reservation_user_comment "
									+ "where product_id = :productId;";
	
	public static String SELECT_COUNT_ALL = "select "
									+ "count(*) as totalCount "
									+ "from reservation_user_comment";
	
	public static String SELECT_COMMENTS = "select "
									+ "reservation_user_comment.id as id, "
									+ "reservation_user_comment.product_id as productId, "
									+ "reservation_info_id as reservationInfoId, "
									+ "score, "
									+ "user.email as reservationEmail, "
									+ "comment, "
									+ "reservation_user_comment.create_date as createDate, "
									+ "reservation_user_comment.modify_date as modifyDate "
									+ "from reservation_user_comment "
									+ "join reservation_info on reservation_info.id = reservation_user_comment.reservation_info_id "
									+ "join user on user.id = reservation_user_comment.user_id "
									+ "where reservation_user_comment.product_id = :productId "
									+ "order by id desc "
									+ "limit :start,5"; 
	
	public static String SELECT_COMMENTS_ALL = "select "
			+ "reservation_user_comment.id as id, "
			+ "reservation_user_comment.product_id as productId, "
			+ "reservation_info_id as reservationInfoId, "
			+ "score, "
			+ "user.email as reservationEmail, "
			+ "comment, "
			+ "reservation_user_comment.create_date as createDate, "
			+ "reservation_user_comment.modify_date as modifyDate "
			+ "from reservation_user_comment "
			+ "join reservation_info on reservation_info.id = reservation_user_comment.reservation_info_id "
			+ "join user on user.id = reservation_user_comment.user_id "
			+ "order by id desc "
			+ "limit :start,5"; 
}
