import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static Main.accounts;

public class LogIn {

    @FXML
    private TextField password_field;

    @FXML
    private TextField username_field;

    @FXML
    private Text errorMessage;

    @FXML
    private Text password_text;

    @FXML
    private Button login;

    @FXML
    private Text username_text;

    @FXML
    private Button register;

    @FXML
    void gotoHomepage(ActionEvent event) throws IOException {
        accounts.authenticate(username_field.getText(), password_field.getText());
        switch (accounts.loggedOn.getType()) {
            case 'd': switchToScene(event, "DoctorPortal.fxml");
            case 'n': switchToScene(event, "NursePortal.fxml");
            case 'p': switchToScene(event, "PatientPortal.fxml");
            default: errorMessage.setVisible(true); // if no patient is logged in, show error
        }
    }

    @FXML
    void gotoRegister(ActionEvent event) throws IOException {
        switchToScene(event, "CreateAccount.fxml");

    }

    private void switchToScene(ActionEvent event, String name) throws IOException // going to nurse's home page
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(name)));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        if (stage != null) {
            stage.setScene(scene);
            stage.show();
        }
    }
}