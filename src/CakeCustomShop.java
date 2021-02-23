import java.text.SimpleDateFormat;
import java.util.*;

public class CakeCustomShop implements StoreOrderSystem{
    private User nowUser = new User();
    private List<User> orderUser = new ArrayList<User>();
    private long balance;
    private Scanner scanner = new Scanner(System.in);
    private Date date = new Date();
    
    @Override
    public void order() {
    	//�ֹ��ϱ�
    	//������� userCustom ä���.
    	
    	//��Ʈ����
    	System.out.println("��Ʈ�� �������ּ���");
    	int i = 0;
    	for(Sheet sheet : CakeCustomProduct.getSheetList()) {
    		System.out.println((++i)+". ��Ʈ ��: "+sheet.name+", ��Ʈ ����: "+sheet.price);
    	}
    	String userSheet = scanner.nextLine();
    	
    	//��Ʈ ��ü�� �־��ֱ�
    	for(Sheet sheet : CakeCustomProduct.getSheetList()) {
    		if(sheet.name.equals(userSheet)) {
    			Sheet realUserSheet = sheet;
    			break;
    		}
    	}
    	
    	//��ũ�� ����
    	System.out.println("��ũ���� �������ּ���");
    	i = 0;
    	for(FreshCream freshCream : CakeCustomProduct.getFreshCreamList()) {
    		System.out.println((++i)+". ��ũ�� ��:"+freshCream.name+", ��ũ�� ����: "+freshCream.price);
    	}
    	String userFreshCream = scanner.nextLine();
    	
    	//��ũ�� ��ü�� �־��ֱ�
    	for(FreshCream freshCream : CakeCustomProduct.getFreshCreamList()) {
    		if(freshCream.name.equals(userFreshCream)) {
    			FreshCream realUserFreshCream = freshCream;
    			break;
    		}
    	}
    	
    	//���� ����
    	System.out.println("������ �������ּ���");
    	i=0;
    	for(Topping topping : CakeCustomProduct.getToppingList()) {
    		System.out.println((++i)+". ���� ����: "+topping.name+" , ���� ����: "+topping.price);
    	}
    	String userTopping = scanner.nextLine();
    	
    	for(Topping topping : CakeCustomProduct.getToppingList()) {
    		if(topping.name.equals(userTopping)) {
    			Topping realTopping = topping;
    			break;
    		}
    	}
    	
    	System.out.println("�ʴ� ��帱���? �������� ���̸� �Է����ּ���");
    	int userCandle = scanner.nextInt();
    	
    	System.out.println("������ ��帱���?");
    	int userFireCracker = scanner.nextInt();
    
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��");
    	
    }
    @Override
    public void reservationSerch() {
    	//�������� ����ϱ�
    	System.out.println(nowUser.getUserName()+"������ ���������Դϴ�.");
        for(Custom userCustom : nowUser.getUserCustom()) {
        	System.out.println(userCustom);
        }
    }
    
    @Override
    public void reservationChange() {
        
    }
    @Override
    public void reservationDelete() {
    	//�������� �����
    	System.out.println("������ ���������� ����ڽ��ϴ�..");
    	for(Custom userCustom : nowUser.getUserCustom()) {
    		System.out.println(userCustom);
    		System.out.println("�ش� ���������� ����ڽ��ϱ�? 1. yes 2. no");
    		int userChoice = scanner.nextInt();
    		if(userChoice==1) {
    			balance -= userCustom.getPriceSum();
    			nowUser.getUserCustom().remove(userChoice);
    	    	System.out.println("�����Ϸ�");

    		} else {
    			return;
    		}
    	}
    	//�������� ����������
    	//orderUser������ �����ϱ�
    	for(User user : orderUser) {
    		if(user==nowUser) {
    			orderUser.remove(user);
    		}
    	}
    	
    }
    @Override
    public void pickUp() {
    	//�Ⱦ��ϱ�
    	for(Custom userCustom : nowUser.getUserCustom()) {
    		System.out.println(userCustom);
    		System.out.println("�ش� ����ũ�� �Ⱦ��Ͻðڽ��ϱ�? 1. yes 2. no");
    		int userChoice = scanner.nextInt();
    		if(userChoice == 1) {
    			userCustom.setReservationStatus(true);
    			System.out.println("�Ⱦ��Ϸ�Ǿ����ϴ�.");
    		} else {
    			System.out.println("�Ⱦ���ҵǾ����ϴ�.");
    			return;
    		}
    	}
    }
    

}
