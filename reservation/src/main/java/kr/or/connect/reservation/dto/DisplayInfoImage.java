package kr.or.connect.reservation.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DisplayInfoImage {
	private int id;
	private int displayInfoId;
	private int fileId;
	private String fileName;
	private String saveFileName;
	private String contentType;
	private int deleteFlag;
	private String createDate;
	private String modifyDate;
	
	public DisplayInfoImage() {
		
	}

	public DisplayInfoImage(int id, int displayInfoId, int fileId, String fileName, String saveFileName,
			String contentType, int deleteFlag, Timestamp createDate, Timestamp modifyDate) {
		super();
		this.id = id;
		this.displayInfoId = displayInfoId;
		this.fileId = fileId;
		this.fileName = fileName;
		this.saveFileName = saveFileName;
		this.contentType = contentType;
		this.deleteFlag = deleteFlag;
		this.createDate = createDate.toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		this.modifyDate = modifyDate.toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDisplayInfoId() {
		return displayInfoId;
	}

	public void setDisplayInfoId(int displayInfoId) {
		this.displayInfoId = displayInfoId;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getCreateDate() {
		
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate.toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate.toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}

	@Override
	public String toString() {
		return "DisplayInfoImage [id=" + id + ", displayInfoId=" + displayInfoId + ", fileId=" + fileId + ", fileName="
				+ fileName + ", saveFileName=" + saveFileName + ", contentType=" + contentType + ", deleteFlag="
				+ deleteFlag + ", createDate=" + createDate + ", modifyDate=" + modifyDate + "]";
	}
	
}
