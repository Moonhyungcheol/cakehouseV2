
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class JoinMenberShip {

    private List<UserInfo> joinUser = new ArrayList<UserInfo>();
    private Scanner scanner = new Scanner(System.in);

    public static final Pattern REG_EXP_NAME = Pattern.compile("[��-�R]{1,}");
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
     * @author ����ö
     */
    public UserInfo userJoin() {

        UserInfo userinfo = new UserInfo();

        System.out.print("id : ");
        String id = scanner.nextLine();

        while (!isValidId(id)) {
            System.out.println("���̵� ������ �� �� �Ǿ����ϴ�.");
            System.out.println("ex) abcd1234");
            id = scanner.nextLine();
        }

        for (int i = 0; i < joinUser.size(); i++) {
            if (joinUser.get(i).getId().equals(id)) {
                System.out.println("�ߺ��� ���̵��Դϴ�. �ٽ� �Է����ּ���.");
                id = scanner.nextLine();
                i = 0;
            }
        }

        System.out.print("password : ");
        String password = scanner.nextLine();

        while (!isValidPwd(password)) {
            System.out.println("��й�ȣ�� ������ ������ �� �����ϴ�");
            password = scanner.nextLine();
        }

        System.out.print("name : ");
        String name = scanner.nextLine();

        while (!isValidName(name)) {
            System.out.println("�̸��� ������ �߸� �Ǿ����ϴ�.");
            name = scanner.nextLine();
        }

        System.out.print("phone number : ");
        String phoneNumber = scanner.nextLine();

        while (isValidPhoneNumber(phoneNumber)) {
            System.out.println("��ȭ��ȣ�� ������ �߸� �Ǿ����ϴ�.");
            phoneNumber = scanner.nextLine();
        }

        userinfo.setId(id);
        userinfo.setPassword(password);
        userinfo.setName(name);
        userinfo.setPhoneNumber(phoneNumber);

        joinUser.add(userinfo);

        return userinfo;

    }

    /**
     * 
     * @param id
     * @param password
     * @return
     * @author ����ö
     */
    public UserInfo userLogin(String id, String password) {

        UserInfo userinfo = new UserInfo();
        for (UserInfo user : joinUser) {
            if (user.getId().equals(id)) {
                if (user.getPassword().equals(password)) {
                    return user;
                }
            }
        }

        System.out.println("���̵� �н����带 �߸� �Է��ϼ̽��ϴ�.");

        return null;
    }

}
