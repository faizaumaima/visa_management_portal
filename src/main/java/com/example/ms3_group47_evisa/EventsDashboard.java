package com.example.ms3_group47_evisa;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import com.example.ms3_group47_evisa.utils.NavigationUtil;
import com.example.ms3_group47_evisa.services.DataService;
import com.example.ms3_group47_evisa.models.Event;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import java.time.LocalDate;

public class EventsDashboard {

    @FXML
    private TableView<Event> eventsTableView;

    @FXML
    private TableColumn<Event, String> idColumn;

    @FXML
    private TableColumn<Event, String> eventTypeColumn;

    @FXML
    private TableColumn<Event, LocalDate> dateColumn;

    @FXML
    private TableColumn<Event, String> locationColumn;

    @FXML
    private TableColumn<Event, String> nameColumn;

    @FXML
    private TableColumn<Event, String> statusColumn;

    @FXML
    private TextField searchTextField;

    @FXML
    private ComboBox<String> eventTypeFilterComboBox;

    @FXML
    private DatePicker dateFilterDatePicker;

    @FXML
    private Button registerButton;

    @FXML
    private Button backButton;

    @FXML
    private TextArea eventDetailsTextArea;

    @FXML
    private Label upcomingEventsLabel;

    // Additional buttons from FXML
    @FXML
    private Button reportVitalEventsButton;
    
    @FXML
    private Button upcomingEventsButton;
    
    @FXML
    private Button feedbackButton;
    
    @FXML
    private Button uploadDocumentButton;
    
    @FXML
    private Button submitButton;
    
    @FXML
    private Button reportButton;

    private DataService dataService;
    private FilteredList<Event> filteredData;

    @FXML
    public void initialize() {
        dataService = DataService.getInstance();
        
        // Initialize filter combo box
        ObservableList<String> eventTypes = FXCollections.observableArrayList(
            "All", "Birth Registration", "Marriage Certificate", "Death Certificate",
            "Passport Renewal", "Visa Application", "Citizenship", "Other"
        );
        eventTypeFilterComboBox.setItems(eventTypes);
        eventTypeFilterComboBox.setValue("All");
        
        // Initialize table columns
        idColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getId()));
        eventTypeColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getEventType()));
        dateColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getDate()));
        locationColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getLocation()));
        nameColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getName()));
        statusColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getStatus()));
        
        // Set up filtering
        setupFiltering();
        
        // Load events
        loadEvents();
        
        // Set up table selection listener
        eventsTableView.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> {
                if (newValue != null) {
                    showEventDetails(newValue);
                }
            }
        );
        
        // Update upcoming events count
        updateUpcomingEventsCount();
    }

    private void setupFiltering() {
        filteredData = new FilteredList<>(dataService.getAllEvents(), p -> true);
        
        // Search filter
        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(event -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                
                String lowerCaseFilter = newValue.toLowerCase();
                return event.getName().toLowerCase().contains(lowerCaseFilter) ||
                       event.getEventType().toLowerCase().contains(lowerCaseFilter) ||
                       event.getLocation().toLowerCase().contains(lowerCaseFilter);
            });
        });
        
        // Event type filter
        eventTypeFilterComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(event -> {
                if (newValue == null || newValue.equals("All")) {
                    return true;
                }
                return event.getEventType().equals(newValue);
            });
        });
        
        // Date filter
        dateFilterDatePicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(event -> {
                if (newValue == null) {
                    return true;
                }
                return event.getDate().equals(newValue);
            });
        });
        
        SortedList<Event> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(eventsTableView.comparatorProperty());
        eventsTableView.setItems(sortedData);
    }

    private void loadEvents() {
        // Data is loaded through the filtered list
    }

    private void showEventDetails(Event event) {
        StringBuilder details = new StringBuilder();
        details.append("Event ID: ").append(event.getId()).append("\n\n");
        details.append("Event Type: ").append(event.getEventType()).append("\n");
        details.append("Name: ").append(event.getName()).append("\n");
        details.append("Date: ").append(event.getDate()).append("\n");
        details.append("Location: ").append(event.getLocation()).append("\n");
        details.append("Status: ").append(event.getStatus()).append("\n\n");
        details.append("Description:\n").append(event.getDescription());
        
        if (event.getNotification() != null && !event.getNotification().isEmpty()) {
            details.append("\n\nNotification:\n").append(event.getNotification());
        }
        
        eventDetailsTextArea.setText(details.toString());
    }

    private void updateUpcomingEventsCount() {
        long upcomingCount = dataService.getAllEvents().stream()
            .filter(event -> event.getDate().isAfter(LocalDate.now()) || event.getDate().equals(LocalDate.now()))
            .count();
        upcomingEventsLabel.setText("Upcoming Events: " + upcomingCount);
    }

    @FXML
    protected void onRegisterClick() {
        Event selectedEvent = eventsTableView.getSelectionModel().getSelectedItem();
        if (selectedEvent != null) {
            if (selectedEvent.getDate().isBefore(LocalDate.now())) {
                showAlert("Error", "Cannot register for past events.");
                return;
            }
            
            // Here you would implement the actual registration logic
            showAlert("Success", "Successfully registered for: " + selectedEvent.getName() + 
                "\nEvent Date: " + selectedEvent.getDate() + 
                "\nLocation: " + selectedEvent.getLocation());
        } else {
            showAlert("Error", "Please select an event to register for.");
        }
    }

    @FXML
    protected void onBackClick() {
        Stage currentStage = (Stage) backButton.getScene().getWindow();
        NavigationUtil.navigateToClientDashboard(currentStage);
    }

    // Additional event handlers from FXML
    @FXML
    protected void onReportVitalEventsClick() {
        // Handle Report Vital Events button click
        System.out.println("Report Vital Events clicked");
        // TODO: Implement vital events reporting functionality
    }

    @FXML
    protected void onUpcomingEventsClick() {
        // Handle Upcoming Events button click
        System.out.println("Upcoming Events clicked");
        // TODO: Implement upcoming events functionality
    }

    @FXML
    protected void onFeedbackClick() {
        // Handle Feedback button click
        System.out.println("Feedback clicked");
        // TODO: Implement feedback functionality
    }

    @FXML
    protected void onUploadDocumentClick() {
        // Handle Upload Document button click
        System.out.println("Upload Document clicked");
        // TODO: Implement document upload functionality
    }

    @FXML
    protected void onSubmitClick() {
        // Handle Submit button click
        System.out.println("Submit clicked");
        // TODO: Implement submit functionality
    }

    @FXML
    protected void onReportClick() {
        // Handle Report button click
        System.out.println("Report clicked");
        // TODO: Implement report functionality
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
