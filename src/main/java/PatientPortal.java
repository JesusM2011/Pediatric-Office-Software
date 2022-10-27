import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

import static Main.accounts;

public class PatientPortal extends Portal {

    @FXML
    private Button logout;

    @FXML
    private Label welcomeMessage;

    @FXML
    private Button newMessage_button;

    @FXML
    private Button viewMessages_button;

    @FXML
    private Button contactInfo_button;

    @FXML
    private Button visitSummary_button;

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
    void gotoSummary(ActionEvent event) throws IOException {
        switchToScene(event, "ViewVisitHistory.fxml");
    }

    @FXML
    void gotoContactInfo(ActionEvent event) throws IOException {
        switchToScene(event, "EditContactInfo.fxml");
    }

}
