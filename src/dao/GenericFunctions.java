package dao;

import static schoolmanagementsystem.HelpFunctions.readInt;

public class GenericFunctions {
    static GenericDao genericDao = new GenericDao();
    public static void showStatistics() {
        genericDao.showStatistics();
    }

    public static void showAllTeachersInCourse() {
        System.out.print("Course ID:");
        int id = readInt();
        genericDao.showAllTeachersInCourse(id);
    }

    public static void disconnectTeacherFromCourse() {
        System.out.print("Teacher ID:");
        int teacherId = readInt();
        System.out.print("Course ID:");
        int courseId = readInt();
        genericDao.disconnectTeacherFromCourse(teacherId, courseId);
    }

    public static void connectTeacherToCourse() {
        System.out.print("Teacher ID:");
        int teacherId = readInt();
        System.out.print("Course ID:");
        int courseId = readInt();
        genericDao.connectTeacherToCourse(teacherId, courseId);
    }

    public static void showAllStudentsInEducation() {
        System.out.print("Education ID:");
        int eduId = readInt();
        genericDao.showAllStudentsInEducation(eduId);
    }

    public static void disconnectStudentFromEducation() {
        System.out.print("Student ID:");
        int stuId = readInt();
        genericDao.disconnectStudentFromEducation(stuId);
    }

    public static void connectStudentToEducation() {
        System.out.print("Student ID:");
        int stuId = readInt();
        System.out.print("Education ID:");
        int eduId = readInt();
        genericDao.connectStudentToEducation(stuId, eduId);
    }

    public static void disconnectCourseFromEducation() {
        System.out.print("Course ID:");
        int courseId = readInt();
        System.out.print("Education ID:");
        int eduId = readInt();
        genericDao.disconnectCourseFromEducation(courseId, eduId);
    }

    public static void showAllCoursesInEducation() {
        System.out.print("Education ID:");
        int eduId = readInt();
        genericDao.showAllCoursesInEducation(eduId);
    }

    public static void connectCourseToEducation() {
        System.out.print("Course ID:");
        int courseId = readInt();
        System.out.print("Education ID:");
        int eduId = readInt();
        genericDao.connectCourseToEducation(courseId, eduId);
    }


    
}
