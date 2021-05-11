package dao;

import static schoolmanagementsystem.SchoolManagementSystem.sc;

public class EducationFunctions {

    static EducationDao educationDao = new EducationDao();

    public static void addEducation() {
        System.out.println("Name:");
        String name = sc.nextLine();
      
        educationDao.addEducation(name);
    }

    public static void removeEducation() {
        int id = sc.nextInt();
        sc.nextLine();

        educationDao.removeEducation(id);
    }

    public static void showAllEducations() {
        educationDao.showAllEducations();
    }

    public static void showEducationInfo() {
        System.out.println("ID:");
        int id = sc.nextInt();
        sc.nextLine();
        educationDao.showEducationInfo(id);
    }

    public static void updateEducation() {
        System.out.println("ID:");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Press enter to leave field unchanged!");
        System.out.println("Name:");
        String newName = sc.nextLine();

        educationDao.updateEducation(id, newName);
    }

}
