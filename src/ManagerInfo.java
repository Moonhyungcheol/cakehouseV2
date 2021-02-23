
public class ManagerInfo {
	private String managerId;
	private String managerPwd;
	private String managerName;
	private String managerPhoneNumber;

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getManagerPwd() {
		return managerPwd;
	}

	public void setManagerPwd(String managerPwd) {
		this.managerPwd = managerPwd;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerPhoneNumber() {
		return managerPhoneNumber;
	}

	public void setManagerPhoneNumber(String managerPhoneNumber) {
		this.managerPhoneNumber = managerPhoneNumber;
	}

	@Override
	public String toString() {
		return "ManagerInfo [managerId=" + managerId + ", managerPwd=" + managerPwd + ", managerName=" + managerName
				+ ", managerPhoneNumber=" + managerPhoneNumber + "]";
	}

}
