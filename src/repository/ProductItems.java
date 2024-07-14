package repository;

import java.util.ArrayList;
import entity.Product;

public class ProductItems {
    static ArrayList<Product> productList = new ArrayList<>();

    public void addProduct(Product product) {
        productList.add(product);
    }

    public boolean removeProduct(int product_id) {
        for(int i = 0; i < productList.size(); i++){
            Product product = productList.get(i);
            if (product.pid == product_id) {
                productList.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean checkProduct(int product_id) {
        for(int i = 0; i < productList.size(); i++){
            Product p = productList.get(i);
            if (p.pid == product_id) {
                return true;
            }
        }
        return false;
    }

    public boolean updateProduct(int product_id, Product product) {
        for(int i = 0; i < productList.size(); i++){
            Product p = productList.get(i);
            if (p.pid == product_id) {
                productList.set(i, product);
                return true;
            }
        }
        return false;
    }

    public void displayProducts(){
        if(productList.isEmpty()){
            System.out.println("No Products Available");
            return ;
        }
        
        System.out.println("Product id\tName\tType\tPrice\tQuantity\tAvailability");
        System.out.println("--------------------------------------------------------------------");
        
        for(Product product : productList){
            String stock = product.inStock ? "In Stock" : "Out of Stock";
            System.out.printf("%d\t\t%s\t%s\t%.2f\t%d\t\t%s%n", 
                product.pid, product.name, product.type, product.price, product.quantity, stock);
        }
    }
}