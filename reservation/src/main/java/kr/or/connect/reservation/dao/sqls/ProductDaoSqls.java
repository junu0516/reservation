package kr.or.connect.reservation.dao.sqls;

public class ProductDaoSqls {
	
	public static final String SELECT_COUNT = "select count(*) as totalCount "
												+ "from display_info "
												+ "join product on display_info.product_id = product.id "
												+ "where product.category_id = :categoryId";
	
	public static final String SELECT_COUNT_ALL = "select count(*) as totalCount "
												   + "from display_info "
												   + "join product on display_info.product_id = product.id";

	public static final String SELECT_PRODUCTS = "select "
											+ "product.id as id, "
											+ "category_id as categoryId,"
											+ "display_info.id as displayInfoId,"
											+ "category.name as name,"
											+ "product.description,"
											+ "product.content,"
											+ "product.event, "
											+ "display_info.opening_hours as openingHours,"
											+ "display_info.place_name as placeName, "
											+ "display_info.place_lot as placeLot, "
											+ "display_info.place_street as placeStreet, "
											+ "display_info.tel,"
											+ "display_info.homepage,"
											+ "display_info.email, "
											+ "display_info.create_date as createDate, "
											+ "display_info.modify_date as modifyDate, "
											+ "product_image.file_id as fileId "
											+ "from product  "
											+ "join display_info on display_info.product_id = product.id "
											+ "join category on category.id = product.category_id "
											+ "join product_image on product_image.product_id = product.id "
											+ "where category_id = :categoryId and type='ma' "
											+ "limit :start,4";
	
	
	public static final String SELECT_PRODUCTS_ALL = "select "
													+ "product.id as id, "
													+ "category_id as categoryId,"
													+ "display_info.id as displayInfoId,"
													+ "category.name as name,"
													+ "product.description,"
													+ "product.content,"
													+ "product.event, "
													+ "display_info.opening_hours as openingHours,"
													+ "display_info.place_name as placeName, "
													+ "display_info.place_lot as placeLot, "
													+ "display_info.place_street as placeStreet, "
													+ "display_info.tel,"
													+ "display_info.homepage,"
													+ "display_info.email, "
													+ "display_info.create_date as createDate, "
													+ "display_info.modify_date as modifyDate, "
													+ "product_image.file_id as fileId "
													+ "from product  "
													+ "join display_info on display_info.product_id = product.id "
													+ "join category on category.id = product.category_id "
													+ "join product_image on product_image.product_id = product.id "
													+ "where type='ma' "
													+ "limit :start,4";
}
