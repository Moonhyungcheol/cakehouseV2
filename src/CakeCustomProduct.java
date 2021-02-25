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
	 * 품목추가
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

	/**
	 * 품목제거
	 * @param 조하선
	 */
	// 품목 제거
		public static void productDel(String product, int index) {
			switch (product) {
			case "Sheet":
				if((index)>CakeCustomProduct.getSheetList().size()) {
	        		System.out.println("올바른 번호가 아닙니다. 다시 입력해주세요.");
	        		return;
	        	}
				sheetList.remove(index);
				System.out.println("제품제거에 성공하였습니다.");
				break;

			case "FreshCream":
				if((index)>CakeCustomProduct.getFreshCreamList().size()) {
	        		System.out.println("올바른 번호가 아닙니다. 다시 입력해주세요.");
	        		return;
	        	}
				freshCreamList.remove(index);
				System.out.println("제품제거에 성공하였습니다.");
				break;

			case "Topping":
				if((index)>CakeCustomProduct.getToppingList().size()) {
	        		System.out.println("올바른 번호가 아닙니다. 다시 입력해주세요.");
	        		return;
	        	}
				toppingList.remove(index);
				break;

			default:
				System.out.println("제품제거에 실패하였습니다.");
				break;
			}
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
