package com.example.ms3_group47_evisa;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import com.example.ms3_group47_evisa.utils.NavigationUtil;
import com.example.ms3_group47_evisa.models.Event;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import java.time.LocalDate;

public class UpcomingEventsDashboard {

    @FXML
    private Button backButton;
    
    @FXML
    private Button reportVitalEventsButton;
    
    @FXML
    private Button upcomingEventsButton;
    
    @FXML
    private Button feedbackButton;
    
    @FXML
    private Button loadEventsButton;
    
    @FXML
    private Button addEventButton;
    
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
    private TableColumn<Event, String> notificationColumn;
    
    @FXML
    private DatePicker filterDatePicker;
    
    @FXML
    private DatePicker eventDatePicker;
    
    @FXML
    private TextField eventNameField;
    
    @FXML
    private TextField eventIdField;
    
    @FXML
    private TextField eventLocationField;
    
    @FXML
    private ComboBox<String> eventTypeComboBox;

    private ObservableList<Event> eventsData;
    private FilteredList<Event> filteredData;

    @FXML
    public void initialize() {
        // Initialize events data
        eventsData = FXCollections.observableArrayList();
        
        // Add sample upcoming events
        Event event1 = new Event("Conference", LocalDate.now().plusDays(7), "Main Hall", "Tech Summit 2024", "Annual technology summit");
        event1.setId("EVT001");
        eventsData.add(event1);
        
        Event event2 = new Event("Workshop", LocalDate.now().plusDays(14), "Training Room", "Security Training", "Security awareness workshop");
        event2.setId("EVT002");
        eventsData.add(event2);
        
        Event event3 = new Event("Meeting", LocalDate.now().plusDays(3), "Board Room", "Management Review", "Monthly management review");
        event3.setId("EVT003");
        eventsData.add(event3);
        
        // Initialize event type combo box
        ObservableList<String> eventTypes = FXCollections.observableArrayList(
            "Conference", "Workshop", "Meeting", "Training", "Seminar", "Exhibition"
        );
        eventTypeComboBox.setItems(eventTypes);
        
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
        notificationColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty("Pending"));
        
        // Set up filtering
        setupFiltering();
        
        // Set up table selection listener
        eventsTableView.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> {
                if (newValue != null) {
                    showEventDetails(newValue);
                }
            }
        );
    }

    private void setupFiltering() {
        filteredData = new FilteredList<>(eventsData, p -> true);
        
        // Date filter
        filterDatePicker.valueProperty().addListener((observable, oldValue, newValue) -> {
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

    private void showEventDetails(Event event) {
        // Display event details in the form fields
        eventIdField.setText(event.getId());
        eventNameField.setText(event.getName());
        eventLocationField.setText(event.getLocation());
        eventDatePicker.setValue(event.getDate());
        eventTypeComboBox.setValue(event.getEventType());
    }

    @FXML
    protected void onBackClick() {
        Stage currentStage = (Stage) backButton.getScene().getWindow();
        NavigationUtil.navigateToEvents(currentStage);
    }

    @FXML
    protected void onReportVitalEventsClick() {
        System.out.println("Report Vital Events clicked");
        // TODO: Implement vital events reporting
    }

    @FXML
    protected void onUpcomingEventsClick() {
        System.out.println("Upcoming Events clicked");
        // TODO: Implement upcoming events view
    }

    @FXML
    protected void onFeedbackClick() {
        System.out.println("Feedback clicked");
        // TODO: Implement feedback functionality
    }

    @FXML
    protected void onLoadEventsClick() {
        System.out.println("Load Events clicked");
        // TODO: Implement events loading from database
    }

    @FXML
    protected void onAddEventClick() {
        if (validateEventForm()) {
            String eventId = "EVT" + String.format("%03d", eventsData.size() + 1);
            Event newEvent = new Event(
                eventTypeComboBox.getValue(),
                eventDatePicker.getValue(),
                eventLocationField.getText(),
                eventNameField.getText(),
                "New event added by user"
            );
            
            newEvent.setId(eventId);
            eventsData.add(newEvent);
            clearEventForm();
            showAlert("Success", "Event added successfully!\nEvent ID: " + eventId);
        }
    }

    private boolean validateEventForm() {
        if (eventNameField.getText().isEmpty() || eventLocationField.getText().isEmpty() ||
            eventDatePicker.getValue() == null || eventTypeComboBox.getValue() == null) {
            
            showAlert("Validation Error", "Please fill in all required fields.");
            return false;
        }
        return true;
    }

    private void clearEventForm() {
        eventNameField.clear();
        eventLocationField.clear();
        eventDatePicker.setValue(null);
        eventTypeComboBox.setValue(null);
        eventIdField.clear();
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}



