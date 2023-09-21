import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginController {
    @FXML
    private Button cancelButton;

    @FXML
    private TextField usernameTextfield;

    @FXML
    private TextField passwordTextfield;

    @FXML
    private Label loginMessageLabel;

    public void cancelButtonOnAction(ActionEvent event) {
        Stage loginStage = (Stage) cancelButton.getScene().getWindow();
        loginStage.close();
    }

    public void signupButtonOnAction(ActionEvent event) throws IOException{

        Parent signupParent = FXMLLoader.load(getClass().getResource("signup.fxml"));
        Scene signupScene = new Scene(signupParent);

        Stage signupStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        signupStage.setScene(signupScene);
        signupStage.show();
    }

    public void loginButtonOnAction(ActionEvent event) {
        validateLogin();
    }

    public void validateLogin() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM user Where username = '" + usernameTextfield.getText() + "' AND password = '" + passwordTextfield + "'";

        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while(queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    loginMessageLabel.setText("Welcome");
                }else {
                    loginMessageLabel.setText("Invalid Login");
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
