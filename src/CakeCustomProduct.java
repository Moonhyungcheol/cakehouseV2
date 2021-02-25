import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CakeCustomProduct implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3021091610048695874L;

	private static List<Sheet> sheetList = new ArrayList<Sheet>(); // 시트
	private static List<FreshCream> freshCreamList = new ArrayList<FreshCream>(); // 생크림
	private static List<Topping> toppingList = new ArrayList<Topping>(); // 토핑

	// 품목 추가
	/**
	 * 
	 * @param 조하선
	 */
	public static void productAdd(String product, String name, int price, int count) {

		switch (product) {
		case "Sheet":
			sheetList.add(new Sheet(name, price, count));
			System.out.println("제품등록에 성공하였습니다.");
			break;

		case "FreshCream":
			freshCreamList.add(new FreshCream(name, price, count));
			System.out.println("제품등록에 성공하였습니다.");
			break;

		case "Topping":
			toppingList.add(new Topping(name, price, count));
			System.out.println("제품등록에 성공하였습니다.");
			break;
		default:
			System.out.println("제품등록에 실패하였습니다.");
			System.out.println("올바른 품목명이 아닙니다.");
			break;
		}
	}

	// 품목 제거
	public static void productDel(String product, String name) {
		int count = 0;
		switch (product) {
		case "Sheet":
			for (Sheet sheet : sheetList) {
				if (sheet.name.equals(name)) {
					sheetList.remove(sheet);
					System.out.println("["+name+"]" + " 제품제거에 성공하였습니다.");
					count++;
				}
			}
			if (count == 0) {
				countCheck(name);
			} 
			break;

		case "FreshCream":
			for (FreshCream freshCream : freshCreamList) {
				if (freshCream.name.equals(name)) {
					freshCreamList.remove(freshCream);
					System.out.println("["+name+"]" + " 제품제거에 성공하였습니다.");
					count++;
				}
			}
			if (count == 0) {
				countCheck(name);
			} 
			break;

		case "Topping":
			for (Topping topping : toppingList) {
				if (topping.name.equals(name)) {
					toppingList.remove(topping);
					System.out.println("["+name+"]" + " 제품제거에 성공하였습니다.");
					count++;
				}
			}
			if (count == 0) {
				countCheck(name);
			} 
			break;

		default:
			System.out.println("제품등록에 실패하였습니다.");
			System.out.println("올바른 품목명이 아닙니다.");
			break;
		}
	}

	public static void countCheck(String str) {
		System.out.println("해당 제품명은 존재하지 않습니다.");
		System.out.println("확인 후 다시 이용해주세요.");
		System.out.println("입력하신 제품명: " + str);
	}

	public static List<Sheet> getSheetList() {
		return sheetList;
	}

	public static List<FreshCream> getFreshCreamList() {
		return freshCreamList;
	}

	public static List<Topping> getToppingList() {
		return toppingList;
	}

	public static void setSheetList(List<Sheet> list) {
		sheetList = list;
	}

	public static void setFreshCreamList(List<FreshCream> list) {
		freshCreamList = list;
	}

	public static void setToppingList(List<Topping> list) {
		toppingList = list;
	}

}
