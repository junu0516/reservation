package kr.or.connect.reservation.dao.sqls;

public class ProductImageDaoSqls {
	
	public static String SELECT_PRODUCT_IMAGE = "select "
											+ "product.id as productId, "
											+ "product_image.id as productImageId,type, "
											+ "file_info.id as fileInfoId, "
											+ "file_name as fileName, "
											+ "save_file_name as saveFileName, "
											+ "content_type as contentType, "
											+ "delete_flag as deleteFlag, "
											+ "file_info.create_date as createDate, "
											+ "file_info.modify_date as modifyDate "
											+ "from product "
											+ "join product_image on product.id = product_image.product_id "
											+ "join file_info on file_info.id = product_image.file_id "
											+ "join display_info on display_info.product_id = product.id "
											+ "where type='ma' and display_info.id = :displayId";
}
