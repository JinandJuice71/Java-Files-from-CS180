import javax.swing.*;
import java.text.DecimalFormat;

/**
 * A GUI that lets people buy movie tickets.
 *
 * <p>Purdue University -- CS18000 -- Spring 2019 -- External Communication -- Homework</p>
 *
 * @author Mark Jin
 * @version 04/04/2019
 */

public class MovieTheaterGUI {
    private static DecimalFormat df2 = new DecimalFormat("0.00");

    public static void main(String[] args) {
        int childTicket = 0;
        int studentTicket = 0;
        int adultTicket = 0;
        int seniorTicket = 0;

        JFrame welcome = new JFrame("Welcome Screen");
        JOptionPane.showMessageDialog(welcome, "Welcome to CS180 Movie Theater");

//TASK 2
        String[] choices = { "Action", "Comedy", "Romance", "Documentary"};
        String choicesInput = (String) JOptionPane.showInputDialog(null,
                "Choose the movie type:",
                "CS180 Movie Theater", JOptionPane.INFORMATION_MESSAGE, null,
                choices, // Array of choices
                choices[0]); // Initial choice
        //System.out.println(choicesInput);
        if (choicesInput == null) {
            return;
        }

        String[] rating = { "PG-13", "R"};
        String ratingInput = (String) JOptionPane.showInputDialog(null,
                "Choose the movie rating:",
                "CS180 Movie Theater", JOptionPane.INFORMATION_MESSAGE, null,
                rating, // Array of choices
                rating[0]); // Initial choice
        if (ratingInput == null) {
            return;
        }


        boolean backToMainMenu = false;
        do {
            backToMainMenu = false;
//TASK 4
            Object[] ticketWhatDo = {"Add new Ticket", "Check Order", "Close Order"};
            int n = JOptionPane.showOptionDialog(null,
                    "What do you want to do?",
                    "CS180 Movie Theater",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    ticketWhatDo,
                    ticketWhatDo[0]);

            //System.out.println("The users wants to: " + ticketWhatDo[n]);

//TASK 5
            if (ticketWhatDo[n].equals("Add new Ticket")) {
                String[] ticketType = {"Child", "Student", "Adult", "Senior"};
                String ticketInput = (String) JOptionPane.showInputDialog(null,
                        "Choose the ticket type:",
                        "CS180 Movie Theater",
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        ticketType, // Array of choices
                        ticketType[0]); // Initial choice
                //System.out.println(ticketInput);

                if (ticketInput.equals("Child") && ratingInput.equals("R")) {
                    final JPanel tooYoung = new JPanel();
                    JOptionPane.showMessageDialog(tooYoung,
                            "Children can't go to R-Rated movies!",
                            "CS180 Movie Theater",
                            JOptionPane.ERROR_MESSAGE);

                    //welcome main menu
                    backToMainMenu = true;

                } else {
                    switch (ticketInput) {
                        case "Child": childTicket++;
                            break;
                        case "Student": studentTicket++;
                            break;
                        case "Adult": adultTicket++;
                            break;
                        case "Senior": seniorTicket++;
                            break;
                        default:
                            System.out.println("DEBUG: INVALID CHOICE, SHOULD NOT SEE THIS");
                    }
                    backToMainMenu = true;
                }

                //TASK 6
            } else if (ticketWhatDo[n].equals("Check Order")) {

                String msg = "Current Order: " + choicesInput + " (" + ratingInput + ")" + "\n"
                        + "Children (x" + childTicket + ") : $" + df2.format(6.25 * childTicket) + "\n"
                        + "Students (x" + studentTicket + ") : $" + df2.format(8.00 * studentTicket) + "\n"
                        + "Adults (x" + adultTicket + ") : $" + df2.format(9.50 * adultTicket) + "\n"
                        + "Seniors (x" + adultTicket + ") : $" + df2.format(7.75 * seniorTicket) + "\n"
                        + "\n"
                        + "Price: $" + df2.format(6.25 * childTicket + 8.00
                        * studentTicket + 9.50 * adultTicket + 7.75 * seniorTicket) + "\n"
                        + "Tax: $" + df2.format((6.25 * childTicket + 8.00
                        * studentTicket + 9.50 * adultTicket + 7.75 * seniorTicket) * 0.07) + "\n"
                        + "Total: $" + df2.format((6.25 * childTicket + 8.00
                        * studentTicket + 9.50 * adultTicket + 7.75 * seniorTicket
                        + (6.25 * childTicket + 8.00 * studentTicket + 9.50
                        * adultTicket + 7.75 * seniorTicket) * 0.07));

                JOptionPane optionPane = new JOptionPane();
                optionPane.setMessage(msg);
                optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                JDialog dialog = optionPane.createDialog(null, "CS180 Movie Theater");
                dialog.setVisible(true);
                backToMainMenu = true;

            } else if (ticketWhatDo[n].equals("Close Order")
                    && childTicket == 0
                    && studentTicket == 0
                    && adultTicket == 0
                    && seniorTicket == 0) {

                //TASK 7
                Object[] noTickets = {"Yes", "No"};
                int m = JOptionPane.showOptionDialog(null,
                        "You haven't added any tickets to your order! Are you sure you want to quit?",
                        "CS180 Movie Theater",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,
                        noTickets,
                        noTickets[0]);

                if (noTickets[m].equals("No")) {
                    backToMainMenu = true;
                }
            }
        } while (backToMainMenu == true);

        Object[] deliveryMethod = {"Email ($5.00)", "Retrieve at Theater (Free)"};
        int o = JOptionPane.showOptionDialog(null,
                "How will you be getting your tickets?",
                "CS180 Movie Theater",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                deliveryMethod,
                deliveryMethod[0]);

        double emailFee = 0;
        if (deliveryMethod[o].equals("Email ($5.00)")) {
            emailFee = 5;
        }

        String finalMsg = choicesInput + " (" + ratingInput + ")" + "\n"
                + "\n"
                + "Children (x" + childTicket + ") : $" + df2.format(6.25 * childTicket) + "\n"
                + "Students (x" + studentTicket + ") : $" + df2.format(8.00 * studentTicket) + "\n"
                + "Adults (x" + adultTicket + ") : $" + df2.format(9.50 * adultTicket) + "\n"
                + "Seniors (x" + adultTicket + ") : $" + df2.format(7.75 * seniorTicket) + "\n"
                + "\n"
                + "Convenience Fee: $" + df2.format(emailFee) + "\n"
                + "Price: $" + df2.format(6.25 * childTicket + 8.00
                * studentTicket + 9.50 * adultTicket + 7.75 * seniorTicket) + "\n"
                + "Tax: $" + df2.format((6.25 * childTicket + 8.00
                * studentTicket + 9.50 * adultTicket + 7.75 * seniorTicket + emailFee) * 0.07) + "\n"
                + "Total: $" + df2.format((6.25 * childTicket + 8.00
                * studentTicket + 9.50 * adultTicket + 7.75 * seniorTicket + emailFee
                + (6.25 * childTicket + 8.00 * studentTicket +
                9.50 * adultTicket + 7.75 * seniorTicket + emailFee) * 0.07));

        JOptionPane optionPane = new JOptionPane();
        optionPane.setMessage(finalMsg);
        optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = optionPane.createDialog(null, "CS180 Movie Theater");
        dialog.setVisible(true);
    }
}
