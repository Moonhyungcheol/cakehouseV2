import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CakeCustomShop implements StoreOrderSystem {
    private UserInfo nowUser = new UserInfo();
    private List<UserInfo> orderUser = new ArrayList<UserInfo>();
    private long balance;
    private int forcount;
    private Scanner scanner = new Scanner(System.in);
    private Pattern datePattern = Pattern.compile(" /^(21|22)\\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[0-1])$/;");
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private Date date = new Date();
    private String buyDate = sdf.format(date);
    /**
     * @author 안승주
     */
    @Override
    public void order() {
        Sheet choiceSheet = null;
        FreshCream choicefreshcream = null;
        Topping choiceTopping = null;
        int choiceCandleNum = 0;
        int fireCracker = 0;
        int priceSum = 0;

        // 시트 만들기
        System.out.println("시트를 골라주세요");
        for (Sheet sheet : CakeCustomProduct.getSheetList()) {
            System.out.println("[" + (++forcount) + "]번 시트 이름: " + sheet.name + " 가격: " + sheet.price + " 원");
        }
        scanner.nextLine();
        String userChoicestr = scanner.nextLine();
        for (Sheet sheet : CakeCustomProduct.getSheetList()) {
            if (userChoicestr.equals(sheet.name)) {
                choiceSheet = sheet;
                balance += sheet.price;
                break;
            }
        }

        // 생크림 만들기
        forcount = 0;
        System.out.println("생크림를 골라주세요");
        for (FreshCream freshcream : CakeCustomProduct.getFreshCreamList()) {
            System.out.println("[" + ++forcount + "]번 시트 이름: " + freshcream.name + " 가격: " + freshcream.price + " 원");
        }
        userChoicestr = scanner.nextLine();
        for (FreshCream freshcream : CakeCustomProduct.getFreshCreamList()) {
            if (userChoicestr.equals(freshcream.name)) {
                choicefreshcream = freshcream;
                balance += freshcream.price;
                break;
            }
        }

        // 토핑 만들기
        forcount = 0;
        System.out.println("토핑을 골라주세요");
        for (Topping freshcream : CakeCustomProduct.getToppingList()) {
            System.out.println("[" + ++forcount + "]번 시트 이름: " + freshcream.name + " 가격: " + freshcream.price + " 원");
        }
        userChoicestr = scanner.nextLine();
        for (Topping topping : CakeCustomProduct.getToppingList()) {
            if (userChoicestr.equals(topping.name)) {
                choiceTopping = topping;
                balance += topping.price;
                break;
            }
        }

        // 초 갯수 정하기
        System.out.println("초의 갯수를 정해주세요");
        int userChoiceint = scanner.nextInt();
        choiceCandleNum = userChoiceint;

        // 폭죽 갯수 정하기
        System.out.println("폭죽의 갯수를 정해주세요");
        userChoiceint = scanner.nextInt();
        fireCracker = userChoiceint;

        // 가격책청
        priceSum = choicefreshcream.price + choiceSheet.price + choiceTopping.price;


        // 픽업 날짜 정하고 유효성 검사 및 Date 타입 변환 작업
        System.out.println("픽업할 날짜와 시간을 입력해 주세요 예) 2021-02-14");
        
        Date dayBuy = null;
        Date dayPickUp = null;
        int compare = 0;
        
        //pickUpDate 형식 검사
        while(true) {
            scanner.nextLine();
            String pickUpDate = scanner.nextLine();
            if(!datePattern.matcher(pickUpDate).matches()) {
                System.out.println("형식이 올바르지 않습니다 예) 2021-02-14");
                continue;
            }
            try {
                dayBuy = sdf.parse(buyDate);
                dayPickUp = sdf.parse(pickUpDate);
            } catch (Exception e) {
                e.printStackTrace();
                scanner = new Scanner(System.in);
            }
            compare = dayBuy.compareTo(dayPickUp);
            if (compare > 0) {
                System.out.println("날짜가 올바르지 않습니다.");
                continue;
            }else {
                break;
            }
        }
        
        //픽업 default 값 false
        boolean ReservationStatus = false;
        
        nowUser.getUserCustom().add(new Custom(choiceSheet, choicefreshcream, choiceTopping, choiceCandleNum,
                fireCracker, priceSum, dayBuy, ReservationStatus, dayPickUp));
    }

    @Override
    public void reservationSerch() {
        // 예약정보 출력하기
        System.out.println(nowUser.getName() + "고객님의 예약정보입니다.");
        for (Custom userCustom : nowUser.getUserCustom()) {
            System.out.println(userCustom);
        }
    }

    @Override
    public void reservationChange() {

        System.out.println("예약 주문을 바꾸시겠습니까?");
        System.out.println("1: 예 2: 아니요");
        int userChoiceNum = scanner.nextInt();
        if (userChoiceNum == 1) {
            for (Custom userCustom : nowUser.getUserCustom()) {
                System.out.println(userCustom);
                System.out.println("해당 케이크주문을 변경하시겠습니까?1. 예 2. 아니요");
                int userChoice = scanner.nextInt();
                if (userChoice == 1) {
                    Custom changeCustom = userCustom;
                    // changeCustom.getSheet() =
                    System.out.println("[1]시트변경 [2]생크림변경 [3]토핑변경 [4]초 갯수 변경 [5]폭죽 갯수 변경 [6]픽업 날짜 변경 [7] 변경 취소");
                    switch (userChoiceNum) {

                    case 1:
                        
                        //시트 변경
                        forcount = 0;
                        Sheet changesheet = null;
                        System.out.println("변경할 시트를 골라주세요");
                        for (Sheet sheet : CakeCustomProduct.getSheetList()) {
                            System.out.println(
                                    "[" + (++forcount) + "]번 시트 이름: " + sheet.name + " 가격: " + sheet.price + " 원");
                        }
                        scanner.nextLine();
                        String userChoicestr = scanner.nextLine();
                        
                        for (Sheet sheet : CakeCustomProduct.getSheetList()) {
                            if (userChoicestr.equals(sheet.name)) {
                                changesheet = sheet;
                                changeCustom.setSheet(changesheet);
                                break;
                            }
                        }
                        
                        
                        break;

                    case 2:
                        
                        //생크림 변경
                        forcount = 0;
                        FreshCream changeFreshCream = null;
                        System.out.println("변경할 생크림를 골라주세요");
                        for (FreshCream freshCream : CakeCustomProduct.getFreshCreamList()) {
                            System.out.println(
                                    "[" + (++forcount) + "]번 시트 이름: " + freshCream.name + " 가격: " + freshCream.price + " 원");
                        }
                        scanner.nextLine();
                        userChoicestr = scanner.nextLine();
                        for (FreshCream FreshCream : CakeCustomProduct.getFreshCreamList()) {
                            if (userChoicestr.equals(FreshCream.name)) {
                                changeFreshCream = FreshCream;
                                changeCustom.setFreshcream(changeFreshCream);
                                break;
                            }
                        }

                        break;

                    case 3:
                        
                        //토핑 변경
                        forcount = 0;
                        Topping changeTopping = null;
                        System.out.println("변경할 토핑를 골라주세요");
                        for (Topping topping : CakeCustomProduct.getToppingList()) {
                            System.out.println(
                                    "[" + (++forcount) + "]번 시트 이름: " + topping.name + " 가격: " + topping.price + " 원");
                        }
                        scanner.nextLine();
                        userChoicestr = scanner.nextLine();
                        userChoicestr = scanner.nextLine();
                        for (Topping topping : CakeCustomProduct.getToppingList()) {
                            if (userChoicestr.equals(topping.name)) {
                                changeTopping = topping;
                                changeCustom.setTopping(changeTopping);
                                break;
                            }
                        }

                        break;
                    case 4:
                        //초 갯수 변경
                        
                        int userChoiceint = 0;
                        System.out.println("초의 갯수를 정해주세요");
                        userChoiceint = scanner.nextInt();
                        changeCustom.setCandle(userChoiceNum);

                        break;

                    case 5:
                        
                        //폭죽 갯수 변경
                        userChoiceint = 0;
                        System.out.println("폭죽의 갯수를 정해주세요");
                        userChoiceint = scanner.nextInt();
                        changeCustom.setFireCracker(userChoiceNum);

                        break;

                    case 6:
                        
                        //픽업 날짜 변경
                        System.out.println("픽업할 날짜와 시간을 입력해 주세요 예) 2021-02-14");
                        scanner.nextLine();
                        Date dayBuy = null;
                        Date dayPickUp = null;
                        int compare = 0;
                        
                        
                        //pickUpDate 형식 검사 및 Date타입으로 형변환
                        while(true) {
                            scanner.nextLine();
                            String pickUpDate = scanner.nextLine();
                            if(!datePattern.matcher(pickUpDate).matches()) {
                                System.out.println("형식이 올바르지 않습니다 예) 2021-02-14");
                                continue;
                            }
                            try {
                                dayBuy = sdf.parse(buyDate);
                                dayPickUp = sdf.parse(pickUpDate);
                            } catch (Exception e) {
                                e.printStackTrace();
                                scanner = new Scanner(System.in);
                            }
                            compare = dayBuy.compareTo(dayPickUp);
                            if (compare > 0) {
                                System.out.println("날짜가 올바르지 않습니다.");
                                continue;
                            }else {
                                break;
                            }
                        }
                        changeCustom.setPickupDate(dayPickUp);
                       
                            
                        break;
                        
                    case 7: 
                        System.out.println("종료합니다");
                        return;
                    default:
                        System.out.println("잘못 입력하셨습니다.");
                        break;
                    }

                } else {
                    return;
                }
                return;
            }
        }

    }

    @Override
    public void reservationDelete() {
        // 예약정보 지우기
        System.out.println("고객님의 예약정보를 지우겠습니다..");
        for (Custom userCustom : nowUser.getUserCustom()) {
            System.out.println(userCustom);
            System.out.println("해당 예약정보를 지우겠습니까? 1. yes 2. no");
            int userChoice = scanner.nextInt();
            if (userChoice == 1) {
                balance -= userCustom.getPriceSum();
                nowUser.getUserCustom().remove(userChoice);
                System.out.println("지우기완료");

            } else {
                return;
            }
        }
        // 예약정보 데이터저장
        // orderUser에서도 삭제하기
        for (UserInfo user : orderUser) {
            if (user == nowUser) {
                orderUser.remove(user);
            }
        }

    }

    @Override
    public void pickUp() {
        // 픽업하기
        for (Custom userCustom : nowUser.getUserCustom()) {
            System.out.println(userCustom);
            System.out.println("해당 케이크를 픽업하시겠습니까? 1. yes 2. no");
            int userChoice = scanner.nextInt();
            if (userChoice == 1) {
                userCustom.setReservationStatus(true);
                System.out.println("픽업완료되었습니다.");
            } else {
                System.out.println("픽업취소되었습니다.");
                return;
            }
        }
    }

    public void start() {

        UserInfo userinfo = new UserInfo();

        System.out.println("안녕하세요~ 케잌 하우스입니다.");
        System.out.println("1. 회원가입 2. 로그인");
        int userChoice = scanner.nextInt();
        scanner.nextLine();

        do {
            System.out.println("1. 회원가입 2. 로그인");
            userChoice = scanner.nextInt();
            scanner.nextLine();
        } while (userChoice > 2 || userChoice < 1);

        switch (userChoice) {
        case 1:
            nowUser = userinfo.userJoin();
            start();
            return;

        case 2:
            String id = scanner.nextLine();
            String password = scanner.nextLine();
            nowUser = userinfo.userLogin(id, password);
            break;

        default:
            break;
        }

        orderUser.add(nowUser);

    }

}
