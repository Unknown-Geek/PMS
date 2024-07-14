

public class Product {
    public int pid;
    public String name;
    public String type;
    public double price;
    public int quantity;
    public boolean inStock;

    public Product(int pid, String name, String type, double price, int quantity){
        this.pid = pid;
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        inStock = true;
    }

    @Override
    public String toString() {
        return "Product{" +"pid=" + pid +", name='" + name + '\'' +", type='" + type + '\'' +", price=" + price +", quantity=" + quantity +", inStock=" + inStock +'}';
    }
}
