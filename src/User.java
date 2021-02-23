import java.util.ArrayList;
import java.util.List;

public class User extends JoinMenberShip{
    private String name;
    private String phoneNumber;
    private String userName;
    private String userPhoneNumber;
    private List<Custom> userCustom = new ArrayList<Custom>();
	public String getName() {
		return name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}
	public List<Custom> getUserCustom() {
		return userCustom;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}
    
    
    

}
