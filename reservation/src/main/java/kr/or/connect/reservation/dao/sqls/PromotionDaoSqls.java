package kr.or.connect.reservation.dao.sqls;

public class PromotionDaoSqls {
	
	public static String SELECT_ALL = "select "
										+ "promotion.id, "
										+ "product.id as productId, "
										+ "category.id as categoryId, "
										+ "category.name as categoryName, "
										+ "product.description, "
										+ "product_image.file_id as fileId "
										+ "from promotion "
										+ "join product on promotion.product_id = product.id "
										+ "join category on product.category_id = category.id "
										+ "join product_image on product_image.product_id = product.id "
										+ "where type='ma'";
	
	public static String SELECT_COUNT = "select count(*) as size from promotion";
}
