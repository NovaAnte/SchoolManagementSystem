package schoolmanagementsystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HelpFunctions {

    static Scanner sc = new Scanner(System.in);

    public static String inputGender() {
        Boolean loop = true;
        String gender = "Unknown";
        while (loop) {
            System.out.println("1. Female");
            System.out.println("2. Male");
            System.out.println("3. Unknown");
            int genderChoice = readInt();
            switch (genderChoice) {
                case 1:
                    gender = "Female";
                    loop = false;
                    break;
                case 2:
                    gender = "Male";
                    loop = false;
                    break;
                case 3:
                    gender = "Unknown";
                    loop = false;
                    break;
                default:
                    System.out.println("Wrong input, try again.");
            }
        }
        return gender;
    }

    public static int readInt() {
        boolean runAgain = true;
        int input = -1;
        while (runAgain) {
            try {
                input = sc.nextInt();
                sc.nextLine();
                runAgain = false;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Wrong input. Only numbers are allowed.");
                System.out.print("Try again: ");
            }
        }
        return input;
    }
}
