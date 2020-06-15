import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * DeleteController
 *
 * Serves the controller portion of the MVC paradigm, controls the overall function of the DeleteTweet view.
 *
 * @author Dylan Martin
 *
 * @version April 8, 2019
 *
 */

public final class DeleteController {

    private TwitterModel twitterModel;
    private DeleteTweet deleteTweet;

    /** Implement the DeleteController constructor per the instructions in the handout
     * @param twitterModel TwitterModel object connecting the model and controller portions of the MVC paradigm.
     * @param deleteTweet DeleteTweet object connecting the view and controller portions of the MVC paradigm.
     */
    public DeleteController(TwitterModel twitterModel, DeleteTweet deleteTweet) throws IllegalArgumentException {
        this.twitterModel = twitterModel;
        this.deleteTweet = deleteTweet;

        deleteTweet.getDeleteButton().addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {
                getDeleteButtonSemantics();
            }
        });

        deleteTweet.getClearButton().addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {
                getClearButtonSemantics();
            }
        });
    }

    /** A method to control specific GUI component actions. */
    private void getDeleteButtonSemantics() {
        String requestingID = deleteTweet.getidTextField().getText();
        //Tweet requestingTweet = new Tweet(requestingID, "PLACEHOLDER; YOU SHOULD NOT SEE THIS.");
        JFrame error = new JFrame("Error");
        Optional<Tweet> tweetFoundOptional = twitterModel.searchByID(requestingID);
        boolean isPresent = tweetFoundOptional.isPresent();

        if (!isPresent) {
            JOptionPane.showMessageDialog(error, "A message with the given ID does not exist!");
        } else {
            Tweet tweetFound = tweetFoundOptional.get();
            twitterModel.remove(tweetFound);
            JFrame success = new JFrame("Success");
            JOptionPane.showMessageDialog(success, "Successfully removed tweet!");
            JTextField idTextField = deleteTweet.getidTextField();
            idTextField.setText("");
            idTextField.requestFocus();
        }
    }


    /** A method to control specific GUI component actions. */
    private void getClearButtonSemantics() {
        JTextField idTextField = deleteTweet.getidTextField();
        idTextField.setText("");
        idTextField.requestFocus();
    }
}
