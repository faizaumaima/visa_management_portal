module com.example.ms3_group47_evisa {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.ms3_group47_evisa to javafx.fxml;
    opens com.example.ms3_group47_evisa.ApplicationIntakeOfficer to javafx.fxml, javafx.base ;
    opens com.example.ms3_group47_evisa.ImmigrationOfficer to javafx.fxml, javafx.base;
    opens com.example.ms3_group47_evisa.CustomerSupportAgency to javafx.fxml, javafx.base;
    opens com.example.ms3_group47_evisa.DataEntryClerk to javafx.fxml, javafx.base;
    opens com.example.ms3_group47_evisa.FinancialOfficer to javafx.fxml, javafx.base;
    opens com.example.ms3_group47_evisa.VisaOfficer to javafx.fxml, javafx.base;
    exports com.example.ms3_group47_evisa;
}