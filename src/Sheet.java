import java.io.Serializable;

public class Sheet extends Product implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 6629804335477485154L;

	public Sheet(String name, int price, int count) {
        super(name, price, count);
        // TODO Auto-generated constructor stub
    }
    /*

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getCount() {
		return count;
	}
	*/

}

