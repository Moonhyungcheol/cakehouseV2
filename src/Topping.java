import java.io.Serializable;

public class Topping extends Product implements Serializable{

	public Topping(String name, int price, int count) {
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
