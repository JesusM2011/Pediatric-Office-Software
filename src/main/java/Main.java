import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LogIn.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Welcome!");
        stage.setScene(scene);
        stage.show();
    }

    public static Database accounts = new Database();

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // Hard coding 2 doctors and 2 nurses and 3 patients
        accounts.addDoctor(new Doctor("Aylin", "Perez", "01/01/2000", "Doctor", "DoctPass")); // first doctor
        accounts.addNurse(new Nurse("Alexa", "Perez", "01/01/2000", "Nurse", "NursePass")); // first nurse

        accounts.patientsFromFile();
        launch();
        accounts.patientsToFile();
    }
}