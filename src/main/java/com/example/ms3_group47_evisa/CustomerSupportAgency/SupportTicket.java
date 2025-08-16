package com.example.ms3_group47_evisa.CustomerSupportAgency;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class SupportTicket
{
    @javafx.fxml.FXML
    private TableColumn columnApplicantName;
    @javafx.fxml.FXML
    private TableColumn columnStatus;
    @javafx.fxml.FXML
    private TableView tableViewTickets;
    @javafx.fxml.FXML
    private TextArea textAreaReply;
    @javafx.fxml.FXML
    private TextArea textAreaApplicationMessage;
    @javafx.fxml.FXML
    private TableColumn colTicketId;
    @javafx.fxml.FXML
    private Label outputlabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleSendReplyOnAction(ActionEvent actionEvent) {
        if (columnApplicantName.isVisible() && columnStatus.isVisible() && tableViewTickets.isVisible() && colTicketId.isVisible()){
            outputlabel.setText("Confirmed");
        }
    }
}