package jalase4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<Product>();
        int option = 0;
        do{
            System.out.println("1)Add Product");
            System.out.println("2)Sum Price");
            System.out.println("3)Print Product");
            System.out.println("0)Exit");
            System.out.print("Enter Option: ");
            option = sc.nextInt();
            System.out.println("------------------------------------------------------");
            switch(option){
                case 1: //add
                    Product product = new Product();
                    System.out.print("Enter Product Name: ");
                    product.name = sc.next();
                    System.out.print("Enter Product Price: ");
                    product.price = Integer.parseInt(sc.nextLine());
                    products.add(product);
                    break;
                case 2: //sum
                    float sum = 0F;
                    for(int i=0; i<products.size(); i++){
                        sum += products.get(i).price;
                    }
                    System.out.println("The Sum is: " + sum);
                    break;
                case 3:
                    System.out.print("Print Products: [");
                    for(int i=0; i<products.size(); i++){
                        System.out.print(products.get(i).name + " - " + products.get(i).price + " , ");
                    }
                    System.out.println("\b\b\b]");
                    break;
                case 0:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid Option");
            }
            System.out.println("------------------------------------------------------");
        }while(option != 0);
    }
}
