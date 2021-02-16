package kr.or.connect.reservation.dao.sqls;

public class ProductPriceDaoSqls {
	
	public static String SELECT_PRICE = "select "
								+ "product_price.id as id, "
								+ "product.id as productId, "
								+ "product_price.price_type_name as priceTypeName, "
								+ "price, "
								+ "discount_rate as discountRate, "
								+ "product_price.create_date as createDate, "
								+ "product_price.modify_date as modifyDate "
								+ "from product_price "
								+ "join product on product.id = product_price.product_id "
								+ "join display_info on display_info.product_id = product.id "
								+ "where display_info.id = :displayId"; 
}
