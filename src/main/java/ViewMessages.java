import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.sql.*;
import static Main.accounts;

public class ViewMessages {

    @FXML
    private TextField MessageText_Field;


    @FXML
    private TextField MessageFrom_field;

    @FXML
    private TextField MessageText1_Field;

    @FXML
    private TextField MessageFrom1_field;
    @FXML
    private TextField MessageText2_Field;


    @FXML
    private TextField MessageFrom2_field;

    @FXML
    private TextField MessageFromChoice_field;

    @FXML
    private Label successPrompt;

    @FXML
    public void initialize() {


        MessageFromChoice_field.setText("Enter Message_From (optional).");
        String mesgFromChoice = MessageFromChoice_field.getText();
    }

    @FXML
    void submitChoice(ActionEvent event) {
        accounts.loggedOn.setMessage(MessageFromChoice_field.getText());
        //  successPrompt.setText("Message saved!");
        // successPrompt.setVisible(true);
        Connection c = null;
        Statement stmt = null;
        String qry3;
        try {

            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/data/360_project.db");
            c.setAutoCommit(false);
            String[] arrayname = new String[100];
            String[] arraymess = new String[100];
            stmt = c.createStatement();
            String uname = accounts.loggedOn.getUsername();
            String messfrom = MessageFromChoice_field.getText();
            PreparedStatement preparedStatement = null;
            final String qry1 = "SELECT message_from,message FROM users_inbox where username = '" + uname + "'";
            final String qry2 = " And message_from = '" + messfrom + "'";

            if (messfrom.length() > 0) // check if user enter anything only then need to concatnate other column
                qry3 = qry1 + qry2;
            else
                qry3 = qry1;

              preparedStatement = c.prepareStatement(qry3 + " ORDER BY id DESC");

            // execute select SQL stetement
            ResultSet rs = preparedStatement.executeQuery();
            int i = 1;
            while (rs.next()) {
                //    String name = rs.getString("username");
                //   String mess = rs.getString("message");
                String name = rs.getString(1);
                String mess = rs.getString(2);
                arrayname[i] = rs.getString("message_from");
                arraymess[i] = rs.getString("message");
                i++;

            }
            // Set 3 messages on screen..
            MessageFrom_field.setText(arrayname[1]);
            MessageText_Field.setText(arraymess[1]);

            MessageFrom1_field.setText(arrayname[2]);
            MessageText1_Field.setText(arraymess[2]);

            MessageFrom2_field.setText(arrayname[3]);
            MessageText2_Field.setText(arraymess[3]);

            // MessageFrom_field.setText(age);
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    //    System.out.println("Operation done successfully");
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
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}