//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////

//

// Title: P06 Exam Scheduler - Schedule Class

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

import java.util.Arrays;

/**
 * This class manages the schedule depending on the Course and Room objects.
 */
public class Schedule {

    private Room[] rooms;
    private Course[] courses;
    private int[] assignments;

    /**
     * A constructor which initializes the rooms and courses arrays to the provided values
     *
     * @param rooms the rooms array
     * @param courses the courses array
     */
    public Schedule(Room[] rooms, Course[] courses) {
        this.rooms = rooms;
        this.courses = courses;
        this.assignments = new int[courses.length];
        
        for (int a = 0; a < assignments.length; a++) {
        	this.assignments[a] = -1;
        	}
        }

    /**
     * A private constructor which initializes the rooms and courses array to the provided values
     * and assignments to the provided assignments array.
     *
     * @param rooms the rooms array
     * @param courses the courses array
     * @param assignments the assignments array
     */
    private Schedule(Room[] rooms, Course[] courses, int[] assignments) {
        this.rooms = rooms;
        this.courses = courses;
        this.assignments = assignments;
    }

    /**
     * Gets the number of rooms available
     *
     * @return the number of rooms available in this Schedule
     */
    public int getNumRooms() {
        return this.rooms.length;
    }

    /**
     * Returns the room object at the given index in the rooms array
     *
     * @param i the index of the array
     *
     * @throws IndexOutOfBoundsException if the given index is invalid
     */
    public Room getRoom(int i) {
    	
    	try {
    		return this.rooms[i];
    	}
    	
    	catch (IndexOutOfBoundsException err) {
    		throw new IndexOutOfBoundsException("the index is invalid");
    	}
    }
        
    /**
     * Gets the number of courses in this schedule
     *
     * @return the number of courses in this schedule
     */
    public int getNumCourses() {
        return this.courses.length;
    }

    /**
     * Gets the Course object at the given i in the courses array
     *
     * @param i the index of the array
     *
     * @throws IndexOutOfBoundsException if the given index is invalid
     * 
     * @return the Course object at the given index in the courses array
     */
    public Course getCourse(int i) {
        try {
        	return this.courses[i];
        }
        
        catch (IndexOutOfBoundsException err) {
        	throw new IndexOutOfBoundsException("the given index is invalid");
        }
    }

    /**
     * Returns true if and only if the course at the given index has been assigned
     * a room; false otherwise
     *
     * @param index the index of the array
     *
     * @return returns true if the course at the given index has been assigned
     * a room otherwise false
     */
    public boolean isAssigned(int index) {
    	
    	return this.assignments[index] != -1;
        
}

    /**
     * Returns the Room object assigned to the course at the given index
     *
     * @param index the index of the array
     *
     * @throws IllegalArgumentException if the course has not been assigned a room
     * @throws IndexOutOfBoundsException if the given course index is not valid
     */
    public Room getAssignment(int index) {
        try {
            if (this.assignments[index] == -1) {
                throw new IllegalArgumentException("Course does not have a room assignment");
            }
            return this.rooms[this.assignments[index]];

        } catch (IndexOutOfBoundsException err) {
            throw new IndexOutOfBoundsException("the current index is not valid");
        }
    }

    /**
     * Returns true if and only if all courses have been assigned to rooms; false
     * otherwise
     *
     * @return true if all courses have been assigned to rooms otherwise it returns false
     */
    public boolean isComplete() {
        for (int a = 0; a < assignments.length; a++) {
            if (this.assignments[a] == -1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns a new Schedule object with the course at the first argument index assigned
     * to the room at the second argument index
     * 
     * @param indexOne first index
     * @param indexTwo second index
     * 
     * @throws IllegalArgumentException if the given course has already been assigned a room
     * @throws IndexOutOfBoundsException if the given course or room index is invalid
     *
     * @return newShed - a new schedule object with the assigned rooms, courses and assignments
     */
    public Schedule assignCourse(int indexOne, int indexTwo) {
        try {
            if (this.rooms[indexTwo].getCapacity()
            		< this.courses[indexOne].getNumStudents() || this.isAssigned(indexOne)) { 
                throw new IllegalArgumentException ("The course has been assigned to a "
                		+ "room thats already full");
            }
            Room[] copyRooms = Arrays.copyOf(this.rooms, rooms.length);
            Course[] copyCourses = Arrays.copyOf(this.courses, courses.length);
            int[] copyAssignments = Arrays.copyOf(this.assignments, assignments.length);
            copyAssignments[indexOne] = indexTwo;
            copyRooms[indexTwo] = copyRooms[indexTwo].reduceCapacity(copyCourses[indexOne].
                getNumStudents());

            Schedule newShed = new Schedule(copyRooms, copyCourses, copyAssignments);
            return newShed;
        } catch (IndexOutOfBoundsException err) {

            throw new IndexOutOfBoundsException("Index not valid");
        }
    }

    @Override
    public String toString() {
        String displayString;
        int i ;
        displayString = "{";
        
        for (i = 0; i < this.courses.length; i++) {
            if (assignments[i] == 1) {
                displayString = displayString + this.courses[i].getName() + ": "
                + "Unassigned, ";
            }else {

                displayString = displayString + this.courses[i].getName() + ": " +
                    this.rooms[assignments[i]].getLocation() + ", ";
            }
        }
        displayString =
            displayString.substring(0, displayString.lastIndexOf(", "));
        displayString = displayString + "}";
        return displayString;
    }

}
