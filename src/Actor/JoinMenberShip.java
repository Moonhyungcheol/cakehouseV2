package Actor;

import java.util.regex.Pattern;

public class JoinMenberShip {
    
    private String ID;
    private String password;
    
    public static final Pattern REG_EXP_ID = Pattern.compile("^[a-zA-Z]{1}[a-zA-Z0-9]{5,19}$");
    public static final Pattern REG_EXP_PASSWORD = Pattern.compile("^[\\S]{8,}$");
    
    
    public static boolean isValidId(String ID) {
        return REG_EXP_ID.matcher(ID).matches();
    }
    public static boolean isValidPwd(String password) {
        return REG_EXP_PASSWORD.matcher(password).matches();
    }
    
    

}
