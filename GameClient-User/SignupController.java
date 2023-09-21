import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SignupController {
    @FXML
    private TextField enterUsernameField;

    @FXML
    private TextField enterPasswordField;

    @FXML
    private Label signupMessageLabel;

    public void cancelButtonOnAction(ActionEvent event) throws IOException {

        Parent cancelParent = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene cancelScene = new Scene(cancelParent);

        Stage cancelStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        cancelStage.setScene(cancelScene);
        cancelStage.show();
    }
}
