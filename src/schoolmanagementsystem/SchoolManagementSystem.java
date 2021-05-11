package schoolmanagementsystem;

import dao.CourseFunctions;
import dao.EducationFunctions;
import dao.GenericFunctions;
import dao.StudentFunctions;
import dao.TeacherFunctions;
import java.util.Scanner;
import static schoolmanagementsystem.HelpFunctions.readInt;

public class SchoolManagementSystem {

    public static Scanner sc = new Scanner(System.in);
    static boolean loop = true;

    public static void main(String[] args) {
        while (loop) {
            menu();
        }

    }

    public static void menu() {
        System.out.println("===== School Management System =====");
        System.out.println("1. Education management");
        System.out.println("2. Course management");
        System.out.println("3. Student management");
        System.out.println("4. Teacher management");
        System.out.println("5. Connections management");
        System.out.println("6. Show statistics");
        System.out.println("0. Exit");

        int menuChoice = readInt();
        switchMenu(menuChoice);
    }

    public static void switchMenu(int choice) {

        switch (choice) {
            case 1:
                educationMenu();
                break;
            case 2:
                courseMenu();
                break;
            case 3:
                studentMenu();
                break;

            case 4:
                teacherMenu();
                break;

            case 5:
                connectionsMenu();
                break;

            case 6:
                GenericFunctions.showStatistics();
                break;

            case 0:
                loop = false;
                break;

            default:
                System.out.println("Invalid choice");

        }

    }

    public static void educationMenu() {
        boolean menuLoop = true;

        while (menuLoop) {
            System.out.println("===== Education =====");

            System.out.println("1. Add education");
            System.out.println("2. Update education information");
            System.out.println("3. Show information about education");
            System.out.println("4. Show all educations");
            System.out.println("5. Remove education");
            System.out.println("0. Main menu");
            int menuChoice = readInt();
            switch (menuChoice) {

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

                case 0:
                    menuLoop = false;
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }

    }

    private static void courseMenu() {
        boolean menuLoop = true;

        while (menuLoop) {
            System.out.println("===== Course =====");

            System.out.println("1. Add course");
            System.out.println("2. Update course information");
            System.out.println("3. Show information about a course");
            System.out.println("4. Show all courses");
            System.out.println("5. Remove course");
            System.out.println("0. Main menu");

            int menuChoice = readInt();

            switch (menuChoice) {
                case 1:
                    CourseFunctions.addCourse();
                    break;

                case 2:
                    CourseFunctions.updateCourse();
                    break;

                case 3:
                    CourseFunctions.showCourseInfo();
                    break;

                case 4:
                    CourseFunctions.showAllCourses();
                    break;

                case 5:
                    CourseFunctions.removeCourse();
                    break;
                case 0:
                    menuLoop = false;
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void studentMenu() {
        boolean menuLoop = true;

        while (menuLoop) {
            System.out.println("===== Student =====");

            System.out.println("1. Add student");
            System.out.println("2. Update student information");
            System.out.println("3. Show information about a student");
            System.out.println("4. Show all students");
            System.out.println("5. Remove student");
            System.out.println("0. Main menu");

            int menuChoice = readInt();

            switch (menuChoice) {
                case 1:
                    StudentFunctions.addStudent();
                    break;

                case 2:
                    StudentFunctions.updateStudent();
                    break;

                case 3:
                    StudentFunctions.showStudent();
                    break;

                case 4:
                    StudentFunctions.showAllStudents();
                    break;

                case 5:
                    StudentFunctions.removeStudent();
                    break;

                case 0:
                    menuLoop = false;
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void teacherMenu() {
        boolean menuLoop = true;

        while (menuLoop) {
            System.out.println("===== Teacher =====");

            System.out.println("1. Add teacher");
            System.out.println("2. Update teacher information");
            System.out.println("3. Show information about a teacher");
            System.out.println("4. Show all teachers");
            System.out.println("5. Remove teacher");
            System.out.println("0. Main menu");

            int menuChoice = readInt();

            switch (menuChoice) {
                case 1:
                    TeacherFunctions.addTeacher();
                    break;

                case 2:
                    TeacherFunctions.updateTeacher();
                    break;

                case 3:
                    TeacherFunctions.showTeacher();
                    break;

                case 4:
                    TeacherFunctions.showAllTeachers();
                    break;

                case 5:
                    TeacherFunctions.removeTeacher();
                    break;

                case 0:
                    menuLoop = false;
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void connectionsMenu() {
        boolean menuLoop = true;

        while (menuLoop) {
            System.out.println("===== Connections =====");

            System.out.println("1. Add course to education");
            System.out.println("2. Show all courses in education");
            System.out.println("3. Remove course from education");
            System.out.println("4. Add student to education");
            System.out.println("5. Remove student from an education");
            System.out.println("6. Show all students in education");
            System.out.println("7. Add teacher to course");
            System.out.println("8. Remove teacher from an course");
            System.out.println("9. Show all teachers in course");
            System.out.println("0. Main menu");

            int menuChoice = readInt();

            switch (menuChoice) {
                case 1:
                    GenericFunctions.connectCourseToEducation();
                    break;

                case 2:
                    GenericFunctions.showAllCoursesInEducation();
                    break;

                case 3:
                    GenericFunctions.disconnectCourseFromEducation();
                    break;

                case 4:
                    GenericFunctions.connectStudentToEducation();
                    break;

                case 5:
                    GenericFunctions.disconnectStudentFromEducation();
                    break;

                case 6:
                    GenericFunctions.showAllStudentsInEducation();
                    break;

                case 7:
                    GenericFunctions.connectTeacherToCourse();
                    break;

                case 8:
                    GenericFunctions.disconnectTeacherFromCourse();
                    break;

                case 9:
                    GenericFunctions.showAllTeachersInCourse();
                    break;

                case 0:
                    menuLoop = false;
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

}
