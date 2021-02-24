
public class Product {
    protected String name;
    protected int price;
    protected int count;
    
    public Product() {}
    
    public Product(String name, int price, int count) {
        
        this.name = name;
        this.price = price;
        this.count = count;
    }
    @Override
    public String toString() {
        return "Product [name=" + name + ", price=" + price + ", count=" + count + "]";
    }
    
    

}
