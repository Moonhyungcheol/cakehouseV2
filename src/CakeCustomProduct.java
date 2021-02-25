import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CakeCustomProduct implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3021091610048695874L;

	private static List<Sheet> sheetList = new ArrayList<Sheet>(); // ��Ʈ
	private static List<FreshCream> freshCreamList = new ArrayList<FreshCream>(); // ��ũ��
	private static List<Topping> toppingList = new ArrayList<Topping>(); // ����

	// ǰ�� �߰�
	/**
	 * ǰ���߰�
	 * @param ���ϼ�
	 */
	public static void productAdd(String product, String name, int price, int count) {

		switch (product) {
		case "Sheet":
			sheetList.add(new Sheet(name, price, count));
			System.out.println("��ǰ��Ͽ� �����Ͽ����ϴ�.");
			break;

		case "FreshCream":
			freshCreamList.add(new FreshCream(name, price, count));
			System.out.println("��ǰ��Ͽ� �����Ͽ����ϴ�.");
			break;

		case "Topping":
			toppingList.add(new Topping(name, price, count));
			System.out.println("��ǰ��Ͽ� �����Ͽ����ϴ�.");
			break;
		default:
			System.out.println("��ǰ��Ͽ� �����Ͽ����ϴ�.");
			System.out.println("�ùٸ� ǰ����� �ƴմϴ�.");
			break;
		}
	}

	/**
	 * ǰ������
	 * @param ���ϼ�
	 */
	// ǰ�� ����
		public static void productDel(String product, int index) {
			switch (product) {
			case "Sheet":
				if((index)>CakeCustomProduct.getSheetList().size()) {
	        		System.out.println("�ùٸ� ��ȣ�� �ƴմϴ�. �ٽ� �Է����ּ���.");
	        		return;
	        	}
				sheetList.remove(index);
				System.out.println("��ǰ���ſ� �����Ͽ����ϴ�.");
				break;

			case "FreshCream":
				if((index)>CakeCustomProduct.getFreshCreamList().size()) {
	        		System.out.println("�ùٸ� ��ȣ�� �ƴմϴ�. �ٽ� �Է����ּ���.");
	        		return;
	        	}
				freshCreamList.remove(index);
				System.out.println("��ǰ���ſ� �����Ͽ����ϴ�.");
				break;

			case "Topping":
				if((index)>CakeCustomProduct.getToppingList().size()) {
	        		System.out.println("�ùٸ� ��ȣ�� �ƴմϴ�. �ٽ� �Է����ּ���.");
	        		return;
	        	}
				toppingList.remove(index);
				break;

			default:
				System.out.println("��ǰ���ſ� �����Ͽ����ϴ�.");
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
