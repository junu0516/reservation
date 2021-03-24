package kr.or.connect.reservation.dao.sqls;

public class UserDaoSqls {
	
	public static String SELECT_USER = "select * from user "
									 + "where email = :userEmail";
}
