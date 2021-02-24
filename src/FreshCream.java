import java.io.Serializable;

public class FreshCream extends Product implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1945283063818035476L;

	public FreshCream(String name, int price, int count) {
        super(name, price, count);
        // TODO Auto-generated constructor stub
    }


	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getCount() {
		return count;
	}

}
