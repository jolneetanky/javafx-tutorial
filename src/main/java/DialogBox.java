import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * Represents one dialog row in the Duke chat window.
 */
public class DialogBox extends HBox {
    private Label text;
    private ImageView displayPicture;

    /**
     * Creates a dialog box with message text and a display picture.
     *
     * @param message message to show
     * @param image display picture to show beside the message
     */
    public DialogBox(String message, Image image) {
        text = new Label(message);
        displayPicture = new ImageView(image);

        text.setWrapText(true);
        displayPicture.setFitWidth(100.0);
        displayPicture.setFitHeight(100.0);
        this.setAlignment(Pos.TOP_RIGHT);

        this.getChildren().addAll(text, displayPicture);
    }

    /**
     * Flips the dialog box such that the display picture is on the left and the text is on the right.
     */
    private void flip() {
        this.setAlignment(Pos.TOP_LEFT);
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        FXCollections.reverse(tmp);
        this.getChildren().setAll(tmp);
    }

    /**
     * Creates a dialog box for the user's message.
     *
     * @param message message to show
     * @param image display picture to show beside the message
     * @return dialog box aligned as a user message
     */
    public static DialogBox getUserDialog(String message, Image image) {
        return new DialogBox(message, image);
    }

    /**
     * Creates a dialog box for Duke's response.
     *
     * @param message message to show
     * @param image display picture to show beside the message
     * @return dialog box aligned as Duke's response
     */
    public static DialogBox getDukeDialog(String message, Image image) {
        DialogBox dialogBox = new DialogBox(message, image);
        dialogBox.flip();
        return dialogBox;
    }
}
