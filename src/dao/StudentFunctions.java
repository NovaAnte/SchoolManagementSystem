package dao;

import static schoolmanagementsystem.HelpFunctions.inputGender;
import static schoolmanagementsystem.HelpFunctions.readInt;
import static schoolmanagementsystem.SchoolManagementSystem.sc;

public class StudentFunctions {

    static StudentDao studentDao = new StudentDao();

    public static void removeStudent() {
        System.out.print("ID:");
        int id = readInt();
        studentDao.removeStudent(id);
    }

    public static void showAllStudents() {
        studentDao.showAllStudents();
    }

    public static void showStudent() {
        System.out.print("ID:");
        int id = readInt();
        studentDao.showStudent(id);
    }

    public static void updateStudent() {
        System.out.print("ID:");
        int id = readInt();
        boolean idExist = studentDao.showStudent(id);
        if (idExist){
        System.out.println("Press enter to leave field unchanged!");
        System.out.print("New student name:");
        String newName = sc.nextLine();
        System.out.println("Press enter to leave field unchanged!");
        System.out.print("New student gender: ");
        String newGender = inputGender();
        System.out.println("Press enter to leave field unchanged!");
        System.out.print("New student age:");
        int newAge = readInt();
        System.out.println("Press enter to leave field unchanged!");
        System.out.print("New student e-mail:");
        String newEmail = sc.nextLine();
        studentDao.updateStudent(id, newName, newGender, newAge, newEmail);
        }
    }

    public static void addStudent() {
        System.out.print("Name:");
        String name = sc.nextLine();
        System.out.print("Gender: ");
        String gender = inputGender();
        System.out.print("Age:");
        int age = readInt();
        System.out.print("E-mail:");
        String email = sc.nextLine();
        studentDao.addStudent(name, gender, age, email);
    }

}
