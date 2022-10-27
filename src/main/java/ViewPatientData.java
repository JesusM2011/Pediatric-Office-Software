
// loop through visit history, add all the prescriptions to a java list

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static Main.accounts;

public class ViewPatientData extends Portal{

    //takes first and last name and returns patient history
    //how to connect this to the database
    // should this class extend portal and take the user to a different scene when view history is clicked

    @FXML
    private Text issues_text;

    @FXML
    private Text recommendations_text;

    @FXML
    private Text prescription_text;

    @FXML
    private Text vitals_text;

    @FXML
    private Text immunization_text;

    @FXML
    private Button back;

    @FXML
    private Text pharmacy_text;

    @FXML
    private ChoiceBox<Patient> patient_choice;

    @FXML
    private Text insurance_text;

    @FXML
    private TextFlow summary_flow;

    @FXML
    private Button summary_button;

    @FXML
    public void initialize () {
        summary_flow.setDisable(true);
        patient_choice.getItems().addAll(accounts.getPatients());
        if (accounts.getPatients() == null) {
            patient_choice.setDisable(true);
            summary_button.setDisable(true);
            vitals_text.setText("");
        } else
            vitals_text.setText("Select a visit summary");
        issues_text.setText("");
        recommendations_text.setText("");
        pharmacy_text.setText("");
        insurance_text.setText("");
        immunization_text.setText("");
        prescription_text.setText("");
    }

    @FXML
    void loadSummary(ActionEvent event) {
        summary_flow.setDisable(false);

        int lastVisitIndex = -1;
        boolean hasLastVisit = false;
        int historySize = patient_choice.getValue().getHistory().size();
        if (historySize > 0) {
            if (patient_choice.getValue().hasCurrentVisitSummary()) {
                if (historySize > 1) {
                    lastVisitIndex = historySize - 2;
                    hasLastVisit = true;
                }
            }
            else {
                lastVisitIndex = historySize - 1;
                hasLastVisit = true;
            }
        }

        // vitals
        if (hasLastVisit && (patient_choice.getValue().getHistory().get(lastVisitIndex).getVitals() != null))
            vitals_text.setText("Previous " + patient_choice.getValue().getHistory().get(lastVisitIndex).getVitals().toString() + "\n");
        else vitals_text.setText("No previous vitals.\n\n");
        // issues
        if (patient_choice.getValue().getIssues() != null)
            issues_text.setText("Health Issues:\n" + patient_choice.getValue().getIssues() + "\n\n");
        else issues_text.setText("No health issues on file.\n\n");
        // recommendations
        if (hasLastVisit && (patient_choice.getValue().getHistory().get(lastVisitIndex).getRecommendations() != null))
            recommendations_text.setText("Previous recommendations: " + patient_choice.getValue().getHistory().get(lastVisitIndex).getRecommendations() + "\n\n");
        else recommendations_text.setText("No previous recommendations.\n\n");
        // pharmacy
        if (patient_choice.getValue().getPharmacy() != null)
            pharmacy_text.setText("Patient Pharmacy: " + patient_choice.getValue().getPharmacy() + "\n\n");
        else pharmacy_text.setText("No pharmacy on file.\n\n");
        // insurance
        if (patient_choice.getValue().getInsuranceProvider() != null)
            insurance_text.setText("Patient Insurance Provider: " + patient_choice.getValue().getInsuranceProvider() + "\n\n");
        else insurance_text.setText("No insurance on file.\n\n");
        // immunizations
        if (patient_choice.getValue().getImmunizations() != null)
            immunization_text.setText("Patient Immunization Record: " + patient_choice.getValue().getImmunizations() + "\n\n");
        else immunization_text.setText("No immunization record on file.\n\n");
        // prescription
        if (hasLastVisit && (patient_choice.getValue().getHistory().get(lastVisitIndex).getPrescription() != null))
            prescription_text.setText("Previous " + patient_choice.getValue().getHistory().get(lastVisitIndex).getPrescription().toString());
        else prescription_text.setText("No previous recommendations.");
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("NursePortal.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
