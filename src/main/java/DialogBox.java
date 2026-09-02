import javafx.geometry.Pos;
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
}
