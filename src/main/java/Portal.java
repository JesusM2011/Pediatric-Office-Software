/* Parent class for PatientPortal, NursePortal, and DoctorPortal
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static Main.accounts;

public class Portal {

    protected void switchToScene(ActionEvent event, String name) throws IOException
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(name)));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void logOut(ActionEvent event) throws IOException {
        accounts.logOut();
        switchToScene(event, "LogIn.fxml");
    }

}
