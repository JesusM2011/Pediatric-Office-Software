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

public class ViewVisitHistory {

    @FXML
    private ChoiceBox<VisitSummary> visit_choice;

   @FXML
    private Text recommendations_text;

    @FXML
    private Text prescription_text;

    @FXML
    private Text vitals_text;

    @FXML
    private Button back;

    @FXML
    private TextFlow summary_flow;

    @FXML
    private Button summary_button;

    @FXML
    public void initialize () {
        summary_flow.setDisable(true);
        visit_choice.getItems().addAll(accounts.loggedOn.getHistory());
        if (accounts.loggedOn.getHistory().isEmpty()) {
            visit_choice.setDisable(true);
            summary_button.setDisable(true);
            recommendations_text.setText("");
        } else
            recommendations_text.setText("Select a visit summary");
        prescription_text.setText("");
        vitals_text.setText("");
    }

    @FXML
    void loadSummary(ActionEvent event) {
        summary_flow.setDisable(false);
        if (visit_choice.getValue().getVitals() != null)
            vitals_text.setText(visit_choice.getValue().getVitals().toString() + '\n');
        else
            vitals_text.setText("No vitals\n\n");
        recommendations_text.setText("Recommendations:\n" + visit_choice.getValue().getRecommendations() + "\n\n");
        if (visit_choice.getValue().getPrescription() != null)
            prescription_text.setText(visit_choice.getValue().getPrescription().toString());
        else
            prescription_text.setText("No prescription");

    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PatientPortal.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
