
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserInfo extends JoinMenberShip implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 982901824462847230L;
	private String id;
	private String password;
	private String name;
	private String phoneNumber;
	private List<Custom> userCustom = new ArrayList<Custom>();

	public UserInfo() {}
	
	public UserInfo(String id, String password, String name, String phoneNumber) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	
	public List<Custom> getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(List<Custom> userCustom) {
		this.userCustom = userCustom;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", password=" + password + ", name=" + name + ", phoneNumber=" + phoneNumber
				+ ", userCustom=" + userCustom + "]";
	}
	
	
	
}
