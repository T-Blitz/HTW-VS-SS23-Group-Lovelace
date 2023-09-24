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
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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

    public void signupButtonOnAction(ActionEvent event) {
        signupMessageLabel.setText("trying to Sign up");
        if (enterUsernameField.getText().isBlank() ||
                enterPasswordField.getText().isBlank()) {

            signupMessageLabel.setText("Please fill all text fields");
        }
    }

    public void signupUser() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String username = enterUsernameField.getText();
        String password = enterPasswordField.getText();

        String insertText = "INSERT INTO user(username, password) VALUES ('";
        String insertData = username + "','" + password + "')";
        String insertSQL = insertText + insertData;

        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertSQL);
            signupMessageLabel.setText("Successfull Sign up");
        }catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}
