package dao;

import static schoolmanagementsystem.HelpFunctions.readInt;
import static schoolmanagementsystem.SchoolManagementSystem.sc;

public class EducationFunctions {

    static EducationDao educationDao = new EducationDao();

    public static void addEducation() {
        System.out.print("Name:");
        String name = sc.nextLine();

        educationDao.addEducation(name);
    }

    public static void removeEducation() {
        System.out.print("ID:");
        int id = readInt();

        educationDao.removeEducation(id);
    }

    public static void showAllEducations() {
        educationDao.showAllEducations();
    }

    public static void showEducationInfo() {
        System.out.print("ID:");
        int id = readInt();

        educationDao.showEducationInfo(id);
    }

    public static void updateEducation() {
        System.out.print("ID:");
        int id = readInt();
        boolean idExist = educationDao.showEducationInfo(id);
        if (idExist){
        System.out.println("Press enter to leave field unchanged!");
        System.out.print("Name:");
        String newName = sc.nextLine();

        educationDao.updateEducation(id, newName);
        }
    }

}
