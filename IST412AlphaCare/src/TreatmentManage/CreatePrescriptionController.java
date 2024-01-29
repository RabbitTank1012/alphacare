
package TreatmentManage;

import DBManage.SqliteDB;
import DBManage.SqlitePrescription;
import DBManage.SqliteUser;
import UserManage.User;
import AlphaCare.Navigation;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Group9
 */
public class CreatePrescriptionController implements Initializable {

    @FXML private Button goBack;
    @FXML private Label  helloTxt;
    @FXML private Label Status;
    
   
    @FXML private ChoiceBox<String> patientChoice;
    @FXML private TextField symptomsField;
    @FXML private ChoiceBox<String> drugNameChoice;
    @FXML private ChoiceBox<String> drugUseChoice;
    @FXML private ChoiceBox<Integer> drugDaysChoice;
    @FXML private DatePicker PrescriptionDatePicker;
    
   
    private static User loginUser;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        helloTxt.setText( loginUser.getUsername() + " creates prescription for patient:" );
        ObservableList<String> list;
        
         Connection conn =SqliteDB.getConnection();
         SqliteUser sqlite_user= new SqliteUser(); 
         ArrayList<String> patientName = sqlite_user.getPatientName(conn);
         list = FXCollections.observableArrayList(patientName);
         patientChoice.setItems(list);
        
        String[] drugName = {"Penicillin","Sulfa","Cipro","Macrobid","Codeine","Morphine","Demerol"};
        list = FXCollections.observableArrayList(drugName);
        drugNameChoice.setItems(list);
        
        String[] drugUse = {"once a day", "twice a day","three times a day"};
        list = FXCollections.observableArrayList(drugUse);
        drugUseChoice.setItems(list);
         
        ObservableList<Integer> list2;
        Integer[] status = {1,3,5,7,14,30};
        list2 = FXCollections.observableArrayList(status);
        drugDaysChoice.setItems(list2);
    }    
    
    /**
     * Set the login user
     */
    public void userSet(User user){
        this.loginUser = user;
    }
    
   /**
    * Check all input fields and store prescription in the database
   */
   @FXML
    private void handleSubmit(ActionEvent event) throws IOException {
      
        
        String patientName = patientChoice.getValue();
        String symptoms = symptomsField.getText();;
        String drugName = drugNameChoice.getValue();
        String drugUse =drugUseChoice.getValue();
        Integer drugDays = drugDaysChoice.getValue();
        LocalDate date =  PrescriptionDatePicker.getValue();
        
        if(!checkPrescriptionInput())
            return;
      
      //insert prescription data in DB
       Prescription prescription = new Prescription( patientName,symptoms,drugName,drugUse,drugDays,loginUser.getUsername(), date);
       insertPrescriptionInDB(prescription);
        
       Status.setText("Prescription has saved in DB"); 
    }
    
     /**
     * Returns whether all inputs for creating prescription are correct
     * @return  A Boolean representing whether all inputs for creating prescription are correct
     */
    public Boolean checkPrescriptionInput(){
        
        String patientName = patientChoice.getValue();
        String symptoms = symptomsField.getText();;
        String drugName = drugNameChoice.getValue();
        String drugUse =drugUseChoice.getValue();
        Integer drugDays = drugDaysChoice.getValue();
        LocalDate date =  PrescriptionDatePicker.getValue();
        
        Boolean check =false;
       
        if(patientName == null){
            Status.setText("P atient name can not be null.");
            return check;
        }
        
        if(symptoms == null){
            Status.setText("Symptoms can not be null.");
             return check;
        }
       
        if (drugName == null){
         Status.setText("Drug name can not be null.");
            return check;
        }
        
        if(drugUse == null){
            Status.setText("Drug use  can not be null.");
             return check;
        }
        
        if(drugDays == null){
            Status.setText("Drug days can not be null.");
            return check;
        }
        
        if(date == null){
            Status.setText("Prescription date can not be null.");
            return check;
        }
        
        check =true;
        return check;
  
    }
   /**
     * Insert a new prescription in the database
     * @param prescription Prescription information inserted in the database
    */ 
    public void insertPrescriptionInDB(Prescription  prescription ){
      
          //connect DataBase
         Connection conn =SqliteDB.getConnection();
         SqlitePrescription  sqlite_prescription= new SqlitePrescription ();
       
         // if not exists user table, create it
         sqlite_prescription.createTable(conn);
         sqlite_prescription.insertTable(conn, prescription);
         
           //access Prescription data from DB
         ArrayList<Prescription>  prescriptions = new ArrayList<>();
         prescriptions =  sqlite_prescription.selectTable(conn,loginUser.getUsername(),"Doctor");
         for (int i=0; i < prescriptions.size();i++){
             System.out.println( "The infromation of  prescriptions "+(i+1) +";" );
             System.out.println( "prescriptionID: " +   prescriptions.get(i).getPrescriptionID() );
             System.out.println( "PatientID: " +   prescriptions.get(i).getPatientID() );
             System.out.println( "Symptoms: " +  prescriptions.get(i).getSymptoms() );
             System.out.println( "drugName: " +    prescriptions.get(i).getDrugName() );
             System.out.println( "drugUse: " +  prescriptions.get(i).getDrugUse() );
             System.out.println( "drugDays: " +  prescriptions.get(i).getDrugDays() );
             System.out.println( "DoctorName: " +  prescriptions.get(i).getDoctorName());
             System.out.println( "PrescriptionDate: " +  prescriptions.get(i).getPrescriptionDate());
             System.out.println();
         }
      
     }
    
    /**
     * Clear all input feilds for creating a new prescription
     */
    @FXML
    private void handleCancel(ActionEvent event) throws IOException {
      patientChoice.setValue(null);
      symptomsField.setText(null);
      drugNameChoice.setValue(null);
      drugUseChoice.setValue(null);
      drugDaysChoice.setValue(null);
      PrescriptionDatePicker.setValue(null);
    }
    
   /**
     * Display user interface to login
   */
   public void  handleLogout(ActionEvent event) throws IOException{
       Navigation navigation = new  Navigation();
       navigation.handleLogout(event);
     
    }
    
   /**
    * Display user interface to create prescription 
   */
    public void  handleCreatePrescription(ActionEvent event) throws IOException{
        patientChoice.setValue(null);
        symptomsField.setText(null);
        drugNameChoice.setValue(null);
        drugUseChoice.setValue(null);
        drugDaysChoice.setValue(null);
        PrescriptionDatePicker.setValue(null);
      
    }
    
   /**
    * Display user interface to update prescription 
   */
    public void  handleUpdatePrescription(ActionEvent event) throws IOException{
          Status.setText("We'll implement this case later");
    }
    
    
   /**
     * Display user interface to display prescription history
     */
    public void  handlePrescriptionHistory(ActionEvent event) throws IOException{
        PrescriptionHistoryDoctorController PrescriptionDoctor  = new  PrescriptionHistoryDoctorController();
        PrescriptionDoctor.userSet(loginUser);
        Navigation navigation = new  Navigation();
        navigation.handleDoctorPrescription(event);
    }
}

