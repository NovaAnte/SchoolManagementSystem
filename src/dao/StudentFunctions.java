package dao;

import schoolmanagementsystem.HelpFunctions;
import static schoolmanagementsystem.SchoolManagementSystem.sc;

public class StudentFunctions {

    static StudentDao studentDao = new StudentDao();

    public static void removeStudent() {
        System.out.println("ID:");
        int id = sc.nextInt();
        sc.nextLine();
        studentDao.removeStudent(id);
    }

    public static void showAllStudents() {
        studentDao.showAllStudents();
    }

    public static void showStudent() {
        System.out.println("ID:");
        int id = sc.nextInt();
        sc.nextLine();
        studentDao.showStudent(id);
    }

    public static void updateStudent() {
        System.out.println("ID:");
        int id = sc.nextInt();
        sc.nextLine();
        studentDao.showStudent(id);
        System.out.println("New student name:");
        String newName = sc.nextLine();
        System.out.println("New student gender: ");
        String newGender = HelpFunctions.inputGender();
        System.out.println("New student age:");
        int newAge = sc.nextInt();
        sc.nextLine();
        System.out.println("New student e-mail:");
        String newEmail = sc.nextLine();
        studentDao.updateStudent(id, newName, newGender, newAge, newEmail);
    }

    public static void addStudent() {
        System.out.println("Name:");
        String name = sc.nextLine();
        System.out.println("Gender: ");
        String gender = HelpFunctions.inputGender();
        System.out.println("Age:");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("E-mail:");
        String email = sc.nextLine();
        studentDao.addStudent(name, gender, age, email);
    }

}
