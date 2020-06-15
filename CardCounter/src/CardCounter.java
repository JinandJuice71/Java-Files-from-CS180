import java.util.Scanner;

/**
 * A program that generates usernames.
 *
 * <p>Purdue University -- CS18000 -- Spring 2019 -- Homework 4</p>
 * @author Mark Jin
 * @version February 6, 2019
 */

public class CardCounter {

    /**
     * Program that counts cards
     *
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalCount = 0;

        System.out.println("Welcome to the Card Counter Program!\n");

        String contQuestion = "Y";
        for (; contQuestion.compareTo("Y") == 0;) {
            int yourCount = 0;
            int dealerCount = 0;

            System.out.println("Enter Your Hand:");
            String yourHand = scanner.nextLine();
            //System.out.println("DEBUG: yourHand = " + yourHand);

            yourHand = yourHand.replace("0","");
            //System.out.println("DEBUG: your hand with 0 removed: " + yourHand);
            yourHand = yourHand.replace(",","");
            //System.out.println("DEBUG: your hand with comma removed: " + yourHand);

            int yourHandLength = yourHand.length();
            for (int i = 0; i < yourHandLength; i++) {
                //System.out.println(i);

                switch (yourHand.charAt(i))
                {
                    case '2': yourCount++;
                        //System.out.println("DEBUG: i: " + i);
                        //System.out.println("DEBUG: card is 2: yourCount: " + yourCount);
                        break;
                    case '3': yourCount++;
                        //System.out.println("DEBUG: card is 3: yourCount: " + yourCount);
                        break;
                    case '4': yourCount++;
                        //System.out.println("DEBUG: card is 4: yourCount: " + yourCount);
                        break;
                    case '5': yourCount++;
                        //System.out.println("DEBUG: card is 5: yourCount: " + yourCount);
                        break;
                    case '6': yourCount++;
                        //System.out.println("DEBUG: card is 6: yourCount: " + yourCount);
                        break;
                    case '7':
                        //System.out.println("DEBUG: card is 7: yourCount: " + yourCount);
                        break;
                    case '8':
                        //System.out.println("DEBUG: card is 8: yourCount: " + yourCount);
                        break;
                    case '9':
                        //System.out.println("DEBUG: card is 9: yourCount: " + yourCount);
                        break;
                    case '1': yourCount--;
                        //System.out.println("DEBUG: i: " + i);
                        //System.out.println("DEBUG: card is 10: yourCount: " + yourCount);
                        break;
                    case 'J': yourCount--;
                        //System.out.println("DEBUG: card is J: yourCount: " + yourCount);
                        break;
                    case 'Q': yourCount--;
                        //System.out.println("DEBUG: card is Q: yourCount: " + yourCount);
                        break;
                    case 'K': yourCount--;
                        //System.out.println("DEBUG: card is K: yourCount: " + yourCount);
                        break;
                    case 'A': yourCount--;
                        //System.out.println("DEBUG: card is A: yourCount: " + yourCount);
                        break;

                    default:
                        System.out.println("BUG: Input the proper cards!");
                        break;
                }
            }

            System.out.println("Enter Dealers Hand:");
            String dealerHand = scanner.nextLine();

            dealerHand = dealerHand.replace("0","");
            //System.out.println("DEBUG: dealer hand with 0 removed: " + dealerHand);
            dealerHand = dealerHand.replace(",","");
            //System.out.println("DEBUG: dealer hand with comma removed: " + dealerHand);

            int dealerHandLength = dealerHand.length();
            for (int i = 0; i < dealerHandLength; i++) {
                //System.out.println(i);

                switch (dealerHand.charAt(i))
                {
                    case '2': dealerCount++;
                        //System.out.println("DEBUG: i: " + i);
                        //System.out.println("DEBUG: card is 2: yourCount: " + yourCount);
                        break;
                    case '3': dealerCount++;
                        //System.out.println("DEBUG: card is 3: yourCount: " + yourCount);
                        break;
                    case '4': dealerCount++;
                        //System.out.println("DEBUG: card is 4: yourCount: " + yourCount);
                        break;
                    case '5': dealerCount++;
                        //System.out.println("DEBUG: card is 5: yourCount: " + yourCount);
                        break;
                    case '6': dealerCount++;
                        //System.out.println("DEBUG: card is 6: yourCount: " + yourCount);
                        break;
                    case '7':
                        //System.out.println("DEBUG: card is 7: yourCount: " + yourCount);
                        break;
                    case '8':
                        //System.out.println("DEBUG: card is 8: yourCount: " + yourCount);
                        break;
                    case '9':
                        //System.out.println("DEBUG: card is 9: yourCount: " + yourCount);
                        break;
                    case '1': dealerCount--;
                        //System.out.println("DEBUG: i: " + i);
                        //System.out.println("DEBUG: card is 10: yourCount: " + yourCount);
                        break;
                    case 'J': dealerCount--;
                        //System.out.println("DEBUG: card is J: yourCount: " + yourCount);
                        break;
                    case 'Q': dealerCount--;
                        //System.out.println("DEBUG: card is Q: yourCount: " + yourCount);
                        break;
                    case 'K': dealerCount--;
                        //System.out.println("DEBUG: card is K: yourCount: " + yourCount);
                        break;
                    case 'A': dealerCount--;
                        //System.out.println("DEBUG: card is A: yourCount: " + yourCount);
                        break;

                    default:
                        System.out.println("BUG: Input the proper cards!");
                        break;
                }
            }

            totalCount = totalCount + yourCount + dealerCount;
            System.out.println("Running Count = " + totalCount + "\n");

            System.out.println("Continue? (Y/N):");
            contQuestion = scanner.nextLine();
        }

    }
}