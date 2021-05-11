package dao;

import static schoolmanagementsystem.HelpFunctions.inputGender;
import static schoolmanagementsystem.HelpFunctions.readInt;
import static schoolmanagementsystem.SchoolManagementSystem.sc;

public class StudentFunctions {

    static StudentDao studentDao = new StudentDao();

    public static void removeStudent() {
        System.out.println("ID:");
        int id = readInt();
        studentDao.removeStudent(id);
    }

    public static void showAllStudents() {
        studentDao.showAllStudents();
    }

    public static void showStudent() {
        System.out.println("ID:");
        int id = readInt();
        studentDao.showStudent(id);
    }

    public static void updateStudent() {
        System.out.println("ID:");
        int id = readInt();
        studentDao.showStudent(id);
        System.out.println("Press enter to leave field unchanged!");
        System.out.println("New student name:");
        String newName = sc.nextLine();
        System.out.println("Press enter to leave field unchanged!");
        System.out.println("New student gender: ");
        String newGender = inputGender();
        System.out.println("Press enter to leave field unchanged!");
        System.out.println("New student age:");
        int newAge = readInt();
        System.out.println("Press enter to leave field unchanged!");
        System.out.println("New student e-mail:");
        String newEmail = sc.nextLine();
        studentDao.updateStudent(id, newName, newGender, newAge, newEmail);
    }

    public static void addStudent() {
        System.out.println("Name:");
        String name = sc.nextLine();
        System.out.println("Gender: ");
        String gender = inputGender();
        System.out.println("Age:");
        int age = readInt();
        System.out.println("E-mail:");
        String email = sc.nextLine();
        studentDao.addStudent(name, gender, age, email);
    }

}
