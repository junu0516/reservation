package kr.or.connect.reservation.dto;

public class UserRole {
	
	private int id;
	private String userId;
	private String roleName;
	
	public UserRole() {
		
	}

	public UserRole(int id, String userId, String roleName) {
		super();
		this.id = id;
		this.userId = userId;
		this.roleName = roleName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "UserRole [id=" + id + ", userId=" + userId + ", roleName=" + roleName + "]";
	}
	
}
