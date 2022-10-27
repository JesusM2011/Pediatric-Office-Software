import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static Main.accounts;

public class EnterVitals {

    @FXML
    private TextField bloodP_field;

    @FXML
    private TextField bodyTemp_field;

    @FXML
    private Label type_error;

    @FXML
    private Button submit;

    @FXML
    private TextField height_field;

    @FXML
    private Button back;

    @FXML
    private ChoiceBox<Patient> patient_choice;

    @FXML
    private TextField healthConcerns_field;

    @FXML
    private TextField weight_field;

    @FXML
    public void initialize () {
        patient_choice.getItems().addAll(accounts.getPatients());
    }


    @FXML
    void submitVitals(ActionEvent event) throws IOException {
        try{
            int weight = Integer.parseInt(weight_field.getText());
            int height = Integer.parseInt(height_field.getText());
            int bodyTemp = Integer.parseInt(bodyTemp_field.getText());
            int bloodP = Integer.parseInt(bloodP_field.getText());
            patient_choice.getValue().setCurrentVitals(weight, height, bodyTemp, bloodP);
            patient_choice.getValue().setCurrentHealthConcerns(healthConcerns_field.getText());
            goBack(event);
        }
        catch (NumberFormatException ex){
            type_error.setVisible(true);
        }
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
