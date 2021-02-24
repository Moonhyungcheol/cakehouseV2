import java.util.ArrayList;
import java.util.List;

public class CakeCustomProduct {
    private static List<Sheet> sheetList = new ArrayList<Sheet>(); //��Ʈ
    private static List<FreshCream> freshCreamList = new ArrayList<FreshCream>(); //��ũ��
    private static List<Topping> toppingList = new ArrayList<Topping>(); //����

    
    // ǰ�� �߰�
    /**
     * 
     * @param ���ϼ�
     */
    public void productAdd(String product, String name, int price, int count) { 
    	
    	switch (product){
    		case "Sheet": 
    			for(Sheet sheet : sheetList) {
    				if(sheet.name.equals(name)) {
    					return;
    				} else {
    					sheetList.add(new Sheet(name, price, count));
    				}
    			}
    			System.out.println("��ǰ��Ͽ� �����Ͽ����ϴ�.");
    			break;
    			
    		case "FreshCream":
    			for(FreshCream freshCream : freshCreamList) {
    				if(freshCream.name.equals(name)) {
    					return;
    				} else {
    					freshCreamList.add(new FreshCream(name, price, count));
    				}
    			}
    			System.out.println("��ǰ��Ͽ� �����Ͽ����ϴ�.");
    			break;
    			
    		case "Topping":
    			for(Topping topping : toppingList) {
    				if(topping.name.equals(name)) {
    					return;
    				} else {
    					toppingList.add(new Topping(name, price, count));
    				}
    			}
    			break;
    		default:
    			System.out.println("��ǰ��Ͽ� �����Ͽ����ϴ�.");
    			System.out.println("�ùٸ� ǰ����� �ƴմϴ�.");
    			break;
    	}
    }
    

    // ǰ�� ����
    public static void productDel(String product, String name) {
    	int count=0;
    	switch (product){
		case "Sheet": 
			for(Sheet sheet : sheetList) {
				if(sheet.name.equals(name)) {
					sheetList.remove(sheet);
					count++;
				}
			}
			if(count==0) {
				countCheck(name);
			}else {
				System.out.println(name+" ���ſϷ�");
			}
			break;
			
		case "FreshCream":
			for(FreshCream freshCream : freshCreamList) {
				if(freshCream.name.equals(name)) {
					freshCreamList.remove(freshCream);
					count++;
				} 
			}
			if(count==0) {
				countCheck(name);
			}else {
				System.out.println(name+" ���ſϷ�");
			}
			break;
			
		case "Topping":
			for(Topping topping : toppingList) {
				if(topping.name.equals(name)) {
					toppingList.remove(topping);
					count++;
				} 
			}
			if(count==0) {
				countCheck(name);
			}else {
				System.out.println(name+" ���ſϷ�");
			}
			break;
			
		default:
			System.out.println("��ǰ��Ͽ� �����Ͽ����ϴ�.");
			System.out.println("�ùٸ� ǰ����� �ƴմϴ�.");
			break;
    	}
    }
    
    public static void countCheck(String str) {
		System.out.println("�ش� ��ǰ���� �������� �ʽ��ϴ�.");
		System.out.println("Ȯ�� �� �ٽ� �̿����ּ���.");
		System.out.println("�Է��Ͻ� ��ǰ��: "+str);
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
    
    
}
