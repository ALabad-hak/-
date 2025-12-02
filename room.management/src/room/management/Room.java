/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package room.management;

/**
 *
 * @author HP
 */
public class Room {
   //  
// ----------------------
//   ✨Atterbutes✨
// ----------------------
    // Use a private : to achieve the Encapsulation
    
    private int NumberOfRoom;   // Variable representing the room number.
    private int NumberOfFloor;  // variable that represents the floor number.
    private String customerName; // Name of the customer who booked the room.
    private int NumberOfPersons; // Number of people in the room.
    private boolean isOccupied; // room condition.
    private double basePrice; // Basic price of the room.
    private String roomType; // Variable represents the type of room.

// ----------------------
//   (Constructor)
// ----------------------   
    public Room( int NumberOfRoom, int NumberOfFloor, String customerName, int NumberOfPersons, boolean isOccupied, double basePrice, String roomType ) {
        this.NumberOfRoom = NumberOfRoom;
        this.NumberOfFloor = NumberOfFloor;
        this.basePrice = basePrice;
        this.roomType = roomType;
        this.NumberOfPersons = NumberOfPersons;
        this.customerName = customerName;  
        this.isOccupied = isOccupied;
        
    }
    
// -------------------------
//   /* Getters & Setters */
// -------------------------   

    public int getNumberOfRoom() {
        return NumberOfRoom;
    }

    public void setNumberOfRoom(int NumberOfRoom) {
        this.NumberOfRoom = NumberOfRoom;
    }

    public int getNumberOfFloor() {
        return NumberOfFloor;
    }

    public void setNumberOfFloor(int NumberOfFloor) {
        this.NumberOfFloor = NumberOfFloor;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public int getNumberOfPersons() {
        return NumberOfPersons;
    }

    public void setNumberOfPersons(int NumberOfPersons) {
        this.NumberOfPersons = NumberOfPersons;
    }

    public boolean isIsOccupied() {
        return isOccupied;
    }

    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

// -------------------------
//   🎗Method toString🎗
// -------------------------
    @Override
    public String toString() {
        return "Room{" + "NumberOfRoom=" + NumberOfRoom + ", NumberOfFloor=" + NumberOfFloor + ", customerName=" + customerName + ", NumberOfPersons=" + NumberOfPersons + ", isOccupied=" + isOccupied + ", basePrice=" + basePrice + ", roomType=" + roomType + '}';
    }

    
    
}

