// Any import statement will go here
//import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * A program that compares 2 camera products
 *
 * @author Mark Jin
 * @version January 26, 2019
 */

public class CameraCompare {

    public static void main(String[] args) {
        /**
         * DO NOT REMOVE ANY OF THESE VARIABLES!
         *
         * These should be used by your program to complete the outlined task.
         *
         * You may add variables as you see fit.
         */
        boolean hasWiFi1;
        boolean hasWiFi2;
        boolean isWaterResistant1;
        boolean isWaterResistant2;
        boolean hasGPS1;
        boolean hasGPS2;
        boolean hasZoom1;
        boolean hasZoom2;
        String condition1;
        String condition2;
        double price1;
        double price2;
        int userRating1;
        int userRating2;
        int cameraValue1 = 0;
        int cameraValue2 = 0;
        Scanner scanner = new Scanner(System.in);

        // HINT: Scanner


        /**
         * Part 1 -- Obtaining Camera Details
         */
        System.out.println("Enter attributes of Camera 1:");  // DO NOT REMOVE THIS LINE

        System.out.println("Is it WiFi enabled? (true/false)");
        String hasWiFi1Str = scanner.nextLine();
        //System.out.println("DEBUG: hasWiFi1Str: " + hasWiFi1Str);

        System.out.println("Is it water resistant? (true/false)");
        String isWaterResistant1Str = scanner.nextLine();

        System.out.println("Is it GPS enabled? (true/false)");
        String hasGPS1Str = scanner.nextLine();

        System.out.println("Is the lens able to zoom? (true/false)");
        String hasZoom1Str = scanner.nextLine();


        System.out.println("What is the condition? (New/Refurbished/Used)");
        condition1 = scanner.nextLine();
        //System.out.println("DEBUG: condition1: " + condition1);

        System.out.println("Enter price from $0.00 to $1000.00");
        String price1Str = scanner.nextLine();
        price1 = Double.parseDouble(price1Str);
        price1 = Math.round(price1 * 100.0) / 100.0;
        //System.out.println("DEBUG: price1: " + price1);

        System.out.println("Enter user rating from 0 to 5");
        String userRating1Str = scanner.nextLine();
        userRating1 = Integer.parseInt(userRating1Str);
        //System.out.println("DEBUG: userRating1: " + userRating1);


        /**
         * DO NOT REMOVE THESE LINES
         */
        System.out.println("======================");
        System.out.println("Enter attributes of Camera 2:");

        System.out.println("Is it WiFi enabled? (true/false)");
        String hasWiFi2Str = scanner.nextLine();
        //System.out.println("DEBUG: hasWiFi2Str: " + hasWiFi2Str);

        System.out.println("Is it water resistant? (true/false)");
        String isWaterResistant2Str = scanner.nextLine();

        System.out.println("Is it GPS enabled? (true/false)");
        String hasGPS2Str = scanner.nextLine();

        System.out.println("Is the lens able to zoom? (true/false)");
        String hasZoom2Str = scanner.nextLine();

        System.out.println("What is the condition? (New/Refurbished/Used)");
        condition2 = scanner.nextLine();

        System.out.println("Enter price from $0.00 to $1000.00");
        String price2Str = scanner.nextLine();
        price2 = Double.parseDouble(price2Str);
        price2 = Math.round(price2 * 100.0) / 100.0;
        //System.out.println("DEBUG: price2: " + price2);

        System.out.println("Enter user rating from 0 to 5");
        String userRating2Str = scanner.nextLine();
        userRating2 = Integer.parseInt(userRating2Str);
        //System.out.println("DEBUG: userRating2: " + userRating2);


        /**
         * Part 2 -- Computing Camera Values
         */

        //CAMERA 1 VALUE

        //int cameraValue1 = 0;

        switch (hasWiFi1Str)
        {
            case "true": hasWiFi1 = true;
                cameraValue1 = cameraValue1 + 1;
                //System.out.println("DEBUG: hasWiFi1: true, cameraValue1: " + cameraValue1);
                break;

            case "false": hasWiFi1 = false;
                //System.out.println("DEBUG: hasWiFi1: false, cameraValue1: " + cameraValue1);
                break;

            default:
                System.out.println("BUG: Input 'true' or 'false'!");
                break;
        }

        switch (isWaterResistant1Str)
        {
            case "true": isWaterResistant1 = true;
                cameraValue1 = cameraValue1 + 1;
                //System.out.println("DEBUG: isWaterResistant1: true, cameraValue1: " + cameraValue1);
                break;

            case "false": isWaterResistant1 = false;
                //System.out.println("DEBUG: isWaterResistant1: false, cameraValue1: " + cameraValue1);
                break;

            default:
                System.out.println("BUG: Input 'true' or 'false'!");
                break;
        }

        switch (hasGPS1Str)
        {
            case "true": hasGPS1 = true;
                cameraValue1 = cameraValue1 + 1;
                //System.out.println("DEBUG: hasGPS1: true, cameraValue1: " + cameraValue1);
                break;

            case "false": hasGPS1 = false;
               // System.out.println("DEBUG: hasGPS1: false, cameraValue1: " + cameraValue1);
                break;

            default:
                System.out.println("BUG: Input 'true' or 'false'!");
                break;
        }

        switch (hasZoom1Str)
        {
            case "true": hasZoom1 = true;
                cameraValue1 = cameraValue1 + 1;
                //System.out.println("DEBUG: hasZoom1: true, cameraValue1: " + cameraValue1);
                break;

            case "false": hasGPS1 = false;
                //System.out.println("DEBUG: hasZoom1: false, cameraValue1: " + cameraValue1);
                break;

            default:
                System.out.println("BUG: Input 'true' or 'false'!");
                break;
        }

        switch (condition1)
        {
            case "New":
                cameraValue1 = cameraValue1 + 2;
                //System.out.println("DEBUG: condition1: New, cameraValue1: " + cameraValue1);
                break;

            case "Refurbished":
                cameraValue1 = cameraValue1 + 1;
               // System.out.println("DEBUG: condition1: Refurbished, cameraValue1: " + cameraValue1);
                break;
            case "Used":
                //System.out.println("DEBUG: condition1: Used, cameraValue1: " + cameraValue1);
                break;
            default:
                System.out.println("BUG: Input 'New' or 'Refurbished' or 'old'!");
                break;
        }

        //System.out.println("DEBUG: cameraValue1: " + cameraValue1);


//CAMERA 2 VALUE
        //int cameraValue2 = 0;

        switch (hasWiFi2Str)
        {
            case "true": hasWiFi2 = true;
                cameraValue2 = cameraValue2 + 1;
                //System.out.println("DEBUG: hasWiFi1: true, cameraValue2: " + cameraValue2);
                break;

            case "false": hasWiFi2 = false;
                //System.out.println("DEBUG: hasWiFi1: false, cameraValue2: " + cameraValue2);
                break;
            default:
                System.out.println("BUG: Input 'true' or 'false'!");
                break;
        }

        switch (isWaterResistant2Str)
        {
            case "true": isWaterResistant2 = true;
                cameraValue2 = cameraValue2 + 1;
                //System.out.println("DEBUG: isWaterResistant2: true, cameraValue2: " + cameraValue2);
                break;

            case "false": isWaterResistant2 = false;
                //System.out.println("DEBUG: isWaterResistant2: false, cameraValue2: " + cameraValue2);
                break;
            default:
                System.out.println("BUG: Input 'true' or 'false'!");
                break;
        }

        switch (hasGPS2Str)
        {
            case "true": hasGPS2 = true;
                cameraValue2 = cameraValue2 + 1;
                //System.out.println("DEBUG: hasGPS2: true, cameraValue2: " + cameraValue2);
                break;

            case "false": hasGPS2 = false;
                //System.out.println("DEBUG: hasGPS2: false, cameraValue2: " + cameraValue2);
                break;

            default:
                System.out.println("BUG: Input 'true' or 'false'!");
                break;
        }

        switch (hasZoom2Str)
        {
            case "true": hasZoom2 = true;
                cameraValue2 = cameraValue2 + 1;
                //System.out.println("DEBUG: hasZoom2: true, cameraValue2: " + cameraValue2);
                break;

            case "false": hasZoom2 = false;
               // System.out.println("DEBUG: hasZoom2: false, cameraValue2: " + cameraValue2);
                break;

            default:
                System.out.println("BUG: Input 'true' or 'false'!");
                break;
        }

        switch (condition2)
        {
            case "New":
                cameraValue2 = cameraValue2 + 2;
                //System.out.println("DEBUG: condition2: New, cameraValue2: " + cameraValue2);
                break;

            case "Refurbished":
                cameraValue2 = cameraValue2 + 1;
                //System.out.println("DEBUG: condition2: Refurbished, cameraValue2: " + cameraValue2);
                break;
            case "Used":
               // System.out.println("DEBUG: condition2: Used, cameraValue2: " + cameraValue2);
                break;
            default:
                System.out.println("BUG: Input 'New' or 'Refurbished' or 'old'!");
                break;
        }

        //System.out.println("DEBUG: cameraValue2: " + cameraValue2);


        /**
         * Part 3 -- Camera Comparison
         */

        //double totalValue1 = (double)cameraValue1 + price1 + (double)userRating1;
       // System.out.println("DEBUG: totalValue1: " + totalValue1);

       // double totalValue2 = (double)cameraValue2 + price2 + (double)userRating2;
        //System.out.println("DEBUG: totalValue1: " + totalValue2);

        double ratio1 = price1 / (double)cameraValue1;
        //System.out.println("Ratio1 = " + ratio1);
        double ratio2 = price2 / (double)cameraValue2;
        //System.out.println("Ratio2 = " + ratio2);

        System.out.println("======================");
        System.out.println("Result of Comparison:");

        if (cameraValue1 == cameraValue2 && price1 == price2 && userRating1 == userRating2) {
            System.out.println("Camera 1 and Camera 2 are equal.");
        } else if ((double)userRating1 + price1 == (double)userRating2 + price2) {
            if (cameraValue1 > cameraValue2) {
                System.out.println("Camera 1 is better than Camera 2!");
            } else if (cameraValue2 > cameraValue1) {
                System.out.println("Camera 2 is better than Camera 1!");
            }
        } else if ((double)cameraValue1 +  price1 == (double)cameraValue2 + price2) {
            if (userRating1 > userRating2) {
                System.out.println("Camera 1 is better than Camera 2!");
            } else if (userRating2 > userRating1) {
                System.out.println("Camera 2 is better than Camera 1!");
            }
        } else if ((double)cameraValue1 +  userRating1 == (double)cameraValue2 + userRating2) {
            if (price1 > price2) {
                System.out.println("Camera 2 is better than Camera 1!");
            } else if (price2 > price1) {
                System.out.println("Camera 1 is better than Camera 2!");
            }
        } else if (ratio1 > ratio2) {
            System.out.println("Camera 2 is better than Camera 1!");
        } else if (ratio2 > ratio1) {
            System.out.println("Camera 1 is better than Camera 2!");
        } else if (ratio2 == ratio1) {
            System.out.println("Camera 1 and Camera 2 are equal.");
        }




        /**
         * Part 4 -- Comparison Results
         *
         * DO NOT REMOVE THESE LINES
         */
        //System.out.println("======================");
        //System.out.println("Result of Comparison:");




        // DO NOT USE System.Exit!
    }

}
