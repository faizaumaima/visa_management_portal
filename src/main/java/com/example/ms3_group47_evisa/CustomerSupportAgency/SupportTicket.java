package com.example.ms3_group47_evisa.CustomerSupportAgency;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class SupportTicket
{
    @javafx.fxml.FXML
    private TableColumn<ApplicantClass, String> columnApplicantName;
    @javafx.fxml.FXML
    private TableColumn<ApplicantClass, String> columnStatus;
    @javafx.fxml.FXML
    private TableView <ApplicantClass> tableViewTickets;
    @javafx.fxml.FXML
    private TextArea textAreaReply;
    @javafx.fxml.FXML
    private TextArea textAreaApplicationMessage;
    @javafx.fxml.FXML
    private TableColumn<ApplicantClass, String> colTicketId;
    @javafx.fxml.FXML
    private Label outputlabel;

    @javafx.fxml.FXML
    public void initialize() {
        columnApplicantName.setCellValueFactory(new PropertyValueFactory<>("applicantName"));
        columnStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colTicketId.setCellValueFactory(new PropertyValueFactory<>("ticketId"));
    }

    @javafx.fxml.FXML
    public void handleSendReplyOnAction(ActionEvent actionEvent) {
        if (columnApplicantName.getText().trim().isEmpty()){
            outputlabel.setText("Confirmed");
            return;
        }
    }
}