import java.io.Serializable;

public class FreshCream extends Product implements Serializable {

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
