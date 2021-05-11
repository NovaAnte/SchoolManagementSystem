package dao;

import static schoolmanagementsystem.HelpFunctions.readInt;
import static schoolmanagementsystem.SchoolManagementSystem.sc;

public class EducationFunctions {

    static EducationDao educationDao = new EducationDao();

    public static void addEducation() {
        System.out.println("Name:");
        String name = sc.nextLine();

        educationDao.addEducation(name);
    }

    public static void removeEducation() {
        System.out.println("ID:");
        int id = readInt();

        educationDao.removeEducation(id);
    }

    public static void showAllEducations() {
        educationDao.showAllEducations();
    }

    public static void showEducationInfo() {
        System.out.println("ID:");
        int id = readInt();

        educationDao.showEducationInfo(id);
    }

    public static void updateEducation() {
        System.out.println("ID:");
        int id = readInt();

        System.out.println("Press enter to leave field unchanged!");
        System.out.println("Name:");
        String newName = sc.nextLine();

        educationDao.updateEducation(id, newName);
    }

}
