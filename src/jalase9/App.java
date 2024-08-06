package jalase9;

import jalase9.da.ProductDa;
import jalase9.entity.Product;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ProductDa productDa = new ProductDa();
        Product product;
        int sum = 0;
        int option = 0;
        do {
            try {
            System.out.println("1) Add Product");
            System.out.println("2) Edit Product");
            System.out.println("3) Remove Product");
            System.out.println("4) Invoice List");
            System.out.println("5) Total Price");
            System.out.println("6) Print Invoice");
            System.out.println("0) Exit");
            System.out.print("Enter Option : ");
            option = Integer.parseInt(sc.nextLine());
                System.out.println("----------------------------------------------------------------------------------------------------------");
            switch (option) {
                case 1:
                    product = new Product();

                    System.out.print("Enter product name : ");
                    product.setName(sc.nextLine());

                    System.out.print("Enter product count : ");
                    product.setCount(Integer.parseInt(sc.nextLine()));

                    System.out.print("Enter product price : ");
                    product.setPrice(Double.parseDouble(sc.nextLine()));

                    if (productDa.findByName(product.getName()) == null) {
                        productDa.save(product);
                        System.out.println("Product saved");
                    } else {
                        System.err.println("Product already exists !!!");
                    }
                    break;

                case 2:
                    product = new Product();

                    System.out.print("Enter id : ");
                    product.setId(Integer.parseInt(sc.nextLine()));

                    System.out.print("Enter product name : ");
                    product.setName(sc.nextLine());

                    System.out.print("Enter product count : ");
                    product.setCount(Integer.parseInt(sc.nextLine()));

                    System.out.print("Enter product price : ");
                    product.setPrice(Double.parseDouble(sc.nextLine()));

                    productDa.edit(product);

                    System.out.println("Product edited");
                    break;

                case 3:
                    System.out.print("Enter id : ");
                    int id = Integer.parseInt(sc.nextLine());

                    productDa.remove(id);

                    System.out.println("Product removed");
                    break;

                case 4:
                    System.out.println("Invoice List : ");
                    for (Product p : productDa.findAll()) {
                        System.out.printf("Name : %-20s Count : %-20s Price : %-20s Total : %-20s %n", p.getName(), p.getCount(), p.getPrice(), p.getTotal());
                    }
                    break;

                case 5:
                    System.out.print("Total Price : ");
                    sum = 0;
                    for (Product p : productDa.findAll()) {
                        sum += p.getTotal();
                    }
                    System.out.println("Total price : " + sum);

                    break;

                case 6:
                    System.out.println("Final Invoice : ");
                    for (Product p : productDa.findAll()) {
                        System.out.printf("Name : %-20s Count : %-20s Price : %-20s Total : %-20s %n", p.getName(), p.getCount(), p.getPrice(), p.getTotal());
                    }
                    System.out.println("****************************************************************************************************");
                    sum = 0;
                    for (Product p : productDa.findAll()) {
                        sum += p.getTotal();
                    }
                    System.out.println("Total price : " + sum);

                    break;

                case 0:
                    System.out.println("Bye");
                    break;

                default:
                    System.err.println("Invalid Option");
                    break;
            }
            System.out.println("----------------------------------------------------------------------------------------------------------");
        }catch(Exception e){
            System.err.println("Error : " + e.getMessage() + " try again later!!!");
        }
        }while(option != 0);
    }
}
