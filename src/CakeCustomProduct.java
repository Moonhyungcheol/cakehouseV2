import java.util.ArrayList;
import java.util.List;

public class CakeCustomProduct {
    private static List<Sheet> sheetList = new ArrayList<Sheet>(); //시트
    private static List<FreshCream> freshCreamList = new ArrayList<FreshCream>(); //생크림
    private static List<Topping> toppingList = new ArrayList<Topping>(); //토핑

    
    // 품목 추가
    /**
     * 
     * @param 조하선
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
    			System.out.println("제품등록에 성공하였습니다.");
    			break;
    			
    		case "FreshCream":
    			for(FreshCream freshCream : freshCreamList) {
    				if(freshCream.name.equals(name)) {
    					return;
    				} else {
    					freshCreamList.add(new FreshCream(name, price, count));
    				}
    			}
    			System.out.println("제품등록에 성공하였습니다.");
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
    			System.out.println("제품등록에 실패하였습니다.");
    			System.out.println("올바른 품목명이 아닙니다.");
    			break;
    	}
    }
    
    // 품목 제거
    public void productDel(String product, String name) {
    
    	switch (product){
		case "Sheet": 
			for(Sheet sheet : sheetList) {
				if(sheet.name.equals(name)) {
					sheetList.remove(sheet);
				}
			}
			System.out.println(name+" 제거완료");
			break;
			
		case "FreshCream":
			for(FreshCream freshCream : freshCreamList) {
				if(freshCream.name.equals(name)) {
					freshCreamList.remove(freshCream);
				} 
			}
			System.out.println(name+" 제거완료");
			break;
			
		case "Topping":
			for(Topping topping : toppingList) {
				if(topping.name.equals(name)) {
					toppingList.remove(topping);
				} 
			}
			System.out.println(name+" 제거완료");
			break;
			
		default:
			System.out.println("제품등록에 실패하였습니다.");
			System.out.println("올바른 품목명이 아닙니다.");
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
    
    
}
