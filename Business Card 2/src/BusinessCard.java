import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * A program that makes a business card for the user.
 *
 * <p>Purdue University -- CS18000 -- Spring 2019 -- Homework 1</p>
 * @author Mark Jin
 * @version June 17, 2019
 */

public class BusinessCard {

    /**
     * Prompts the user for his name, age, gpa, major, and email,
     * then displays the input in a business card-like format.
     *
     * @param args the command line arguments
     */


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter your Name: ");
        String name = scanner.nextLine();

        System.out.printf("Enter your Year of Birth: ");
        String birthYear = scanner.nextLine();
        int birthYearInt = Integer.parseInt(birthYear);
        int age = 2019 - birthYearInt;

        System.out.printf("Enter your GPA: ");
        String gpa = scanner.nextLine();
        double gpaDouble = Double.parseDouble(gpa);
        DecimalFormat gpaFormat = new DecimalFormat("0.00");


        System.out.printf("Enter your Major: ");
        String major = scanner.nextLine();

        System.out.printf("Enter your Email: ");
        String email = scanner.nextLine();

        System.out.println("Name:  " + name);
        System.out.println("Age:   " + age);
        System.out.println("GPA:   " + gpaFormat.format(gpaDouble));
        System.out.println("Major: " + major);
        System.out.println("Email: " + email);
    }
}
