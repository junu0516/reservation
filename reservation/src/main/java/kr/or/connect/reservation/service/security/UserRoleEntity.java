package kr.or.connect.reservation.service.security;

public class UserRoleEntity {
	
	private String userId;
	private String roleName;
	
	public UserRoleEntity() {
		
	}

	public UserRoleEntity(String userId, String roleName) {
		super();
		this.userId = userId;
		this.roleName = roleName;
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
		return "UserRoleEntity [userId=" + userId + ", roleName=" + roleName + "]";
	}

}
