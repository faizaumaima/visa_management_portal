module com.example.finalms3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.finalms3 to javafx.fxml;
    exports com.example.finalms3;
}