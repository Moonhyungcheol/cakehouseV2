

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class JoinMenberShip {
	
	private List<UserInfo> joinUser = new ArrayList<UserInfo>();
    private Scanner	scanner = new Scanner(System.in); 
	
	
	public static final Pattern REG_EXP_NAME = Pattern.compile("[°¡-ÆR]{1,}");
	public static final Pattern REG_EXP_PHONENUMBER = Pattern.compile("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$");
	public static final Pattern REG_EXP_ID = Pattern.compile("^[a-zA-Z]{1}[a-zA-Z0-9]{5,19}$");
	public static final Pattern REG_EXP_PASSWORD = Pattern.compile("^[\\S]{8,}$");

	public static boolean isValidName(String name) {
		return REG_EXP_NAME.matcher(name).matches();
	}

	public static boolean isValidPhoneNumber(String phoneNumber) {
		return REG_EXP_PHONENUMBER.matcher(phoneNumber).matches();
	}

	public static boolean isValidId(String id) {
		return REG_EXP_ID.matcher(id).matches();
	}

	public static boolean isValidPwd(String password) {
		return REG_EXP_PASSWORD.matcher(password).matches();
	}
    
	/**
	 * 
	 * @param id
	 * @param password
	 * @return 
	 * @author ¹®ÇüÃ¶
	 */
    public UserInfo userJoin(String id, String password) {
    	
    	UserInfo userinfo = new UserInfo();
    	
    	String name = "";
    	String phoneNumber = "";
    	
    	while(!isValidId(id)) {
    		System.out.println("¾ÆÀÌµð Çü½ÄÀÌ Àß ¸ø µÇ¾ú½À´Ï´Ù.");
    		System.out.println("ex) abcd1234");
    		id = scanner.nextLine();
    	}
    	
    	for(int i = 0; i < joinUser.size(); i++) {
    		if(joinUser.get(i).getId().equals(id)) {
    			System.out.println("Áßº¹µÈ ¾ÆÀÌµðÀÔ´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
    			id = scanner.nextLine();
    			i = 0;
    		}
    	}
    	
    	while(!isValidPwd(password)) {
    		System.out.println("ºñ¹Ð¹øÈ£¿¡ °ø¹éÀ» ³ÖÀ¸½Ç ¼ö ¾ø½À´Ï´Ù");
    		password = scanner.nextLine();
    	}
    	
    	System.out.println("ÀÌ¸§À» ÀÔ·ÂÇÏ¼¼¿ä");
    	name = scanner.nextLine();
    	
    	while(!isValidName(name)) {
    		System.out.println("ÀÌ¸§ÀÇ Çü½ÄÀÌ Àß¸ø µÇ¾ú½À´Ï´Ù.");
    		name = scanner.nextLine();
    	}
    	
    	System.out.println("ÇÚµåÆù¹øÈ£¸¦ ÀÔ·ÂÇÏ¼¼¿ä");
    	phoneNumber = scanner.nextLine();
    	while(isValidPhoneNumber(phoneNumber)) {
    		System.out.println("ÀüÈ­¹øÈ£ÀÇ Çü½ÄÀÌ Àß¸ø µÇ¾ú½À´Ï´Ù.");
    		phoneNumber = scanner.nextLine();
    	}
    	
    	
    	userinfo.setId(id);
    	userinfo.setPassword(password);
    	userinfo.setName(name);
    	userinfo.setPhoneNumber(phoneNumber);
    	
    	return userinfo;
    	
    }
    
    /**
     * 
     * @param id
     * @param password
     * @return
     * @author ¹®ÇüÃ¶
     */
    public UserInfo userLogin(String id, String password) {
    	
    	UserInfo userinfo = null;
    	for(UserInfo user : joinUser) {
    		if(user.getId().equals(id)) {
    			if(user.getPassword().equals(password)) {
    				return user;
    			}
    		}
    	}

    	System.out.println("¾ÆÀÌµð³ª ÆÐ½º¿öµå¸¦ Àß¸ø ÀÔ·ÂÇÏ¼Ì½À´Ï´Ù.");
    	
    	return null;
    }
    

}
