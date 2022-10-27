import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static Main.accounts;

public class InputRecommendations {

    @FXML
    private Label recommendations_label;

    @FXML
    private Button submit;

    @FXML
    private Button back;

    @FXML
    private TextArea recommendations_field;

    @FXML
    public void initialize () {
        if (accounts.loggedOn.getCurrentPatient() != null) {
            recommendations_label.setText("Input recommendations for: " + accounts.loggedOn.getCurrentPatient().getFirstName() +
                    " " + accounts.loggedOn.getCurrentPatient().getLastName());
            recommendations_field.setText(accounts.loggedOn.getCurrentPatient().getCurrentRecommendations());
        }
        else {
            recommendations_label.setText("No patient assigned");
            recommendations_field.setDisable(true);
            submit.setDisable(true);
        }
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("DoctorPortal.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void submitRecommendations(ActionEvent event) throws IOException {
        if (accounts.loggedOn.getCurrentPatient() != null) {
            accounts.loggedOn.getCurrentPatient().setCurrentRecommendations(recommendations_field.getText());
        }
        goBack(event);
    }

}
