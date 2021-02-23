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
    	//주문하기
    	//사용자의 userCustom 채우기.
    	
    	//시트선택
    	System.out.println("시트를 선택해주세요");
    	int i = 0;
    	for(Sheet sheet : CakeCustomProduct.getSheetList()) {
    		System.out.println((++i)+". 시트 맛: "+sheet.name+", 시트 가격: "+sheet.price);
    	}
    	String userSheet = scanner.nextLine();
    	
    	//시트 객체값 넣어주기
    	for(Sheet sheet : CakeCustomProduct.getSheetList()) {
    		if(sheet.name.equals(userSheet)) {
    			Sheet realUserSheet = sheet;
    			break;
    		}
    	}
    	
    	//생크림 선택
    	System.out.println("생크림을 선택해주세요");
    	i = 0;
    	for(FreshCream freshCream : CakeCustomProduct.getFreshCreamList()) {
    		System.out.println((++i)+". 생크림 맛:"+freshCream.name+", 생크림 가격: "+freshCream.price);
    	}
    	String userFreshCream = scanner.nextLine();
    	
    	//생크림 객체값 넣어주기
    	for(FreshCream freshCream : CakeCustomProduct.getFreshCreamList()) {
    		if(freshCream.name.equals(userFreshCream)) {
    			FreshCream realUserFreshCream = freshCream;
    			break;
    		}
    	}
    	
    	//토핑 선택
    	System.out.println("토핑을 선택해주세요");
    	i=0;
    	for(Topping topping : CakeCustomProduct.getToppingList()) {
    		System.out.println((++i)+". 토핑 종류: "+topping.name+" , 토핑 가격: "+topping.price);
    	}
    	String userTopping = scanner.nextLine();
    	
    	for(Topping topping : CakeCustomProduct.getToppingList()) {
    		if(topping.name.equals(userTopping)) {
    			Topping realTopping = topping;
    			break;
    		}
    	}
    	
    	System.out.println("초는 몇개드릴까요? 생일자의 나이를 입력해주세요");
    	int userCandle = scanner.nextInt();
    	
    	System.out.println("폭죽은 몇개드릴까요?");
    	int userFireCracker = scanner.nextInt();
    
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일");
    	
    }
    @Override
    public void reservationSerch() {
    	//예약정보 출력하기
    	System.out.println(nowUser.getUserName()+"고객님의 예약정보입니다.");
        for(Custom userCustom : nowUser.getUserCustom()) {
        	System.out.println(userCustom);
        }
    }
    
    @Override
    public void reservationChange() {
        
    }
    @Override
    public void reservationDelete() {
    	//예약정보 지우기
    	System.out.println("고객님의 예약정보를 지우겠습니다..");
    	for(Custom userCustom : nowUser.getUserCustom()) {
    		System.out.println(userCustom);
    		System.out.println("해당 예약정보를 지우겠습니까? 1. yes 2. no");
    		int userChoice = scanner.nextInt();
    		if(userChoice==1) {
    			balance -= userCustom.getPriceSum();
    			nowUser.getUserCustom().remove(userChoice);
    	    	System.out.println("지우기완료");

    		} else {
    			return;
    		}
    	}
    	//예약정보 데이터저장
    	//orderUser에서도 삭제하기
    	for(User user : orderUser) {
    		if(user==nowUser) {
    			orderUser.remove(user);
    		}
    	}
    	
    }
    @Override
    public void pickUp() {
    	//픽업하기
    	for(Custom userCustom : nowUser.getUserCustom()) {
    		System.out.println(userCustom);
    		System.out.println("해당 케이크를 픽업하시겠습니까? 1. yes 2. no");
    		int userChoice = scanner.nextInt();
    		if(userChoice == 1) {
    			userCustom.setReservationStatus(true);
    			System.out.println("픽업완료되었습니다.");
    		} else {
    			System.out.println("픽업취소되었습니다.");
    			return;
    		}
    	}
    }
    

}
