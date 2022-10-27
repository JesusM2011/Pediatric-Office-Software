import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

import static Main.accounts;

public class DoctorPortal extends Portal {

    @FXML
    private Button logout;

    @FXML
    private Label currentPatient_label;

    @FXML
    private Button newMessage_button;

    @FXML
    private Label welcomeMessage;

    @FXML
    private Button viewMessages_button;

    @FXML
    private Button prescription_button;

    @FXML
    private Button recommendations_button;

    @FXML
    public void initialize () {
        welcomeMessage.setText("Welcome, " + accounts.loggedOn.getFirstName());
        if (accounts.loggedOn.getCurrentPatient() != null) {
            currentPatient_label.setText("Current patient: " + accounts.loggedOn.getCurrentPatient().getFirstName() +
                    " " + accounts.loggedOn.getCurrentPatient().getLastName());
        }
        else {
            currentPatient_label.setText("Current patient: None");
            prescription_button.setDisable(true);
            recommendations_button.setDisable(true);
        }
    }

    @FXML
    void gotoMessages(ActionEvent event) throws IOException {
        switchToScene(event, "ViewMessages.fxml");
    }

    @FXML
    void gotoNewMessage(ActionEvent event) throws IOException {
        switchToScene(event, "NewMessage.fxml");
    }

    @FXML
    void gotoRecommendations(ActionEvent event) throws IOException {
        switchToScene(event, "InputRecommendations.fxml");
    }

    @FXML
    void gotoPrescription(ActionEvent event) throws IOException {
        switchToScene(event, "EnterPrescription.fxml");
    }
}
