package dao;

import static schoolmanagementsystem.HelpFunctions.readInt;
import static schoolmanagementsystem.SchoolManagementSystem.sc;

public class CourseFunctions {

    static CourseDao courseDao = new CourseDao();

    public static void removeCourse() {
        System.out.print("ID:");
        int id = readInt();
        courseDao.removeCourse(id);
    }

    public static void showAllCourses() {
        courseDao.showAllCourses();
    }

    public static void showCourseInfo() {
        System.out.print("ID:");
        int id = readInt();
        courseDao.showCourseInfo(id);
    }

    public static void updateCourse() {
        System.out.print("ID:");
        int id = readInt();
        boolean idExist = courseDao.showCourseInfo(id);
        if (idExist){
        System.out.println("Press enter to leave field unchanged!");
        System.out.print("New course name:");
        String newName = sc.nextLine();
        System.out.println("Press enter to leave field unchanged!");
        System.out.print("New course credit:");
        int newCredit = readInt();
        courseDao.updateCourse(id, newName, newCredit);
        }
    }

    public static void addCourse() {
        System.out.print("Name:");
        String name = sc.nextLine();
        System.out.print("Credit:");
        int credit = readInt();
        courseDao.addCourse(name, credit);
    }

}
