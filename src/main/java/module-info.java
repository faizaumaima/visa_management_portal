module com.example.visa_management_portal {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.visa_management_portal to javafx.fxml;
    exports com.example.visa_management_portal;
}