package com.example.ms3_group47_evisa.CustomerSupportAgency;

import com.example.ms3_group47_evisa.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class ApplicantInfo
{
    @javafx.fxml.FXML
    private TextField phoneNumberField;
    @javafx.fxml.FXML
    private TextField applicationStatus;
    @javafx.fxml.FXML
    private TextField fullNameField;
    @javafx.fxml.FXML
    private TextField applicantIdField;
    @javafx.fxml.FXML
    private TextArea remarksArea;
    @javafx.fxml.FXML
    private TextField emailField;
    @javafx.fxml.FXML
    private TextField visaTypeField;
    @javafx.fxml.FXML
    private TextField dateOfBirthField;
    @javafx.fxml.FXML
    private TextField nationalityField;
    @javafx.fxml.FXML
    private TextField applicationIdField;
    @javafx.fxml.FXML
    private Label outputlabel;

    @javafx.fxml.FXML
    public void initialize() throws IOException {
        File file = new File("applicantinfo.bin");
        try{
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (true){
                ApplicantClass applicantinfo = (ApplicantClass) ois.readObject();
                applicantlist.add(applicantinfo);
            }
        } catch (EOFException eof){
            System.out.println("End of the file reached");
        } catch (ClassNotFoundException cnf){
            System.out.println("Class not found");
        }

    }

    ArrayList<ApplicantClass> applicantlist = new ArrayList<>();

    @javafx.fxml.FXML
    public void handlePrint(ActionEvent actionEvent) throws IOException{
        if (applicantIdField.getText().trim().isEmpty()){
            outputlabel.setText("Enter ID:");
            return;
        }
        if (fullNameField.getText().trim().isEmpty()){
            outputlabel.setText("Enter Full Name:");
            return;
        }
        if (applicationStatus.getText().trim().isEmpty()){
           outputlabel.setText("Enter Application Status:");
           return;
        }
        if (dateOfBirthField.getText().trim().isEmpty()){
            outputlabel.setText("Enter Date of Birth:");
            return;
        }
        if (visaTypeField.getText().trim().isEmpty()){
            outputlabel.setText("Enter Visa Type:");
            return;
        }
        if (phoneNumberField.getText().trim().isEmpty()){
            outputlabel.setText("Enter Phone Number:");
            return;
        }
        if (emailField.getText().trim().isEmpty()){
            outputlabel.setText("Enter Email:");
            return;
        }
        if (remarksArea.getText().trim().isEmpty()){
            outputlabel.setText("Enter Remarks Area:");
            return;
        }
        if (nationalityField.getText().trim().isEmpty()){
            outputlabel.setText("Enter Nationality:");
            return;
        }
        if (applicationIdField.getText().trim().isEmpty()){
            outputlabel.setText("Enter Application ID:");
            return;
        }


        String applicantId = applicantIdField.getText();
        String name = fullNameField.getText();
        String nationality = nationalityField.getText();
        String visaType = visaTypeField.getText();
        String email = emailField.getText();
        String applicationId = applicationIdField.getText();
        String remarks = remarksArea.getText();


        ApplicantClass CSA  = new ApplicantClass(applicantId, nationality, name, email, visaType, remarks, applicationId);
        applicantlist.add(CSA);
        outputlabel.setText("Printed");


        File file = new File("applicantinfo.bin");

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try{
            if (file.exists()){
                fos = new FileOutputStream(file,true);
                oos = new AppendableObjectOutputStream(oos);
            }else{
                fos = new FileOutputStream(file,true);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(CSA);
            oos.close();
        } catch (Exception e) {
            ///
        }
    }

    @javafx.fxml.FXML
    public void handleBackOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CustomerSupportAgency/CustomerSupportAgencyDashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            ///
        }
    }
}