module com.example.cse360p1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.testng;
    requires org.junit.jupiter.api;


    opens com.example.cse360p1 to javafx.fxml;
    exports com.example.cse360p1;
    exports;
    opens to
}