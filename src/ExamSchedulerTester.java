//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////

//

// Title: P06 Exam Scheduler - Testers for Course, Room, Schedule and ExamScheduler class

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

import java.util.ArrayList;

/**
 * Tester methods for the Exam Scheduler program
 * 
 */
public class ExamSchedulerTester {

    /**
     * Checks if the Course() method works without any possible errors
     *
     * @return true if all tests pass, false otherwise
     */
    public static boolean testCourse() {
        String courseName = "astronomy";
        String courseTwo = "bio";
        int studentCount = 190;
        int negStudent = -45;
        Course course = new Course(courseName, studentCount);

        if (!course.getName().equals(courseName)) {
            System.out.println("the wrong course was returned");

            return false;
        }

        if (course.getNumStudents()!= studentCount) {
            System.out.println(" the wrong number of students were returned  = "
                + course.getNumStudents());

            return false;
        }
        {
            try {
                Course testCourse = new Course(courseTwo, negStudent);
            }
            catch (IllegalArgumentException e) {
            }
            catch (Exception e) {
                System.out.println("has to throw an Illegal argument exception");
                return false;
            }

        }
        return true;
    }

    /**
     * Checks if the Room() method works without any possible errors
     *
     * @return true if all tests pass, false otherwise
     */
    public static boolean testRoom() {
        String loc = "Grainer Hall";
        Room Room = new Room(loc, 100);
        if (Room.getCapacity() != 100) {
            System.out.println("Did not retrieve the correct number of students");
        }
        if (!Room.getLocation().equals(loc)) {
            System.out.println("the wrong location was retrieved");
            return false;
        }
        Room.reduceCapacity(10);
        if (Room.getCapacity() != 100) {
            System.out.println("did not work properly");
            return false;
        }
        return true;
    }

    /**
     * Checks if the FindAllSchedules() method works without any possible errors
     *
     * @return true if all tests pass, false otherwise
     */
    public static boolean testFindAllSchedules() {
        String sched = "";
        String courseName = "science";
        String courseTwo = "chem";
        int studentCount = 190;
        int twoStudent = 45;
        String expectedOutput = "";
        ArrayList<Schedule> schedule;

        Course[]  course =
            new Course[] {new Course(courseName,studentCount),
                new Course(courseTwo, twoStudent)};

        Room[] room = new Room[] {new Room("lanthrope", 200),
            new Room("van", 50)};


        schedule = ExamScheduler.findAllSchedules(room, course);

        for (Schedule schedules : schedule) {
            sched = sched + schedules.toString();
        }

        if (!sched.equals( "{"+courseName+": lanthrope,"+courseTwo+": van}")) {
            return false;
        }
        return true;
    }


    /**
     * Checks if the FindSchedule() method works without any possible errors
     *
     * @return true if all tests pass, false otherwise
     */
    public static boolean testFindSchedule() {
        String courseName = "maths";
        String courseTwo = "Maths221";
        int studentCount = 190;
        int twoStudent = 45;
        String expectedOutput = "";

        Course[]  course =
            new Course[] {new Course(courseName,studentCount),
                new Course(courseTwo, twoStudent)};

        Room[] room = new Room[] {new Room("lanthrope", 200),
            new Room("van", 50)};

        ArrayList<Schedule> schedules = ExamScheduler.findAllSchedules(room, course);
        String expectedSchedule = "{"+courseName+": lanthrope,"+courseTwo+": van}" ;

        for (Schedule schedule : schedules) {
            String strings = schedule.toString();
            if (!(strings.equals(expectedSchedule))) {
                return false;
            }
        }
        return true;
    }


    /**
     * Prints the result true or false for all the test methods
     */
    public static void runAllTest(){
        System.out.println(testCourse());
        System.out.println(testRoom());
        System.out.println(testFindSchedule());
        System.out.println(testFindAllSchedules());

    }

    /**
     * Main method for the Exam Scheduler program
     */
    public static void main(String[] args) {
      runAllTest();
    }
}
