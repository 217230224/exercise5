package prog2.exercise5.collections;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        OrderProcessing orderProcessing = new OrderProcessing();
        System.out.println( "Welcome to the Turn-A-New-Leaf Bookstore" );
        int choice;
        do{
        System.out.println("Now you can do the following:");
        System.out.println("Type 1 to place new orders.");
        System.out.println("Type 2 to search for a user's order.");
        System.out.println("Type 3 to remove a user's order.");
        System.out.println("Type 4 to display all of the orders.");
        System.out.println("Type 5 to quit.");
        System.out.println("Enter the choice what you want to do(1-5):");
        choice = reader.nextInt(); 
        reader.nextLine();
        switch(choice){
            case 1:
            orderProcessing.addOrder();
            break;
            case 2:
            System.out.println("Enter the user ID to find the its details:");
            String ID = reader.nextLine();
            orderProcessing.searchUserOrders(ID);
            break;
            case 3:
            System.out.println("Enter the user ID what you want to remove:");
            String userID = reader.nextLine();
            orderProcessing.removeUserOrders(userID);
            break;
            case 4:
            System.out.println("Display all userOrders:");
            System.out.println("------------------------------------");
            orderProcessing.displayAllUserOrders();
            break;
            case 5:
            break;
        }
        }while(choice!=5);
        reader.close();
    }
}