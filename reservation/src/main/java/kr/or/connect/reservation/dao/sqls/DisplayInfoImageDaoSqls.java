package kr.or.connect.reservation.dao.sqls;

public class DisplayInfoImageDaoSqls {
	
	public static String SELECT_DISPLAY_INFO_IMAGE = "select "
												+ "display_info_image.id, "
												+ "display_info_image.display_info_id as displayInfoId, "
												+ "display_info_image.file_id as fileId, "
												+ "file_name as fileName, "
												+ "save_file_name as saveFileName, "
												+ "content_type as contentType, "
												+ "delete_flag as deleteFlag, "
												+ "create_date as createDate, "
												+ "modify_date as modifyDat "
												+ "from display_info_image "
												+ "join file_info on file_info.id = display_info_image.file_id "
												+ "where display_info_image.display_info_id = :displayId";
}
