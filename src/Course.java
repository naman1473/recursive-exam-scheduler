//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////

//

// Title: P06 Exam Scheduler - Course Class

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
 * This class utilizes methods such as getName and getNumStudents that all make up
 * the course object 
 */
public class Course {
    
	private String name;
    private int numStudents;

    /**
     * A constructor which assigns the name and number of students to the current arguments
     *
     * @param name the name of the course
     * @param numStudents number of students in the course
     */
    public Course(String name, int numStudents) {
        this.name = name;
        this.numStudents = numStudents;
        
    }
    
    /**
     * Gets the name of the course
     *
     * @return the name of the course
     */
    public String getName() {

        return this.name;
    }

    /**
     * Gets the number of students for the course
     *
     * @return the number of students in the course
     */
    public int getNumStudents()
    {
        return this.numStudents;
    }
}
