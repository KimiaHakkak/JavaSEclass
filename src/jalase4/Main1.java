package jalase4;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Person> students = new ArrayList<Person>();
        int option = 0;
        do{
            System.out.println("1)Add new student");
            System.out.println("2)Print Age Average");
            System.out.println("3)Count");
            System.out.println("4)Print All");
            System.out.println("0)Exit");
            System.out.print("Enter Option: ");
            option = sc.nextInt();
            System.out.println("------------------------------------------------------");
            switch (option){
                case 1: //Add
                    Person person = new Person();
                    System.out.print("Enter Student Name: ");
                    person.name = sc.nextLine();
                    System.out.print("Enter Student Age: ");
                    person.age = Integer.parseInt(sc.nextLine());
                    students.add(person);
                    break;
                case 2: //Average
                    float sum = 0F;
                    for (int i = 0; i < students.size(); i++){
                        sum += students.get(i).age;
                    }
                    System.out.println("Age Average: " + sum / students.size());
                    break;
                case 3:
                    System.out.println("Count: " + students.size());
                    break;
                case 4:
                    System.out.print("Print All: [");
                    for(int i = 0; i < students.size(); i++) {
                        System.out.print(students.get(i).name + " - " + students.get(i).age + " , ");
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
