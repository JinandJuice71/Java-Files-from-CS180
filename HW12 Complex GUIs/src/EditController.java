import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

/**
 * EditController
 *
 * Serves the controller portion of the MVC paradigm, controls the overall function of the EditTweet view.
 *
 * @author Dylan Martin
 *
 * @version April 8, 2019
 *
 */

public final class EditController {

    private TwitterModel twitterModel;
    private EditTweet editTweet;

    /** Implement the AddController constructor per the instructions in the handout
     * @param twitterModel TwitterModel object connecting the model and controller portions of the MVC paradigm.
     * @param editTweet EditTweet object connecting the view and controller portions of the MVC paradigm.
     */
    public EditController(TwitterModel twitterModel, EditTweet editTweet) throws IllegalArgumentException {
        this.twitterModel = twitterModel;
        this.editTweet = editTweet;

        editTweet.getEditButton().addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {
                getEditButtonSemantics();
            }
        });

        editTweet.getClearButton().addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {
                getClearButtonSemantics();
            }
        });
    }

    /** A method used to update a specific Tweet's body string.
     * @param aTweet Tweet object containing an ID and body String
     * @param body String
     */
    private void updateBody(Tweet aTweet, String body) {
        if (body.equals("")) {
            JOptionPane.showMessageDialog(
                    this.editTweet.getMainPanel(),
                    "This message body is empty. Maybe you should instead delete it?",
                    "Message Board",
                    JOptionPane.ERROR_MESSAGE);
            this.editTweet.getBodyTextField().requestFocus();
        } else {
            aTweet.setBody(body);
            JOptionPane.showMessageDialog(
                    this.editTweet.getMainPanel(),
                    "This message was properly updated!",
                    "Message Board",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /** A method to control specific GUI component actions. */
    private void getEditButtonSemantics() {
        JFrame error = new JFrame("Error");

        String requestingID = editTweet.getidTextField().getText();
        Optional<Tweet> tweetEditOptional = twitterModel.searchByID(requestingID);
        boolean isPresent = tweetEditOptional.isPresent();

        if (!isPresent) {
            JOptionPane.showMessageDialog(error, "A message with the given ID does not exist!");
        } else {
            Tweet tweetFound = tweetEditOptional.get();
            updateBody(tweetFound, editTweet.getBodyTextField().getText());
        }

    }

    /** A method to control specific GUI component actions. */
    private void getClearButtonSemantics() {
        JTextField bodyTextField = editTweet.getBodyTextField();
        bodyTextField.setText("");
        bodyTextField.requestFocus();
    }

}
