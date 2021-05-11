package dao;
import static schoolmanagementsystem.HelpFunctions.inputGender;
import static schoolmanagementsystem.HelpFunctions.readDouble;
import static schoolmanagementsystem.HelpFunctions.readInt;
import static schoolmanagementsystem.SchoolManagementSystem.sc;

public class TeacherFunctions {
    static TeacherDao teacherDao = new TeacherDao();
    
    
    public static void removeTeacher() {
        
        System.out.println("ID:");
        int id = readInt();
        
        teacherDao.removeTeacher(id);
    }

    public static void showAllTeachers() {
        teacherDao.showAllTeachers();
    }

    public static void showTeacher() {
        
        System.out.println("ID:");
        int id = readInt();
        
        teacherDao.showTeacher(id);
    }

    public static void updateTeacher() {
        
        System.out.println("ID:");
        int id = readInt();
        teacherDao.showTeacher(id);
        
        System.out.println("Press enter to leave field unchanged.");
        System.out.println("Name:");
        String name = sc.nextLine();
        System.out.println("Press enter to leave field unchanged.");
        System.out.println("Gender:");
        String gender = inputGender();
        System.out.println("Press enter to leave field unchanged.");
        System.out.println("Salary:");
        double salary = readDouble();
        System.out.println("Press enter to leave field unchanged.");
        System.out.println("Age:");
        int age = readInt(); // Calling getInt() to verify integer...
        System.out.println("Press enter to leave field unchanged.");
        System.out.println("Email:");
        String email = sc.nextLine();
        
        teacherDao.updateTeacher(id, name, gender, salary, age, email);
    }

    public static void addTeacher() {
        
        System.out.println("Name:");
        String name = sc.nextLine();
        System.out.println("Gender:");
        String gender = inputGender();
        System.out.println("Salary:");
        double salary = readDouble();
        System.out.println("Age:");
        int age = readInt();
        System.out.println("Email:");
        String email = sc.nextLine();
        
        teacherDao.addTeacher(name, gender, salary, age, email);
    }
    
    

}
