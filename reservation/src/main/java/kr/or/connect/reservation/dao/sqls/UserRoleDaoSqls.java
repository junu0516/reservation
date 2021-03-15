package kr.or.connect.reservation.dao.sqls;

public class UserRoleDaoSqls {
	
	public static final String SELECT_ALL_BY_ID = "select * from user_role "
												 + "where user_id = :userId";
}
