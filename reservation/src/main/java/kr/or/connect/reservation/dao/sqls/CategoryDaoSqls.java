package kr.or.connect.reservation.dao.sqls;

public class CategoryDaoSqls {
	public static final String SELECT_ALL = "select "
											+ "category.id, category.name, "
											+ "count(*) as count "
											+ "from category "
											+ "join product on category.id = product.category_id "
											+ "join display_info on product.id = display_info.product_id  "
											+ "group by category.id";
}
