import java.text.DecimalFormat;
import java.util.Scanner;
/**
 * A program that makes a business card for the user.
 *
 * <p>Purdue University -- CS18000 -- Spring 2019 -- Homework 1</p>
 * @author Mark Jin
 * @version January 14, 2019
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

        String name;
        System.out.print("Enter your name: ");
        name = scanner.nextLine();

        String age;
        System.out.print("Enter your age: ");
        age = scanner.nextLine();
        int ageInt = Integer.parseInt(age);

        String gpa;
        System.out.print("Enter your GPA: ");
        gpa = scanner.nextLine();
        double gpaDouble = Double.parseDouble(gpa);
        DecimalFormat gpaFormat = new DecimalFormat("#.00");

        String major;
        System.out.print("Enter your major: ");
        major = scanner.nextLine();

        String email;
        System.out.print("Enter your email: ");
        email = scanner.nextLine();

        System.out.println();
        System.out.println("Name:  " + name);
        System.out.println("Age:   " + ageInt);
        System.out.println("GPA:   " + gpaFormat.format(gpaDouble));
        System.out.println("Major: " + major);
        System.out.println("Email: " + email);
    }
}
