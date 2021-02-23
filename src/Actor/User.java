package Actor;

import java.util.regex.Pattern;

public class User extends JoinMenberShip{
    private String name;
    private String phoneNumber;
    
    private static final Pattern REG_EXP_NAME = Pattern.compile("[가-힣]{1,}");
    private static final Pattern REG_EXP_PHONENUMBER = Pattern.compile("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$");
    
    public static boolean isValidName(String name) {
        return REG_EXP_NAME.matcher(name).matches();
    }
    
    public static boolean isValidPhoneNumber(String phoneNumber) {
        return REG_EXP_PHONENUMBER.matcher(phoneNumber).matches();
    }
    
    
    
    

}
