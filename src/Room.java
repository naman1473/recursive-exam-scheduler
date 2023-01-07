//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////

//

// Title: P06 Exam Scheduler - Room Class

// Course: CS 300 Spring 2022

// Author: Naman Parekh

// Email: ncparekh@wisc.edu

// Lecturer: Hobbes LeGault

//

//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////

//

// Nisitha De Silva

//

///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////

//

// NONE

//

///////////////////////////////////////////////////////////////////////////////

/**
 * This class utilizes methods such as getLocation and getCapacity that all make up
 * the Room object 
 */
public class Room {
    
	private String location;
    private int capacity;

    /**
     * A constructor which initializes the data fields location and capacity 
     * to the current arguments
     *
     * @param location the location of the room
     * @param capacity the total capacity of the room
     * 
     * @throws IllegalArgumentException if provided capacity is less than zero
     */
    public Room(String location, int capacity) {
        this.location = location;
        this.capacity = capacity;
        
        if (capacity < 0) {
        	throw new IllegalArgumentException("provided capacity is less than zero");
        }

    }

    /**
     * Gets the location of the room
     *
     * @return the location of the room
     */
    public String getLocation() {
        return this.location;
    }

    /**
     * Gets the capacity of the room
     *
     * @return the capacity of the room
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * Reduces the capacity of the room by a specific amount
     *
     * @param reduceCapacity the amount to reduce the capacity of the room
     * 
     * @throws IllegalArgumentException if the amount the user wants to reduce by is greater 
     * than the initial capacity
     */
    public Room reduceCapacity(int reduceCapacity) {
        if (reduceCapacity > this.capacity) {
            throw new IllegalArgumentException("The amount you want to reduce is greater "
                + "than the capacity to begin with");
        }
        
        return new Room(this.location,this.capacity - reduceCapacity);
    }
}

