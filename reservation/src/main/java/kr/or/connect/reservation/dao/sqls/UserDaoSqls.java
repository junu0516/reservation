package kr.or.connect.reservation.dao.sqls;

public class UserDaoSqls {
	
	public static String SELECT_USER = "select "
									+"id as userId, "
									+"name as userName, "
									+"password as password, "
									+"email as userEmail, "
									+"phone as userPhone, "
									+"create_date as createDate, "
									+"modify_date as modifyDate "
									+"from user "
									+"where email = :userEmail";
}
