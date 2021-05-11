package dao;

import static schoolmanagementsystem.SchoolManagementSystem.sc;

public class GenericFunctions {
    static GenericDao genericDao = new GenericDao();
    public static void showStatistics() {
//        genericDao.showStatistics();
    }

    public static void showAllTeachersInCourse() {
        System.out.println("ID:");
        int id = sc.nextInt();
        sc.nextLine();
        genericDao.showAllTeachersInCourse(id);
    }

    public static void disconnectTeacherFromCourse() {
        System.out.println("ID of teacher:");
        int teacherId = sc.nextInt();
        sc.nextLine();
        System.out.println("ID of course:");
        int courseId = sc.nextInt();
        sc.nextLine();
        genericDao.disconnectTeacherFromCourse(teacherId, courseId);
    }

    public static void connectTeacherToCourse() {
        System.out.println("ID of teacher:");
        int teacherId = sc.nextInt();
        sc.nextLine();
        System.out.println("ID of course:");
        int courseId = sc.nextInt();
        sc.nextLine();
        genericDao.connectTeacherToCourse(teacherId, courseId);
    }

    public static void showAllStudentsInEducation() {
        System.out.println("ID of education:");
        int eduId = sc.nextInt();
        sc.nextLine();
        genericDao.showAllStudentsInEducation(eduId);
    }

    public static void disconnectStudentFromEducation() {
//        genericDao.disconnectStudentFromEducation();
    }

    public static void connectStudentToEducation() {
//        genericDao.connectStudentToEducation();
    }

    public static void disconnectCourseFromEducation() {
//        genericDao.disconnectCourseFromEducation();
    }

    public static void showAllCoursesInEducation() {
//        genericDao.showAllCoursesInEducation();
    }

    public static void connectCourseToEducation() {
//        genericDao.connectCourseToEducation();
    }


    
}
