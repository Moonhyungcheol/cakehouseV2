import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CakeCustomShop implements StoreOrderSystem {
	private UserInfo nowUser = new UserInfo();
	private List<UserInfo> orderUser = new ArrayList<UserInfo>();
	JoinMenberShip joinmembership = new JoinMenberShip();
	private long balance;
	private int forcount;
	private Scanner scanner = new Scanner(System.in); //
	private Pattern datePattern = Pattern.compile("^([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))$");
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private Date date = new Date();
	private String buyDate = sdf.format(date);

	public CakeCustomShop() {

		/**************** TEST CODE ************************/

//		UserInfo user1 = new UserInfo();
//		UserInfo user2 = new UserInfo();
//		UserInfo user3 = new UserInfo();
//		UserInfo admin = new UserInfo();
//		
//		user1.setId("testUser1");
//		user1.setPassword("testUser1");
//		user1.setName("김");
//		user1.setPhoneNumber("01012341234");
//		
//		user2.setId("testUser2");
//		user2.setPassword("testUser2");
//		user2.setName("이");
//		user2.setPhoneNumber("01012341234");
//		
//		user3.setId("testUser3");
//		user3.setPassword("testUser3");
//		user3.setName("박");
//		user3.setPhoneNumber("01012341234");
//		
//		admin.setId("admin");
//		admin.setPassword("admin");
//		admin.setName("관리자");
//		admin.setPhoneNumber("01012341234");
//		
//		
//		
//		
//		joinmembership.addJoinUser(user1);
//		joinmembership.addJoinUser(user2);
//		joinmembership.addJoinUser(user3);
//		joinmembership.addJoinUser(admin);
//		
//		utils.save("getJoinUser", joinmembership.getJoinUser());
		Utils utils = new Utils();
		joinmembership.setJoinUser(utils.load("getJoinUser"));
		List<Sheet> sheetlist = utils.load("SheetList.txt");
		List<FreshCream> freshlist = utils.load("FreshCreamList.txt");
		List<Topping> toppinglist = utils.load("ToppingList.txt");

		CakeCustomProduct.setSheetList(sheetlist);
		CakeCustomProduct.setFreshCreamList(freshlist);
		CakeCustomProduct.setToppingList(toppinglist);
		/**************** TEST CODE ************************/

	}

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
		forcount = 0;
		System.out.println("시트를 골라주세요");
		for (Sheet sheet : CakeCustomProduct.getSheetList()) {
			System.out.println("[" + (++forcount) + "]번 시트 이름: " + sheet.name + " 가격: " + sheet.price + " 원");
		}

		int userChoice = 0;
		userChoice = Integer.parseInt(scanner.nextLine());

		while (userChoice < 1 || userChoice > CakeCustomProduct.getSheetList().size()) {
			System.out.println("시트를 제대로 골라주세요");
			Integer.parseInt(scanner.nextLine());
		}

		choiceSheet = CakeCustomProduct.getSheetList().get(userChoice - 1);
		--choiceSheet.count;

		// 생크림 만들기
		forcount = 0;
		System.out.println("생크림를 골라주세요");
		for (FreshCream freshcream : CakeCustomProduct.getFreshCreamList()) {
			System.out.println("[" + ++forcount + "]번 생크림 이름: " + freshcream.name + " 가격: " + freshcream.price + " 원");
		}
		userChoice = Integer.parseInt(scanner.nextLine());

		while (userChoice < 1 || userChoice > CakeCustomProduct.getFreshCreamList().size()) {
			System.out.println("생크림을 제대로 골라주세요");
			userChoice = Integer.parseInt(scanner.nextLine());
		}

		choicefreshcream = CakeCustomProduct.getFreshCreamList().get(userChoice - 1);
		--choicefreshcream.count;

		// 토핑 만들기
		forcount = 0;
		System.out.println("토핑을 골라주세요");
		for (Topping topping : CakeCustomProduct.getToppingList()) {
			System.out.println("[" + ++forcount + "]번 토핑 이름: " + topping.name + " 가격: " + topping.price + " 원");
		}
		userChoice = Integer.parseInt(scanner.nextLine());

		while (userChoice < 1 || userChoice > CakeCustomProduct.getToppingList().size()) {
			System.out.println("토핑을 제대로 골라주세요");
			userChoice = Integer.parseInt(scanner.nextLine());
		}

		choiceTopping = CakeCustomProduct.getToppingList().get(userChoice - 1);
		--choiceTopping.count;

		// 초 갯수 정하기
		System.out.println("초의 갯수를 정해주세요");
		int userChoiceint = Integer.parseInt(scanner.nextLine());
		choiceCandleNum = userChoiceint;

		// 폭죽 갯수 정하기
		System.out.println("폭죽의 갯수를 정해주세요");
		userChoiceint = Integer.parseInt(scanner.nextLine());
		fireCracker = userChoiceint;

		// 가격책청
		priceSum = choicefreshcream.price + choiceSheet.price + choiceTopping.price;

		balance += priceSum;

		// 픽업 날짜 정하고 유효성 검사 및 Date 타입 변환 작업
		System.out.println("픽업할 날짜와 시간을 입력해 주세요 예) 2021-02-14");

		Date dayBuy = null;
		Date dayPickUp = null;
		int compare = 0;

		// pickUpDate 형식 검사
		while (true) {
			String pickUpDate = scanner.nextLine();
			if (!datePattern.matcher(pickUpDate).matches()) {
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
			} else {
				break;
			}
		}

		// 픽업 default 값 false
		boolean ReservationStatus = false;
		Custom custom = new Custom(choiceSheet, choicefreshcream, choiceTopping, choiceCandleNum, fireCracker, priceSum,
				dayBuy, ReservationStatus, dayPickUp);
		nowUser.getUserCustom().add(custom);
		orderUser.add(nowUser);

		System.out.println(custom.customCakePrint());
	}

	/**
	 * 예약정보보기
	 * 
	 * @author 조하선
	 */
	@Override
	public void reservationSerch() {
		// 예약정보 출력하기
		System.out.println(nowUser.getName() + "고객님의 예약정보입니다.");
		for (Custom userCustom : nowUser.getUserCustom()) {
			System.out.println(userCustom.reservationcustomCakePrint());
		}
	}

	@Override
	public void reservationChange() {

		System.out.println("예약 주문을 바꾸시겠습니까?");
		System.out.println("1: 예 2: 아니요");
		int userChoiceNum = scanner.nextInt();
		if (userChoiceNum == 1) {
			int index = 0;
			for (Custom userCustom : nowUser.getUserCustom()) {
				System.out.println("[" + (++index) + "]번째 케이크");
				System.out.println(userCustom.changeReservationtoString());
				System.out.println();
			}
			System.out.println("변경하실 케이크의 주문번호를 입력해주세요: ");
			int userChoice = scanner.nextInt();
			scanner.nextLine();
			Custom userCustom = nowUser.getUserCustom().get(userChoice - 1);
			while (true) {
				System.out.println("[1]시트변경 [2]생크림변경 [3]토핑변경 [4]초 갯수 변경 [5]폭죽 갯수 변경 [6]픽업 날짜 변경 [7] 변경 취소");
				userChoice = scanner.nextInt();
				scanner.nextLine();
				switch (userChoice) {

				case 1:

					// 시트 변경
					forcount = 0;
					Sheet changesheet = null;
					System.out.println("변경할 시트를 골라주세요");
					for (Sheet sheet : CakeCustomProduct.getSheetList()) {
						System.out
								.println("[" + (++forcount) + "]번 시트 이름: " + sheet.name + " 가격: " + sheet.price + " 원");
					}
					// userChoice를 인트로 변환후 인데스 값으로 찾기
					userChoice = Integer.parseInt(scanner.nextLine());
					balance -= userCustom.getSheet().price;
					userCustom.getSheet().count++;

					while (userChoice < 1 || userChoice > CakeCustomProduct.getSheetList().size()) {
						System.out.println("생크림을 제대로 골라주세요");
						userChoice = Integer.parseInt(scanner.nextLine());
					}

					changesheet = CakeCustomProduct.getSheetList().get(userChoice - 1);
					changesheet.count--;
					balance += changesheet.price;
					userCustom.setSheet(changesheet);

					break;

				case 2:

					// 생크림 변경
					forcount = 0;
					FreshCream changeFreshCream = null;
					System.out.println("변경할 생크림를 골라주세요");
					for (FreshCream freshCream : CakeCustomProduct.getFreshCreamList()) {
						System.out.println("[" + (++forcount) + "]번 생크림 이름: " + freshCream.name + " 가격: "
								+ freshCream.price + " 원");
					}

					userChoice = Integer.parseInt(scanner.nextLine());
					balance -= userCustom.getFreshcream().price;
					userCustom.getFreshcream().count++;
					while (userChoice < 1 || userChoice > CakeCustomProduct.getFreshCreamList().size()) {
						System.out.println("제대로 골라 주세요");
						userChoice = Integer.parseInt(scanner.nextLine());
					}

					changeFreshCream = CakeCustomProduct.getFreshCreamList().get(userChoice - 1);
					changeFreshCream.count--;
					balance += changeFreshCream.price;
					userCustom.setFreshcream(changeFreshCream);

					break;

				case 3:

					// 토핑 변경
					forcount = 0;
					Topping changeTopping = null;
					System.out.println("변경할 토핑를 골라주세요");
					for (Topping topping : CakeCustomProduct.getToppingList()) {
						System.out.println(
								"[" + (++forcount) + "]번 토핑 이름: " + topping.name + " 가격: " + topping.price + " 원");
					}

					userChoice = Integer.parseInt(scanner.nextLine());
					balance -= userCustom.getTopping().price;
					userCustom.getTopping().count++;
					while (userChoice < 1 || userChoice > CakeCustomProduct.getToppingList().size()) {
						System.out.println("제대로 골라주세요");
						userChoice = Integer.parseInt(scanner.nextLine());
					}
					changeTopping = CakeCustomProduct.getToppingList().get(userChoice - 1);
					changeTopping.count--;
					balance += changeTopping.price;
					userCustom.setTopping(changeTopping);

					break;
				case 4:
					// 초 갯수 변경

					System.out.println("초의 갯수를 정해주세요");
					userChoice = Integer.parseInt(scanner.nextLine());
					userCustom.setCandle(userChoice);
					break;

				case 5:

					// 폭죽 갯수 변경
					System.out.println("폭죽의 갯수를 정해주세요");
					userChoice = Integer.parseInt(scanner.nextLine());
					userCustom.setFireCracker(userChoice);
					break;

				case 6:

					// 픽업 날짜 변경
					System.out.println("픽업할 날짜와 시간을 입력해 주세요 예) 2021-02-14");
					Date dayBuy = null;
					Date dayPickUp = null;
					int compare = 0;

					// pickUpDate 형식 검사 및 Date타입으로 형변환
					while (true) {
						String pickUpDate = scanner.nextLine();
						if (!datePattern.matcher(pickUpDate).matches()) {
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
						} else {
							break;
						}
					}
					userCustom.setPickupDate(dayPickUp);
					break;

				case 7:
					System.out.println("종료합니다");
					return;
				default:
					System.out.println("잘못 입력하셨습니다.");
					break;
				}

			} // while end

		}
	}

	/**
	 * 
	 * 예약정보삭제
	 * 
	 * @author 조하선
	 */
	@Override
	public void reservationDelete() {
		// 예약정보 지우기
		System.out.println("고객님의 예약정보를 지우겠습니다..");

		if (nowUser.getUserCustom().size() == 0) {
			System.out.println("예약정보가 없습니다. 목록으로 돌아갑니다.");
			return;
		}

		int index = 0;
		System.out.println("삭제하실 예약변호를 입력해주세요: ");
		for (Custom userCustom : nowUser.getUserCustom()) {
			if (userCustom.isReservationStatus()) {
				continue;
			}
			System.out.print("[" + (++index) + "]");
			System.out.println(userCustom);
		}
		int userChoice = scanner.nextInt();
		nowUser.getUserCustom().remove(userChoice - 1);

	}

	/**
	 * 
	 * 픽업하기
	 * 
	 * @author 문형철
	 */
	@Override
	public void pickUp() {

		List<Custom> nowUserCustom = nowUser.getUserCustom();
		List<Custom> userCustomList = new ArrayList<>();

		for (Custom custom : nowUserCustom) {
			if (!custom.isReservationStatus()) {
				userCustomList.add(custom);
			}
		}

		if (userCustomList.size() == 0) {
			System.out.println("픽업정보가 없습니다. 목록으로 돌아갑니다.");
			return;
		}

		// 픽업하기
		int index = 0;
		System.out.println("픽업하실 주문번호를 입력해주세요: ");
		for (Custom userCustom : userCustomList) {
			System.out.print("[" + (++index) + "]");
			System.out.println(userCustom);
		}

		int userChoice = Integer.parseInt(scanner.nextLine());

		while (userChoice < 1 || userChoice > index) {
			System.out.println("잘못된 번호입니다. 다시 선택해 주세요.");
			userChoice = Integer.parseInt(scanner.nextLine());
		}

		// 날짜체크
		Date today = Calendar.getInstance().getTime();

		if (today.compareTo(userCustomList.get(userChoice - 1).getPickupDate()) < 0) {
			System.out.println("아직 픽업하실 수 없습니다.");
			pickUp();
			return;
		}

		userCustomList.get(userChoice - 1).setReservationStatus(true);
		System.out.println("픽업완료되었습니다.");
	}
	
	public void randomCake() {
        Sheet randomSheet = null;
        FreshCream randomfreshcream = null;
        Topping randomTopping = null;
        int choiceCandleNum = 0;
        int fireCracker = 0;
        int priceSum = 0;
        Random random = new Random();
        
        System.out.println("초의 갯수를 정해주세요");
        int userChoiceint = Integer.parseInt(scanner.nextLine());
        choiceCandleNum = userChoiceint;

        // 폭죽 갯수 정하기
        System.out.println("폭죽의 갯수를 정해주세요");
        userChoiceint = Integer.parseInt(scanner.nextLine());
        fireCracker = userChoiceint;

        

        // 픽업 날짜 정하고 유효성 검사 및 Date 타입 변환 작업
        System.out.println("픽업할 날짜와 시간을 입력해 주세요 예) 2021-02-14");

        Date dayBuy = null;
        Date dayPickUp = null;
        int compare = 0;

        // pickUpDate 형식 검사
        while (true) {
            String pickUpDate = scanner.nextLine();
            if (!datePattern.matcher(pickUpDate).matches()) {
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
            } else {
                break;
            }
        }
        
        // 랜덤시트 만들기
        randomSheet = CakeCustomProduct.getSheetList().get(random.nextInt(CakeCustomProduct.getSheetList().size()));
        --randomSheet.count;
        balance += randomSheet.price;
        
        //랜덤생크림 만들기
        randomfreshcream = CakeCustomProduct.getFreshCreamList().get(random.nextInt(CakeCustomProduct.getFreshCreamList().size()));
        --randomfreshcream.count;
        balance += randomfreshcream.price;
        
        //랜덤토핑 만들기
        randomTopping = CakeCustomProduct.getToppingList().get(random.nextInt(CakeCustomProduct.getToppingList().size()));
        --randomTopping.count;
        balance += randomTopping.count;
        
        priceSum = randomSheet.price + randomfreshcream.price + randomTopping.price;
        // 가격책청
        balance += priceSum;
        
        boolean ReservationStatus = false;
        Custom custom = new Custom(randomSheet, randomfreshcream, randomTopping, choiceCandleNum, fireCracker, priceSum,
                dayBuy, ReservationStatus, dayPickUp);
        nowUser.getUserCustom().add(custom);
        orderUser.add(nowUser);

        System.out.println(custom.customCakePrint());
    }

	/**
	 * 제품추가
	 * 
	 * @author 조하선
	 */
	public void addProduct() {
		System.out.println("=== 제품등록 ===");
		while (true) {
			System.out.println("추가할 상품 분류를 선택해주세요. ");
			System.out.println("[1] 시트 [2] 생크림 [3] 토핑 [4] 종료");
			int userChoice = scanner.nextInt();
			scanner.nextLine();

			switch (userChoice) {

			case 1:
				System.out.println("시트 제품을 추가합니다.");
				System.out.println("추가할 시트의 이름을 입력해주세요: ");
				String productName = scanner.nextLine();
				for (Sheet sheet : CakeCustomProduct.getSheetList()) {
					if (productName.equals(sheet.name)) {
						System.out.println("이미 추가되어있는 상품입니다.");
						System.out.println("초기 메뉴로 돌아갑니다.");
						addProduct();
						return;
					}
				}
				System.out.println("추가할 시트의 가격을 입력해주세요: ");
				int productPrice = scanner.nextInt();
				System.out.println("추가할 시트의 초기 재고를 입력해주세요: ");
				int productCount = scanner.nextInt();
				CakeCustomProduct.productAdd("Sheet", productName, productPrice, productCount);
				break;

			case 2:
				System.out.println("생크림 제품을 추가합니다.");
				System.out.println("추가할 생크림의 이름을 입력해주세요: ");
				productName = scanner.nextLine();
				for (FreshCream freshCream : CakeCustomProduct.getFreshCreamList()) {
					if (productName.equals(freshCream.name)) {
						System.out.println("이미 추가되어있는 상품입니다.");
						System.out.println("초기 메뉴로 돌아갑니다.");
						addProduct();
						return;
					}
				}
				System.out.println("추가할 생크림의 가격을 입력해주세요: ");
				productPrice = scanner.nextInt();
				System.out.println("추가할 생크림의 초기 재고를 입력해주세요: ");
				productCount = scanner.nextInt();
				CakeCustomProduct.productAdd("FreshCream", productName, productPrice, productCount);
				break;
			case 3:
				System.out.println("토핑 제품을 추가합니다.");
				System.out.println("추가할 토핑의 이름을 입력해주세요: ");
				productName = scanner.nextLine();
				for (Topping topping : CakeCustomProduct.getToppingList()) {
					if (productName.equals(topping.name)) {
						System.out.println("이미 추가되어있는 상품입니다.");
						System.out.println("초기 메뉴로 돌아갑니다.");
						addProduct();
						return;
					}
				}
				System.out.println("추가할 토핑의 가격을 입력해주세요: ");
				productPrice = scanner.nextInt();
				System.out.println("추가할 토핑의 초기 재고를 입력해주세요: ");
				productCount = scanner.nextInt();
				CakeCustomProduct.productAdd("Topping", productName, productPrice, productCount);
				break;
			case 4:
				System.out.println("제품추가를 종료합니다.");
				productListPrint();
				return;

			default:
				System.out.println("올바른 입력값이 아닙니다.");

			}
		}
	}

	/**
	 * 제품삭제
	 * 
	 * @author 조하선
	 */
	public void deleteProduct() {
		System.out.println("=== 제품삭제 ===");
		while (true) {
			try {
				System.out.println("삭제할 상품 분류를 선택해주세요.");
				System.out.println("[1] 시트 [2] 생크림 [3] 토핑 [4] 종료");
				int userChoice = scanner.nextInt();
				scanner.nextLine();
				switch (userChoice) {
				case 1:
					productListPrint("Sheet");
					System.out.println("삭제할 시트번호를 입력해주세요.");
					int userIndex = scanner.nextInt();
					CakeCustomProduct.productDel("Sheet", userIndex - 1);
					break;
				case 2:
					productListPrint("FreshCream");
					System.out.println("삭제할 생크림번호를 입력해주세요.");
					userIndex = scanner.nextInt();
					CakeCustomProduct.productDel("FreshCream", userIndex - 1);
					break;

				case 3:
					productListPrint("Topping");
					System.out.println("삭제할 토핑번호를 입력해주세요.");
					userIndex = scanner.nextInt();
					CakeCustomProduct.productDel("Topping", userIndex - 1);
					break;
				case 4:
					System.out.println("제품 삭제를 종료합니다.");
					productListPrint();
					return;
				default:
					System.out.println("올바른 입력값이 아닙니다.");
					break;
				}
			} catch (Exception e) {
				System.out.println("올바른 입력값이 아닙니다.");
				break;
			}
		}

	}

	/**
	 * 재고관리
	 * 
	 * @author 조하선
	 */
	public void productListPrint() {
		System.out.println("==== BITCAKE CUSTOM MENU ====");
		System.out.println("<< SHEET CUSTOM MENU >>");
		int index = 0;
		for (Sheet sheet : CakeCustomProduct.getSheetList()) {
			System.out.print("[" + (++index) + "]");
			System.out.println(sheet);
		}
		index = 0;
		System.out.println("<< FRESH CUSTOM MENU >>");
		for (FreshCream freshCream : CakeCustomProduct.getFreshCreamList()) {
			System.out.print("[" + (++index) + "]");
			System.out.println(freshCream);
		}
		index = 0;
		System.out.println("<< TOPPING CUSTOM MENU >>");
		for (Topping topping : CakeCustomProduct.getToppingList()) {
			System.out.print("[" + (++index) + "]");
			System.out.println(topping);
		}
	}

	/**
	 * 재고변경
	 * 
	 * @author 조하선
	 */
	public void changeStock() {
		System.out.println("==재고변경==");
		int index = 0;
		while (true) {
			System.out.println("변경할 상품의 분류를 선택해주세요: ");
			System.out.println("[1] 시트 [2] 생크림 [3] 토핑 [4] 종료");
			try {
				int userChoice = scanner.nextInt();
				scanner.nextLine();
				switch (userChoice) {
				case 1:
					productListPrint("Sheet");
					System.out.println("변경을 원하는 시트 번호를 입력해주세요: ");
					int userIndex = scanner.nextInt();
					System.out.println("재고값을 입력해주세요: ");
					int changeCount = scanner.nextInt();
					CakeCustomProduct.getSheetList().get(userIndex - 1).count = changeCount;
					break;
				case 2:
					productListPrint("FreshCream");
					System.out.println("변경을 원하는 생크림 번호를 입력해주세요: ");
					userIndex = scanner.nextInt();
					System.out.println("재고값을 입력해주세요: ");
					changeCount = scanner.nextInt();
					CakeCustomProduct.getFreshCreamList().get(userIndex - 1).count = changeCount;
					break;
				case 3:
					productListPrint("Topping");
					System.out.println("변경을 원하는 토핑번호를 입력해주세요: ");
					userIndex = scanner.nextInt();
					System.out.println("재고값을 입력해주세요: ");
					changeCount = scanner.nextInt();
					CakeCustomProduct.getToppingList().get(userIndex - 1).count = changeCount;
					break;
				case 4:
					System.out.println("재고변경을 종료합니다.");
					productListPrint();
					return;
				default:
					System.out.println("올바른 입력값이 아닙니다.");
					break;
				}
			} catch (Exception e) {
				System.out.println("올바른 입력값이 아닙니다.");
			}

		}
	}

	/**
	 * 판매상태 (주문완료한 사용자 출력)
	 * 
	 * @author 조하선
	 */
	public void orderUserPrint() {
		
		Utils utils = new Utils();
		orderUser = utils.load("OrderUserList.txt");
		
		System.out.println("주문완료한 사용자 목록입니다.");
		for (UserInfo userInfo : orderUser) {
			System.out.println(userInfo);
		}
		System.out.println("현재 잔고: " + this.balance);
	}

	/**
	 * 
	 * 프로그램 시작
	 * 
	 * @author 문형철
	 */
	public void start() {

		System.out.println("어서오세요~ 비트케이크입니다.");
		int userChoice = 0;

		do {
			System.out.println("[1] 회원가입 [2] 로그인");
			userChoice = scanner.nextInt();
			scanner.nextLine();
		} while (userChoice > 3 || userChoice < 1);

		switch (userChoice) {
		case 1:
			// 회원가입
			joinmembership.userJoin();
			start();
			return;

		case 2:
			// 로그인
			System.out.print("ID : ");
			String id = scanner.nextLine();
			System.out.print("PASSWORD : ");
			String password = scanner.nextLine();
			nowUser = joinmembership.userLogin(id, password);
			break;
			
		case 3:
			//시스템 종료
			System.exit(0);
		}

		if (nowUser == null) {
			start();
			return;
		}

		if (nowUser != null && nowUser.getId().equals("admin")) { // 매니저회원과 아이디가 일치하면
			// 매니저 메뉴를 보여준다.
			managerMenu();
		} else if (nowUser != null) {
			// 일반 유저 메뉴를 보여준다.
			orderUser.add(nowUser);
			userMenu();
		}

	}

	/**
	 * 매니저 메뉴 호출
	 * 
	 * @author 문형철
	 */
	public void managerMenu() {
		int userChoice = 0;

		loop_1: while (true) {

			do {
				System.out.println("[1] 상품추가 [2] 상품삭제 [3] 재고관리 [4] 재고변경 [5] 판매상태 [6] 초기화면");
				userChoice = scanner.nextInt();
				scanner.nextLine();
			} while (userChoice < 1 || userChoice > 6);

			switch (userChoice) {

			// 제품추가
			case 1:
				addProduct();
				continue loop_1;

			// 제품삭제
			case 2:
				deleteProduct();
				continue loop_1;

			// 재고관리
			case 3:
				productListPrint();
				continue loop_1;
			// 재고변경
			case 4:
				changeStock();
				continue loop_1;

			// 판매정보
			case 5:
				orderUserPrint();
				break;
				
			case 6:
				start();
				return;
			}
		}

	}

	public void userMenu() {

		int userChoice = 0;

		while (true) {
			do {
				System.out.println("[1] 주문하기 [2] 예약조회 [3] 예약변경 [4] 예약취소 [5] 픽업하기 [6] 로그아웃");
				userChoice = scanner.nextInt();
				scanner.nextLine();
			} while (userChoice < 1 || userChoice > 6);

			switch (userChoice) {
			// 주문하기
			case 1:
				order();
				break;

			// 예약조회
			case 2:
				reservationSerch();
				break;

			// 예약변경
			case 3:
				reservationChange();
				break;

			// 예약취소
			case 4:
				reservationDelete();
				break;

			// 픽업하기
			case 5:
				pickUp();
				break;

			// 로그아웃
			case 6:
				Utils utils = new Utils();
				utils.save("OrderUserList.txt", orderUser);
				start();
				return;

			default:
				break;
			}

		} // while end

	}

	/**
	 * 
	 * 관리자가 확인하는 판매 품목
	 * 
	 * @author 문형철
	 */
	public void receiptTxt() {

		try (FileOutputStream fos = new FileOutputStream(new File("receipt.txt"));
				BufferedOutputStream bos = new BufferedOutputStream(fos)) {

			List<Custom> out = nowUser.getUserCustom();

			for (Custom aa : out) {
				bos.write(aa.toString().getBytes());
				bos.write("\n".getBytes());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 제품 리스트 출력
	 * 
	 * @param 조하선
	 */
	private void productListPrint(String product) {
		int indext = 0;
		switch (product) {
		case "Sheet":
			for (Sheet sheet : CakeCustomProduct.getSheetList()) {
				System.out.print("[" + (++indext) + "]");
				System.out.println(sheet);
			}
			break;
		case "FreshCream":
			for (FreshCream freshCream : CakeCustomProduct.getFreshCreamList()) {
				System.out.print("[" + (++indext) + "]");
				System.out.println(freshCream);
			}
			break;

		case "Topping":
			for (Topping topping : CakeCustomProduct.getToppingList()) {
				System.out.print("[" + (++indext) + "]");
				System.out.println(topping);
			}
			break;
		default:
			break;
		}
	}

}
