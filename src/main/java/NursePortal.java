import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

import static Main.accounts;

public class NursePortal extends Portal {

    @FXML
    private Button viewPatient_button;

    @FXML
    private Button logout;

    @FXML
    private Button newMessage_button;

    @FXML
    private Label welcomeMessage;

    @FXML
    private Button viewMessages_button; //view patient portal

    @FXML
    private Button assign_button; //assign patient to doctor

    @FXML
    private Button inputVitals_button;

    @FXML
    public void initialize () {
        welcomeMessage.setText("Welcome, " + accounts.loggedOn.getFirstName());
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
    void gotoAssign(ActionEvent event) throws IOException {
        switchToScene(event, "AdmitPatient.fxml");
    }

    @FXML
    void gotoInputVitals(ActionEvent event) throws IOException {
        switchToScene(event, "EnterVitals.fxml");
    }

    @FXML
    void gotoViewPatient(ActionEvent event) throws IOException {
        switchToScene(event, "ViewPatientData.fxml");
    }
}
