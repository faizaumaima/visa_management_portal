package com.example.ms3_group47_evisa.ApplicationIntakeOfficer;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.ArrayList;

public class ApplicationController
{
    @javafx.fxml.FXML
    private TextField TravelPurposeTextfield;
    @javafx.fxml.FXML
    private TextField nationalityTextfield;
    @javafx.fxml.FXML
    private TextField applicationIdTextField;
    @javafx.fxml.FXML
    private TextField nametextfield;
    @javafx.fxml.FXML
    private Label outputlabel;
    @javafx.fxml.FXML
    private TextField emailTextfield;
    @javafx.fxml.FXML
    private TextField visatypeTextfield;

    @javafx.fxml.FXML
    public void initialize() throws IOException {
        File file = new File("applications.bin");
        try{
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (true){
                ApplicationClass applications = (ApplicationClass) ois.readObject();
                applicationlist.add(applications);
            }
        } catch (EOFException eof){
            System.out.println("End of the file reached");
        } catch (ClassNotFoundException cnf){
            System.out.println("Class not found");
        }

    }




    ArrayList<ApplicationClass> applicationlist = new ArrayList<>();

    @javafx.fxml.FXML
    public void submitOnaction(ActionEvent actionEvent) throws IOException{
        if (applicationIdTextField.getText().trim().isEmpty()){
            outputlabel.setText("Enter ID");
            return;
        }
        if (nametextfield.getText().trim().isEmpty()){
            outputlabel.setText("Enter Name");
            return;
        }
        if (emailTextfield.getText().trim().isEmpty()){
            outputlabel.setText("Enter email");
            return;
        }
        if (nationalityTextfield.getText().trim().isEmpty()){
            outputlabel.setText("Enter Nationality");
            return;
        }
        if (TravelPurposeTextfield.getText().trim().isEmpty()){
            outputlabel.setText("Enter Travel Purpose");
            return;
        }
        if (visatypeTextfield.getText().trim().isEmpty()){
            outputlabel.setText("Enter visa type");
            return;
        }

        String applicationId = applicationIdTextField.getText();
        String name = nametextfield.getText();
        String email = emailTextfield.getText();
        String nationality = nationalityTextfield.getText();
        String travelpurpose = TravelPurposeTextfield.getText();
        String visatype = visatypeTextfield.getText();


        ApplicationClass AI = new ApplicationClass(applicationId, name, nationality, email, travelpurpose,visatype);
        applicationlist.add(AI);
        outputlabel.setText("Submitted");

        File file = new File("applications.bin");

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try{
            if (file.exists()){
                fos = new FileOutputStream(file,true);
                oos = new AppendableObjectOutputStream(fos);
            }else{
                fos = new FileOutputStream(file,true);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(AI);
            oos.close();
        } catch (Exception e) {
            ///
        }


    }


}