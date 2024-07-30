package jalase6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int option = 0;
        do{
            System.out.println("1) Phone");
            System.out.println("2) Laptop");
            System.out.println("3) Sofa");
            System.out.println("0) Exit");
            System.out.print("Enter Option : ");
            option = Integer.parseInt(sc.nextLine());
            System.out.println("------------------------------------------------------");
            switch (option){
                case 1:
                    Phone phone = new Phone();
                    System.out.print("Enter the screen size : ");
                    try {
                        phone.setScreenSize(Integer.parseInt(sc.nextLine()));
                        System.out.println("Screen size is : " + phone.getScreenSize());
                    }catch (NumberFormatException e){
                        System.out.println("Invalid Screen Size, Exiting...");
                    }
                    break;
                case 2:
                    System.out.println("1) Dell");
                    System.out.println("2) Asus");
                    System.out.println("Select please : ");
                    try{
                        int select =Integer.parseInt(sc.nextLine());
                        if(select == 1){
                            Dell dell = new Dell();
                            dell.setPrice(1000);
                            dell.setCpu("core i7");
                            System.out.print("is touch screen available? (true/false) : ");
                            dell.setTouch(Boolean.parseBoolean(sc.nextLine()));
                            System.out.println("Laptop price is : " + dell.getPrice() + "and cpu is : " + dell.getCpu());
                            System.out.println("touch : " + dell.isTouch());
                        }else if(select == 2){
                            Asus asus = new Asus();
                            asus.setPrice(1000);
                            asus.setCpu("core i7");
                            System.out.print("Enter the battery : ");
                            asus.setBattery(sc.nextLine());
                            System.out.println("Laptop price is : " + asus.getPrice() + "and cpu is : " + asus.getCpu());
                            System.out.println("Battery is : " + asus.getBattery());
                        }
                    }catch (NumberFormatException e){
                        System.out.println("Error, Exiting...");
                    }
                    break;
                case 3:
                    Sofa sofa = new Sofa();
                    System.out.print("Enter how many people is the sofa for : ");
                    try {
                        sofa.setPersonNum(Integer.parseInt(sc.nextLine()));
                        System.out.println("Person number is : " + sofa.getPersonNum());
                    }catch (NumberFormatException e){
                        System.out.println("Invalid person number, Exiting...");
                    }
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid Option");
            }
            System.out.println("------------------------------------------------------");
        }while(option!=0);
    }
}
