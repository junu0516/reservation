package kr.or.connect.reservation.dto;

public class User {
	
	private String userId;
	private String userName;
	private String password;
	private String userEmail;
	private String userPhone;
	private String createDate;
	private String modifyDate;
	
	public User() {
		
	}

	public User(String userId, String userName, String password, String userEmail, String userPhone, String createDate,
			String modifyDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", userEmail="
				+ userEmail + ", userPhone=" + userPhone + ", createDate=" + createDate + ", modifyDate=" + modifyDate
				+ "]";
	}
	
}
