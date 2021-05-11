package dao;
import java.util.InputMismatchException;
import static schoolmanagementsystem.SchoolManagementSystem.sc;

public class TeacherFunctions {
    static TeacherDao teacherDao = new TeacherDao();
    public static void removeTeacher() {
//        teacherDao.removeTeacher();
    }

    public static void showAllTeachers() {
        teacherDao.showAllTeachers();
    }

    public static void showTeacher() {
        
        System.out.println("ID:");
        int id = sc.nextInt();
        sc.nextLine();
        
        teacherDao.showTeacher(id);
    }

    public static void updateTeacher() {
        
        System.out.println("ID:");
        int id = sc.nextInt();
        sc.nextLine();
        teacherDao.showTeacher(id);
        
        System.out.println("Press enter to leave field unchanged.");
        System.out.println("Name:");
        String name = sc.nextLine();
        System.out.println("Press enter to leave field unchanged.");
        System.out.println("Gender:");
        String gender = sc.nextLine();
        System.out.println("Press enter to leave field unchanged.");
        System.out.println("Salary:");
        double salary = sc.nextDouble();
        sc.nextLine();
        System.out.println("Press '0' (zero) to leave field unchanged.");
        System.out.println("Age:");
        int age = getInt(); // Calling getInt() to verify integer...
        sc.nextLine();
        System.out.println("Press enter to leave field unchanged.");
        System.out.println("Email:");
        String email = sc.nextLine();
        
        teacherDao.updateTeacher(id, name, gender, salary, age, email);
    }

    public static void addTeacher() {
        
        System.out.println("Name:");
        String name = sc.nextLine();
        System.out.println("Gender:");
        String gender = sc.nextLine();
        System.out.println("Salary:");
        double salary = sc.nextDouble();
        sc.nextLine();
        System.out.println("Age:");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Email:");
        String email = sc.nextLine();
    
        
        teacherDao.addTeacher(name, gender, salary, age, email);
    }
    
    
    private static int getInt() {
        
        boolean loop = true;
        int value = 0;
        
        while(loop) {
            
            try {
                
                value = sc.nextInt();
                sc.nextLine();
                loop = false;
                
            }
            catch(InputMismatchException e) {
                
                System.out.println("Only integers!");
                sc.nextLine();  
            } 
        }
        
        return value;
    }
}
