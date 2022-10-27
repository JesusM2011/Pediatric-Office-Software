import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static Main.accounts;

public class AdmitPatient {

    @FXML
    private Button confirm;

    @FXML
    private Button back;

    @FXML
    private Label success_field;

    @FXML
    private ChoiceBox<Patient> patient_choice;

    @FXML
    private ChoiceBox<Doctor> doctor_choice;

    @FXML
    public void initialize () {
        patient_choice.getItems().addAll(accounts.getPatients());
        doctor_choice.getItems().addAll(accounts.getDoctors());
    }

    @FXML
    void assignPatient(ActionEvent event) {
        doctor_choice.getValue().currentPatient = patient_choice.getValue();
        success_field.setVisible(true);
        confirm.setDisable(true);
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("NursePortal.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
