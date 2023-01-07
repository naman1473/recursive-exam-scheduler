//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////

//

// Title: P06 Exam Scheduler - ExamScheduler Class

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
 * This class consists of collections of static utility methods to help 
 * create the Schedule using recursive methods.
 */
public class ExamScheduler {

    /**
     * Returns a valid Schedule for the given set of rooms and courses
     *
     *
     *
     * @return findScheduleHelper gathers all unassigned courses in a schedule 
     */
    public static Schedule findSchedule(Room[] rooms, Course[] courses) {

        if (findSchedule(rooms, courses) == null) {
            throw new IllegalStateException();
        }
        return findScheduleHelper(new Schedule(rooms, courses), 0);
    }

    /**
     * A private, recursive method that assigns all unassigned courses in a Schedule beginning
     * from the index provided as an argument:
     *
     * @param schedule a valid schedule
     * @param numCourse the number of the given course
     *
     * @throws IllegalStateException if the schedule is invalid
     */
    private static Schedule findScheduleHelper(Schedule schedule, int numCourse) {

        if (numCourse == schedule.getNumCourses()) {
            if (schedule.isComplete()) {
                return schedule;
            }

            throw new IllegalStateException("Schedule is not complete");
        }

        if (schedule.isAssigned(numCourse)) {
            return findScheduleHelper(schedule, numCourse + 1);
        }
        else {

            for (int i = 0; i < schedule.getNumRooms(); i++) {
                try {
                    Schedule newSchedule;
                    newSchedule = schedule.assignCourse(numCourse, i);
                    return findScheduleHelper(newSchedule, numCourse + 1);

                }

                catch (Exception err) {
                    System.out.println(err);
                }
            }
            throw new IllegalStateException("Schedule not valid");
        }
    }


    /**
     * Returns an ArrayList containing all possible Schedules for the given set of rooms
     * and courses
     *
     * @param rooms an array of the rooms available
     * @param courses an array of the unassigned courses
     */
    public static ArrayList<Schedule> findAllSchedules(Room[] rooms, Course[] courses) {
        Schedule schedule;
        schedule = new Schedule(rooms, courses);
        ArrayList<Schedule> scheduleList = new ArrayList<Schedule>();
        return findAllSchedulesHelper(schedule, 0);
        //return findAllSchedulesHelper(new Schedule(rooms, courses), 0);
    }

    /**
     *  A Private, recursive method that assigns all unassigned courses in a Schedule in all possible
     *  ways, beginning from the index provided as an argument:
     *
     * @param schedule a valid schedule
     * @param countCourses counts the number of courses in the schedule
     *
     *
     *
     * @return newSchedule the new schedule made after it is complete
     */
    private static ArrayList<Schedule> findAllSchedulesHelper(Schedule schedule, int countCourses) {
        ArrayList<Schedule> newSchedule = new ArrayList<Schedule>();

        if (countCourses == schedule.getNumCourses()) {

            if (schedule.isComplete()) {
                newSchedule.add(schedule);
                return newSchedule;
            }

            throw new IllegalStateException("Schedule is not complete");
        }

        if ((schedule.isAssigned(countCourses))) {

            newSchedule.addAll(findAllSchedulesHelper(schedule, countCourses + 1));
            return newSchedule;
        } else {
            for (int a = 0; a < schedule.getNumRooms(); a++) {
                try {
                    Schedule new_Schedule = schedule.assignCourse(countCourses, a);
                    newSchedule.addAll(findAllSchedulesHelper(new_Schedule, countCourses + 1));
                } catch (Exception err) {
                    System.out.println(err);
                }
            }
            return newSchedule;
        }
    }
}