/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package room.management;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class RoomManager {

    // A  private field represents the list of rooms.
 private final List<Room> roomsList;
    // A private field represents total revenue.
 private double totalRevenue;

    // Constructor.
 public RoomManager() {
     this.roomsList = new ArrayList<>();
     this.totalRevenue = 0.0;
     
 }    
  public Room findRoomByNumber(int roomNumber) {
     for(Room room : roomsList) {
         if(room.getNumberOfRoom() == roomNumber) {
             return room;   
         }    
     }
        return null;
 }
 
    // ⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂
    // The First Method (Addittion)
    //⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂    
 public void addRoom(int NumberOfRoom ,int NumberOfFloor,  int NumberOfPersons, double basePrice, String roomType) { 
    Room Check_the_room = findRoomByNumber(NumberOfRoom);
    
    if(Check_the_room != null) {
        System.out.println("The room is already in the system : " + NumberOfRoom);
    }
    else {
    Room newRoom = new Room(NumberOfRoom, NumberOfFloor, "Available", NumberOfPersons,  false, basePrice, roomType);
        roomsList.add(newRoom);
 }
}  

 // ⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂
   // The Second Method (Updata)
   //⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂
public boolean updateRoomPrice(int roomNumber, double newPrice) {
    Room roomToUpdata = findRoomByNumber(roomNumber);
            if (roomToUpdata != null) {
                roomToUpdata.setBasePrice(newPrice);
                System.out.println("The room rate has been updated... " + roomNumber + "to " + newPrice);
                return true;
            }
                System.out.println("The room was not found " + roomNumber);
                return false;
}           

// ⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂
   // The Third Method
   //⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂
public boolean bookRoom(int roomNumber, String customerName, int numPersons) {
    Room roomToBook = findRoomByNumber(roomNumber);
    
    if (roomToBook == null || roomToBook.isIsOccupied()) {
        System.out.println("Booking failed : Either the room is (not available) or (already occupied)");
        return false;
    }
    
    roomToBook.setIsOccupied(true);
    roomToBook.setCustomerName(customerName);
    roomToBook.setNumberOfPersons(numPersons);
    
    this.totalRevenue += roomToBook.getBasePrice();
    System.out.println("The room has been successfully booked. " + roomNumber + "for Mr." + customerName);
    return true;  
}

    // ⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂
    // Check-out / Unbook
    //⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂
    public boolean unbookRoom(int roomNumber) {
        Room roomToUnbook = findRoomByNumber(roomNumber);
        if (roomToUnbook == null) {
            System.out.println("Check-out failed: Room " + roomNumber + " not found.");
            return false;
        }
        if (!roomToUnbook.isIsOccupied()) {
            System.out.println("Check-out failed: Room " + roomNumber + " is already available.");
            return false;
        }
        
        String customer = roomToUnbook.getCustomerName();
        roomToUnbook.setIsOccupied(false);
        roomToUnbook.setCustomerName("Available");
        roomToUnbook.setNumberOfPersons(0);  
        
        System.out.println("Check-out successful for room " + roomNumber + ". Customer: " + customer);
        return true;
    }

// ⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂
   // The fourth Method (deletion)
   //⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂
public boolean deleteRoom(int roomNumber) {
     boolean removed = roomsList.removeIf(room -> room.getNumberOfRoom() == roomNumber);
     if (removed) {
         System.out.println("The room was successfully deleted." + roomNumber);
     }
         else { 
          System.out.println("The room was not found and was NOT deleted." + roomNumber);            
        }
         return removed;
     }
     // Method to display all records (Getter).
    public List<Room> getAllRooms() {
        return roomsList;
    }

    // A Method to obtain revenue (Getter).
    public double getTotalRevenue() {
        return totalRevenue;
    }
        

}