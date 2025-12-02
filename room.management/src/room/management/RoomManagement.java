/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package room.management;

import java.util.Scanner;
import java.util.List;
/**
 *
 * @author HP
 */
public class RoomManagement {

    /**
     * @param args the command line arguments
     */
    // ------------------------------------------------
    // الدالة الرئيسية (Main Method)
    // ------------------------------------------------
    public static void main(String[] args) {
        // TODO code application logic here
        RoomManagement app = new RoomManagement();
        app.start();
    
    }
    
    private final RoomManager manager = new RoomManager();
    private final Scanner input = new Scanner(System.in);
    
    // Initialization.
    public RoomManagement() {
      manager.addRoom(99,1,2,0.0d,"roo-type");
      manager.addRoom(5,1,3,150.0d,"Standard Room");
      manager.addRoom(24,4,5,200.0d,"Deluxe Room");
      manager.addRoom(60,7,7,388.0d,"Connecting Room");
  }
    
    public void start() {
        System.out.println("💛💛💛💛💛💛💛💛💛💛💛💛💛💛💛💛💛💛💛💛💛💛💛💛💛💛💛");
        System.out.println("💛💛               Welcome                💛💛");
        System.out.println("💛💛  This is a system seven-star hotel   💛💛");
        System.out.println("💛💛💛💛💛💛💛💛💛💛💛💛💛💛💛💛💛💛💛💛💛💛💛💛💛💛💛");

        int choice;
        do {
           displayMenu();
           choice = getChoice();
           executeChoice(choice);
        }
        while(choice != 0);
//                input.close();
               System.out.println("Thank you for using the system.");                
    }

    private void displayMenu() {
    System.out.println("✨✨✨✨✨✨✨✨");
    System.out.println("✨          ✨");
    System.out.println("✨ Main menu✨");
    System.out.println("✨          ✨");
    System.out.println("✨✨✨✨✨✨✨✨");
        System.out.println("1. Add a new room ");
        System.out.println("2. View all rooms");
        System.out.println("3. Search for a room by its number");
        System.out.println("4. Book a room");
        System.out.println("5.Room price adjustment");
        System.out.println("6. Delete room");
        System.out.println("7.Total revenue display");
        System.out.println("8. Unbook a room (Check-out)");
        System.out.println("0. exit");
    System.out.println("-------------------------------");
        System.out.print("Please enter your choice : ");
    }
    
    private int getChoice() {
        try {
            if (input.hasNextInt()) {
                int choice = input.nextInt();
                input.nextLine();
                return choice;
            }
            else {
                input.nextLine();
                return -1;
            }           
        }
        catch (Exception e) {
            input.nextLine();
            return -1;
        }

    }  
    
    private void executeChoice(int choice) {
        switch (choice) {
            case 1: handleAddRoom();
               break;
            case 2: displayRooms(manager.getAllRooms());
               break;
            case 3: handleSearch(); 
               break;
            case 4: handleBooking(); 
               break;
            case 5: handleUpdatePrice();
               break;
            case 6: handleDeleteRoom(); 
               break;
            case 7: System.out.printf("Total revenues achieved : %.2f%n ", manager.getTotalRevenue()); 
               break;
            case 8: handleUnbook(); 
               break;
            case 0: break;
            default: System.out.println("Invalid option. Please try again.");
        }
    }
     
    private void handleAddRoom() {
        System.out.println("**********************");
        System.out.println("--Add a new room--");
        System.out.println("**********************");
        System.out.print("💻Enter the number Of room : ");
        int number = input.nextInt();
        input.nextLine();
        System.out.print("💻Enter the number Of floor : ");
        int floor = input.nextInt();
        input.nextLine();
        System.out.print("💻Enter the number Of persons : ");
        int numberperson = input.nextInt();
        input.nextLine();
        
        System.out.println("💻Choose the room type : ");
        System.out.println(" 1. Connecting Room.");
        System.out.println(" 2. Deluxe Room.");
        System.out.println(" 3. Standard Room.");
        System.out.println(" 4. Luxury Penthouse.");
        System.out.print("💻Enter your choice (1-4) : ");
        
        if (!input.hasNextInt()) {
            System.out.println(" ...Invalid entry... ");
            System.out.println("Please enter a number from 1 to 4 : ");
            input.nextLine();
            return;
        }
        int typeChoice = input.nextInt();
        input.nextLine();
        String type;
        double price;
        
        switch (typeChoice) {
            case 1:
                type = "Connecting Room";
                price = 388.0d;
                break;
            case 2:
                type = "Deluxe Room";
                price = 200.0d;
                break;
            case 3:
                type = "Standard Room";
                price = 150.0d;
                break;
            case 4:
                type = "Luxury Penthouse";
                price = 499.0d;
                break;
            default :
                System.out.println("Invalid choice");
                return;
        }

        manager.addRoom(number, floor, numberperson, price, type);
       System.out.println("The room has been added " + number);
    }
    
    private void handleSearch() {
        System.out.println("**************************************");
        System.out.println("   Searching for a room by its number  ");
        System.out.println("**************************************");
        System.out.print("Enter the room number to search...");
        if (input.hasNextInt()) {
            int number = input.nextInt();
            input.nextLine();
            Room room = manager.findRoomByNumber(number);
            if (room != null) {
                System.out.println("The room was found :");
                System.out.println(room.toString());
            } else {
                System.out.println("Room number " + number + " not found" );
            }
        } else {
            System.out.println("Invalid entry.");
            input.nextLine();
        }
    }
   
    private void handleBooking() {
        System.out.println("******************");
        System.out.println("--Book a room--");
        System.out.println("******************");
        System.out.print("Enter the room number you wish to book.");
        int number = input.nextInt();
        input.nextLine();
        
        Room roomToCheck = manager.findRoomByNumber(number);
        if (roomToCheck == null) {
            System.out.println("Room number() " + number + "Not found");
            return;
        }
        System.out.print("Enter guest name");
        String name = input.nextLine();
        System.out.print("Enter the number of people");
        int persons = input.nextInt();
        input.nextLine();

        manager.bookRoom(number, name, persons);
    }
    
    private void handleUpdatePrice() {
        System.out.println("***********************");
        System.out.println("Room price adjustment");
        System.out.println("***********************");
        System.out.print("Enter the room number for which you want to adjust the price.");
        int number = input.nextInt();
        System.out.print("Enter the new price ");
        double price = input.nextDouble();
        input.nextLine();
        
        manager.updateRoomPrice(number, price);
    }
    
    private void handleDeleteRoom() {
        System.out.println("*****************");
        System.out.println("--Delete room--");
        System.out.println("*****************");
        System.out.print("Enter the room number you want to delete");
        if (input.hasNextInt()) {
            int number = input.nextInt();
            input.nextLine();
            manager.deleteRoom(number);
        } else {
            System.out.println("Invalid entry.");
            input.nextLine();
        }
    }
    
    private void handleUnbook() {
        System.out.println("******************");
        System.out.println("--Unbook a room (Check-out)--");
        System.out.println("******************");
        System.out.print("Enter the room number for check-out: ");
        
        if (input.hasNextInt()) { 
            int number = input.nextInt();
            input.nextLine();
            manager.unbookRoom(number);
        } else {
            System.out.println("Invalid entry. Please enter a valid room number.");
            input.nextLine();
        }
    }
    
    private void displayRooms(List<Room> rooms) {
        if (rooms.isEmpty()) {
            System.out.println("--- There are no rooms in the system. ---");
            return;
        }
        System.out.println("---List of all rooms" + rooms.size() + "room---");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        
       rooms.forEach(room -> {
            System.out.println(room.toString());
        });
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");

    } 

}
//System.out.println("|-------------------------------|");
//System.out.println("|🛏This is a small-scale project|") ;                   
//System.out.println("|   for managing hotel rooms.   |") ;
//System.out.println("|📄 Adaptable and adjustable    |") ;
//System.out.println("|            in the future.     |") ;
//System.out.println("|💻 To access the rest of the   |") ;
//System.out.println("|project rights(e.g.UML Diagram)|") ;
//System.out.println("|🎓 For more details,           |") ;
//System.out.println("|     please contact us :       |") ;
//System.out.println("|   ✅albad107aam@gmail.com .   |") ;
//System.out.println("|   ✅773127190.                |") ;
//System.out.println("|       ❤Thanks❤               |") ;
//System.out.println("|-------------------------------|") ;
