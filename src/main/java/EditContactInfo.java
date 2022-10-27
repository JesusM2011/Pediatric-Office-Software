import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static Main.accounts;

public class EditContactInfo {

    @FXML
    private TextField pharmacy_field;

    @FXML
    private Label successPrompt;

    @FXML
    private TextField email_field;

    @FXML
    private Button insurance_submit;

    @FXML
    private Button phoneNo_submit;

    @FXML
    private Button back;

    @FXML
    private TextField phoneNo_field;

    @FXML
    private TextField insurance_field;

    @FXML
    private Button pharmacy_submit;

    @FXML
    private Button address_submit;

    @FXML
    private TextField address_field;

    @FXML
    private Button email_submit;

    @FXML
    public void initialize () {
        pharmacy_field.setText(accounts.loggedOn.getPharmacy());
        email_field.setText(accounts.loggedOn.getEmail());
        phoneNo_field.setText(accounts.loggedOn.getPhoneNumber());
        insurance_field.setText(accounts.loggedOn.getInsuranceProvider());
        address_field.setText(accounts.loggedOn.getAddress());
    }

    @FXML
    void saveEmail(ActionEvent event) {
        accounts.loggedOn.setEmail(email_field.getText());
        successPrompt.setText("Email successfully saved!");
        successPrompt.setVisible(true);
    }

    @FXML
    void savePhoneNo(ActionEvent event) {
        accounts.loggedOn.setPhoneNumber(phoneNo_field.getText());
        successPrompt.setText("Phone no. successfully saved!");
        successPrompt.setVisible(true);
    }

    @FXML
    void saveAddress(ActionEvent event) {
        accounts.loggedOn.setAddress(address_field.getText());
        successPrompt.setText("Address successfully saved!");
        successPrompt.setVisible(true);
    }

    @FXML
    void saveInsurance(ActionEvent event) {
        accounts.loggedOn.setInsuranceProvider(insurance_field.getText());
        successPrompt.setText("Insurance successfully saved!");
        successPrompt.setVisible(true);
    }

    @FXML
    void savePharmacy(ActionEvent event) {
        accounts.loggedOn.setPharmacy(pharmacy_field.getText());
        successPrompt.setText("Pharmacy successfully saved!");
        successPrompt.setVisible(true);
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
