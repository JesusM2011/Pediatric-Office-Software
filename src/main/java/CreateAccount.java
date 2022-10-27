import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static Main.accounts;

public class CreateAccount {

    @FXML
    private PasswordField password_field;

    @FXML
    private TextField email_field;

    @FXML
    private PasswordField verify_field;

    @FXML
    private TextField username_field;

    @FXML
    private Label username_error;

    @FXML
    private TextField birthday_field;

    @FXML
    private Button back;

    @FXML
    private Button create;

    @FXML
    private Label password_error;

    @FXML
    private TextField phoneNo_field;

    @FXML
    private TextField firstName_field;

    @FXML
    private TextField lastName_field;

    @FXML // Need to add functionality for [username taken]
    void createAccount(ActionEvent event) throws IOException {
        if (password_field.getText().equals(verify_field.getText())) {
            Patient newPatient = new Patient(firstName_field.getText(), lastName_field.getText(), birthday_field.getText(), username_field.getText(),
                    password_field.getText(), email_field.getText(), phoneNo_field.getText());
            accounts.addPatient(newPatient);
            // save and overwrite patients file
            //accounts.patientsToFile();
            goBack(event);
        }
        else password_error.setVisible(true);
    }

    @FXML
    void goBack(ActionEvent event) throws IOException // go back to login page
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LogIn.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
