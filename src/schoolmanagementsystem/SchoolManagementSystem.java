package schoolmanagementsystem;

import dao.CourseFunctions;
import dao.EducationFunctions;
import dao.GenericFunctions;
import dao.StudentFunctions;
import dao.TeacherFunctions;
import java.util.Scanner;

public class SchoolManagementSystem {

    public static Scanner sc = new Scanner(System.in);
    static boolean loop = true;

    public static void main(String[] args) {
        while (loop) {
            menu();
        }

    }

    public static void menu() {
        System.out.println("1. Add education");
        System.out.println("2. Update education information");
        System.out.println("3. Show information about education");
        System.out.println("4. Show all educations");
        System.out.println("5. Remove education");
        System.out.println("6. Add course");
        System.out.println("7. Update course information");
        System.out.println("8. Show information about a course");
        System.out.println("9. Show all courses");
        System.out.println("10. Remove course");
        System.out.println("11. Add student");
        System.out.println("12. Update student information");
        System.out.println("13. Show information about a student");
        System.out.println("14. Show all students");
        System.out.println("15. Remove student");
        System.out.println("16. Add teacher");
        System.out.println("17. Update teacher information");
        System.out.println("18. Show information about a teacher");
        System.out.println("19. Show all teachers");
        System.out.println("20. Remove teacher");
        System.out.println("21. Add course to education");
        System.out.println("22. Show all courses in education");
        System.out.println("23. Remove course from education");
        System.out.println("24. Add student to education");
        System.out.println("25. Remove student from an education");
        System.out.println("26. Show all students in education");
        System.out.println("27. Add teacher to course");
        System.out.println("28. Remove teacher from an course");
        System.out.println("29. Show all teacher in course");
        System.out.println("30. Show statistics");
        System.out.println("0. Exit");

        int menuChoice = sc.nextInt();
        sc.nextLine();
        switchMenu(menuChoice);
    }

    public static void switchMenu(int choice) {

        switch (choice) {
            case 1:
                EducationFunctions.addEducation();
                break;

            case 2:
                EducationFunctions.updateEducation();
                break;

            case 3:
                EducationFunctions.showEducationInfo();
                break;

            case 4:
                EducationFunctions.showAllEducations();
                break;

            case 5:
                EducationFunctions.removeEducation();
                break;

            case 6:
                CourseFunctions.addCourse();
                break;

            case 7:
                CourseFunctions.updateCourse();
                break;

            case 8:
                CourseFunctions.showCourseInfo();
                break;

            case 9:
                CourseFunctions.showAllCourses();
                break;

            case 10:
                CourseFunctions.removeCourse();
                break;

            case 11:
                StudentFunctions.addStudent();
                break;

            case 12:
                StudentFunctions.updateStudent();
                break;

            case 13:
                StudentFunctions.showStudent();
                break;

            case 14:
                StudentFunctions.showAllStudents();
                break;

            case 15:
                StudentFunctions.removeStudent();
                break;

            case 16:
                TeacherFunctions.addTeacher();
                break;

            case 17:
                TeacherFunctions.updateTeacher();
                break;

            case 18:
                TeacherFunctions.showTeacher();
                break;

            case 19:
                TeacherFunctions.showAllTeachers();
                break;

            case 20:
                TeacherFunctions.removeTeacher();
                break;

            case 21:
                GenericFunctions.connectCourseToEducation();
                break;

            case 22:
                GenericFunctions.showAllCoursesInEducation();
                break;

            case 23:
                GenericFunctions.disconnectCourseFromEducation();
                break;

            case 24:
                GenericFunctions.connectStudentToEducation();
                break;

            case 25:
                GenericFunctions.disconnectStudentFromEducation();
                break;

            case 26:
                GenericFunctions.showAllStudentsInEducation();
                break;

            case 27:
                GenericFunctions.connectTeacherToCourse();
                break;

            case 28:
                GenericFunctions.disconnectTeacherFromCourse();
                break;

            case 29:
                GenericFunctions.showAllTeachersInCourse();
                break;

            case 30:
                GenericFunctions.showStatistics();
                break;

            case 0:
                loop = false;
                break;

            default:
                System.out.println("Invalid choice");

        }

    }

}
