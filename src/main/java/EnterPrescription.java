import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static Main.accounts;

public class EnterPrescription {

    @FXML
    private TextArea notes_field;

    @FXML
    private TextField drug_field;

    @FXML
    private Button submit;

    @FXML
    private Button back;

    @FXML
    private Label amount_error;

    @FXML
    private Label prescription_label;

    @FXML
    private TextField amount_field;

    @FXML
    public void initialize () {
        if (accounts.loggedOn.getCurrentPatient() != null) {
            prescription_label.setText("Enter Prescription for: " + accounts.loggedOn.getCurrentPatient().getFirstName() +
                    " " + accounts.loggedOn.getCurrentPatient().getLastName());
            if (accounts.loggedOn.getCurrentPatient().getCurrentPrescription() != null) {
                drug_field.setText(accounts.loggedOn.getCurrentPatient().getCurrentPrescription().getDrug());
                amount_field.setText(accounts.loggedOn.getCurrentPatient().getCurrentPrescription().getAmount() + "");
                notes_field.setText(accounts.loggedOn.getCurrentPatient().getCurrentPrescription().getNotes());
            }
        }
        else {
            prescription_label.setText("No patient assigned");
            drug_field.setDisable(true);
            amount_field.setDisable(true);
            notes_field.setDisable(true);
            submit.setDisable(true);
        }
    }

    @FXML
    void submitPrescription(ActionEvent event) throws IOException {
        if (accounts.loggedOn.getCurrentPatient() == null) goBack(event);

        try{
            int amount = Integer.parseInt(amount_field.getText());
            accounts.loggedOn.getCurrentPatient().setCurrentPrescription(drug_field.getText(), amount, notes_field.getText());
            goBack(event);
        }
        catch (NumberFormatException ex){
            amount_error.setVisible(true);
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

}
