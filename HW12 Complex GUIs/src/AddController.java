import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 * AddController
 *
 * Serves the controller portion of the MVC paradigm, controls the overall function of the AddTweet view.
 *
 * @author Dylan Martin
 *
 * @version April 8, 2019
 *
 */

public final class AddController {

    private TwitterModel twitterModel;
    private AddTweet addTweet;

    /** Implement the AddController constructor per the instructions in the handout
     * @param twitterModel TwitterModel object connecting the model and controller portions of the MVC paradigm.
     * @param addTweet AddTweet object connecting the view and controller portions of the MVC paradigm.
     */
    public AddController(TwitterModel twitterModel, AddTweet addTweet) throws IllegalArgumentException {
        this.twitterModel = twitterModel;
        this.addTweet = addTweet;

        addTweet.getTweetButton().addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {
                getAddButtonSemantics();
            }
        });

        addTweet.getClearButton().addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {
                getClearButtonSemantics();
            }
        });
    }

    /** A method used to verify if a given string is strictly containing numeric values.
     * @param aString A string to verify
     * @return boolean
     */
    public static boolean isNumeric(String aString) {
        if (aString == null) {
            return false;
        } else if (aString.isEmpty()) {
            return false;
        } else if (aString.indexOf(".") != aString.lastIndexOf(".")) {
            return false;
        } else {
            int counter = 0;
            for ( char c : aString.toCharArray()) {
                if ( Character.isDigit(c)) {
                    counter++;
                }
            }
            return counter == aString.length();
//            if (counter == aString.length()) {
//                return true;
//            }
//            return false;
        }
    }

    //TwitterModel tweetModel = new TwitterModel();

    /** A method to control specific GUI component actions. */
    private void getAddButtonSemantics() {
        String requestingTweetID = addTweet.getidTextField().getText();
        String requestingTweetBody = addTweet.getBodyTextField().getText();
        JFrame error = new JFrame("Error");

        if (!isNumeric(requestingTweetID) || requestingTweetID.contains("-")) {
            JOptionPane.showMessageDialog(error, "The specified ID is not a valid number!");
        } else {
            Tweet requestingTweet = new Tweet(requestingTweetID, requestingTweetBody);
            requestingTweet.setID(requestingTweetID);
            requestingTweet.setBody(requestingTweetBody);
            if (twitterModel.contains(requestingTweet)) {
                JOptionPane.showMessageDialog(error, "The specified ID is not a valid number!");
            } else {
                twitterModel.add(requestingTweet);
                System.out.println("Tweet added: " + requestingTweet.getID() + ": " + requestingTweet.getBody());
//                for (int i = 0; i < twitterModel.getTweetList().size(); i++) {
//                    //System.out.println(Arrays.toString(twitterModel.getTweetList().toArray()));
//
//                }
                System.out.println(twitterModel.getTweetList());
            }
        }
    }

    /** A method to control specific GUI component actions. */
    public void getClearButtonSemantics() {
        JTextField bodyTextField = addTweet.getBodyTextField();
        bodyTextField.setText("");
        bodyTextField.requestFocus();
    }
}
