import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CakeCustomShop implements StoreOrderSystem{
    private UserInfo nowUser = new UserInfo();
    private List<UserInfo> orderUser = new ArrayList<UserInfo>();
    private long balance;
    private int forcount;
    private Scanner scanner = new Scanner(System.in);
    
    
    /**
     * @author 안승주
     */
    @Override
    public void order() {
        Sheet choiceSheet = null;
        FreshCream choicefreshcream = null;
        Topping choiceTopping = null;
        int choiceCandleNum = 0;
        int priceSum = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yy년 MM월 dd일 HH:mm:ss");
        Date date = new Date("yy년 MM월 dd일 HH:mm:ss");
        
        System.out.println("시트를 골라주세요");
        for(Sheet sheet : CakeCustomProduct.getSheetList()) {
                System.out.println("["+ (++forcount) +"]번 시트 이름: " +sheet.name +
                                   " 가격: " + sheet.price +" 원");
        }
        scanner.nextLine();
        String userChoicestr = scanner.nextLine();
        for(Sheet sheet : CakeCustomProduct.getSheetList()) {
            if(userChoicestr.equals(sheet.name)) {
                choiceSheet = sheet;
                break;
            }
        }
        forcount = 0;
        System.out.println("생크림를 골라주세요");
        for(FreshCream freshcream : CakeCustomProduct.getFreshCreamList()) {
                System.out.println("["+ ++forcount +"]번 시트 이름: " +freshcream.name +
                                   " 가격: " + freshcream.price +" 원");
        }
        userChoicestr = scanner.nextLine();
        for(FreshCream freshcream : CakeCustomProduct.getFreshCreamList()) {
            if(userChoicestr.equals(freshcream.name)) {
                choicefreshcream = freshcream;
                break;
            }
        }
        forcount = 0;
        System.out.println("토핑을 골라주세요");
        for(Topping freshcream : CakeCustomProduct.getToppingList()) {
                System.out.println("["+ ++forcount +"]번 시트 이름: " +freshcream.name +
                                   " 가격: " + freshcream.price +" 원");
        }
        userChoicestr = scanner.nextLine();
        for(Topping topping : CakeCustomProduct.getToppingList()) {
            if(userChoicestr.equals(topping.name)) {
                choiceTopping = topping;
                break;
            }
        }
        System.out.println("초의 갯수를 정해주세요");
        int userChoiceint = scanner.nextInt();
        choiceCandleNum = userChoiceint;
        
        priceSum = choicefreshcream.price + choiceSheet.price + choiceTopping.price;
        
        
        
    }
    @Override
    public void reservationSerch() {
        //예약정보 출력하기
        System.out.println(nowUser.getName()+"고객님의 예약정보입니다.");
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
        for(UserInfo user : orderUser) {
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
