

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestPMS {

    public static void displayMenu(){
        System.out.println("-------------------------");
        System.out.println("Product Management System");
        System.out.println("-------------------------");
        System.out.println("1. Add Product\n2. Remove Product\n3. Update Product\n4. Display Products\n5. Exit\n");
        System.out.print("Enter your choice :  ");
    }
    public static void main(String[] args) {
        int choice;
        int pid = 0,quantity = 0;
        double price = 0;
        String name = "",type = "";
        Scanner sc = new Scanner(System.in);
        ProductItems productItems = new ProductItems();
        while(true){
            displayMenu();
            choice = sc.nextInt();
            switch (choice){
                case 1:     // Add Product
                    boolean validInput = false;
                    while (!validInput) {
                        try {
                            System.out.print("\nEnter product id: ");
                            pid = sc.nextInt();
                            sc.nextLine(); // Consume newline left-over
                            System.out.print("\nEnter product name: ");
                            name = sc.nextLine();
                            System.out.print("\nEnter product type: ");
                            type = sc.nextLine();
                            System.out.print("\nEnter product price: ");
                            price = sc.nextDouble();
                            System.out.print("\nEnter product quantity: ");
                            quantity = sc.nextInt();
                            validInput = true; 
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please try again.");
                            sc.nextLine(); // Consume newline left-over                           
                        } 
                    }
                    if (validInput) {
                        System.out.println();
                        Product p = new Product(pid, name, type, price, quantity);
                        productItems.addProduct(p);
                    }
                    break;

                case 2:     //Remove Product
                    System.out.print("\nEnter Product id : ");
                    int id = sc.nextInt();
                    if(productItems.removeProduct(id))
                        System.out.println("Product Removed");
                    else
                        System.out.println("Product not found");
                    System.out.println();
                    break;
                
                case 3:     //Update Product
                    System.out.print("\nEnter Product id : ");
                    int id1 = sc.nextInt();
                    if(!productItems.checkProduct(id1)){
                        System.out.println("Product found.");
                        System.out.print("\nEnter new product name : ");
                        String name1 = sc.next();
                        System.out.print("\nEnter new product type : ");
                        String type1 = sc.next();
                        System.out.print("\nEnter new product price : ");
                        double price1 = sc.nextDouble();
                        System.out.print("\nEnter new product quantity : ");
                        int quantity1 = sc.nextInt();
                        Product p1 = new Product(id1, name1, type1, price1, quantity1);
                        productItems.updateProduct(id1,p1);
                        System.out.println("Product updated.");
                        
                    }
                    else {
                        System.out.println("Product not found.");
                        System.out.println("Do you want to add the Product? (Y/N)");
                        String ch = sc.next().toUpperCase();
                        char c = ch.charAt(0);
                        if(c == 'Y') {
                            System.out.print("\nEnter Product name : ");
                            String name1 = sc.next();
                            System.out.print("\nEnter Product type : ");
                            String type1 = sc.next();
                            System.out.print("\nEnter Product price : ");
                            double price1 = sc.nextDouble();
                            System.out.print("\nEnter Product quantity : ");
                            int quantity1 = sc.nextInt();
                            Product p1 = new Product(id1, name1, type1, price1, quantity1);
                            productItems.addProduct(p1);
                            System.out.println("Product added.");                                                  
                        }
                    }
                    break;

                case 4:     //Display Products
                    System.out.println("\nList of Available Products");
                    System.out.println("---------------------------\n");
                    productItems.displayProducts();
                    System.out.println();
                    break;

                case 5:     //Exit
                    System.out.println("Exiting...");
                    break;
                default:    //Invalid Choice
                    System.out.println("Invalid Choice. Try Again.");
            }
            if (choice == 5)
                break;
        }
        sc.close();
    }

}
