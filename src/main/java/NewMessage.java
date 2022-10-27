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
import java.sql.*;
public class NewMessage {

    @FXML
    private TextField message_field;

    @FXML
    private TextField messageTo_field;

    @FXML
    private Label successPrompt;

  

    @FXML
    private Button message_submit;

     

    @FXML
    public void initialize () {
      //  username_field.setText(accounts.loggedOn.getUsername());
        messageTo_field.setText("Enter Message To Username here...");
        message_field.setText("Enter Message here...");
       }
 
    @FXML
    void saveMessage(ActionEvent event) {
        {

            accounts.loggedOn.setMessage(message_field.getText());
             successPrompt.setText("Message saved!");
            successPrompt.setVisible(true);
            Connection c = null;

            try {

                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:src/main/data/360_project.db");

                String sql = "INSERT INTO users_inbox(username,message,message_from) VALUES(?,?,?)";
                String mesg = message_field.getText();
                String username = messageTo_field.getText();
                String mesgTo = accounts.loggedOn.getUsername();

                try (
                        //Connection conn = this.connect();
                        PreparedStatement pstmt = c.prepareStatement(sql)) {
                    pstmt.setString(1, username);
                    pstmt.setString(2, mesg);
                    pstmt.setString(3, mesgTo);
                    pstmt.executeUpdate();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }

            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
      //      System.out.println("Opened database successfully");
        }
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        String portal;
        switch (accounts.loggedOn.getType()) {
            case 'p': portal = "PatientPortal.fxml";
            case 'd': portal = "DoctorPortal.fxml";
            case 'n': portal = "NursePortal.fxml";
            default: portal =  "LogIn.fxml";
        }
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(portal)));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
