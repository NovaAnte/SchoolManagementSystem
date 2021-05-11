package dao;

import static schoolmanagementsystem.SchoolManagementSystem.sc;

public class GenericFunctions {
    static GenericDao genericDao = new GenericDao();
    public static void showStatistics() {
        genericDao.showStatistics();
    }

    public static void showAllTeachersInCourse() {
        System.out.print("Course ID:");
        int id = sc.nextInt();
        sc.nextLine();
        genericDao.showAllTeachersInCourse(id);
    }

    public static void disconnectTeacherFromCourse() {
        System.out.print("Teacher ID:");
        int teacherId = sc.nextInt();
        sc.nextLine();
        System.out.print("Course ID:");
        int courseId = sc.nextInt();
        sc.nextLine();
        genericDao.disconnectTeacherFromCourse(teacherId, courseId);
    }

    public static void connectTeacherToCourse() {
        System.out.print("Teacher ID:");
        int teacherId = sc.nextInt();
        sc.nextLine();
        System.out.print("Course ID:");
        int courseId = sc.nextInt();
        sc.nextLine();
        genericDao.connectTeacherToCourse(teacherId, courseId);
    }

    public static void showAllStudentsInEducation() {
        System.out.print("Education ID:");
        int eduId = sc.nextInt();
        sc.nextLine();
        genericDao.showAllStudentsInEducation(eduId);
    }

    public static void disconnectStudentFromEducation() {
        System.out.print("Student ID:");
        int stuId = sc.nextInt();
        sc.nextLine();
        genericDao.disconnectStudentFromEducation(stuId);
    }

    public static void connectStudentToEducation() {
        System.out.print("Student ID:");
        int stuId = sc.nextInt();
        sc.nextLine();
        System.out.print("Education ID:");
        int eduId = sc.nextInt();
        sc.nextLine();
        genericDao.connectStudentToEducation(stuId, eduId);
    }

    public static void disconnectCourseFromEducation() {
        System.out.print("Course ID:");
        int courseId = sc.nextInt();
        sc.nextLine();
        System.out.print("Education ID:");
        int eduId = sc.nextInt();
        sc.nextLine();
        genericDao.disconnectCourseFromEducation(courseId, eduId);
    }

    public static void showAllCoursesInEducation() {
        System.out.print("Education ID:");
        int eduId = sc.nextInt();
        sc.nextLine();
        genericDao.showAllCoursesInEducation(eduId);
    }

    public static void connectCourseToEducation() {
        System.out.print("Course ID:");
        int courseId = sc.nextInt();
        sc.nextLine();
        System.out.print("Education ID:");
        int eduId = sc.nextInt();
        sc.nextLine();
        genericDao.connectCourseToEducation(courseId, eduId);
    }


    
}
