
package AlphaCare;

import DBManage.SqliteAppointment;
import DBManage.SqliteDB;
import TreatmentManage.Appointment;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * @author Bingnan Dong
 */
public class Navigation {
    
    /**
     * Display user interface to login
    */
    public void handleLogout(ActionEvent event) throws IOException{
        Parent loginParent = FXMLLoader.load(getClass().getResource("/UserManage/Login.fxml"));
        Scene loginScene = new Scene(loginParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Login");
        window.setScene(loginScene);
        window.show();
    }
    
    /**
     * Display user interface to create an  appointment 
     */
   public void handleCreateAppointment(ActionEvent event) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("/TreatmentManage/CreateAppointment.fxml"));
       Scene scene = new Scene(root);
       Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
       window.setTitle("CreateAppointment");
       window.setScene(scene);
       window.show();
    
    }
   
    /**
     * Display user interface to update appointment
     */
    public void handleUpdateAppointment(ActionEvent event) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("/TreatmentManage/UpdateAppointment.fxml"));
       Scene scene = new Scene(root);
       Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
       window.setTitle("UpdateAppointment");
       window.setScene(scene);
       window.show();
    }
  
   /**
     * Display user interface to access appointment history
     */  
  public void handleAppointmentHistory(ActionEvent event) throws IOException {
     Parent root = FXMLLoader.load(getClass().getResource("/TreatmentManage/AppointmentHistoryView.fxml"));
     Scene scene = new Scene(root);
     Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
     window.setTitle("AppointmentHistory");
     window.setScene(scene);
     window.show();
    }
    
    /**
     * Display user interface to export appoinment
    */
    public void handleExportAppointment(ActionEvent event, String username) throws IOException{
        String  content = "appointmentID," + "patientID,"  + "Department,"+"doctorName,"+ "Date,"+"Time," +"Status \n" ;
       
          //connect DataBase
         Connection conn =SqliteDB.getConnection();
         SqliteAppointment sqlite_appointment= new SqliteAppointment();
         
         ArrayList<Appointment> appointments = new ArrayList<>();
         appointments =  sqlite_appointment.selectTable(conn,username);
         for ( int i=0 ; i < appointments.size();i++){
             content =content +  appointments.get(i).getAppointmentID()+ ", "+ 
                         appointments.get(i).getPatientID() + ", "+ 
                         appointments.get(i).getAppointmentDepartment() + ", "+
                         appointments.get(i).getDoctorName() + ", "+
                         appointments.get(i).getAppointmentDate() + ","+
                         appointments.get(i).getAppointmentTime() + ","+
                         appointments.get(i).getStatus()  +"\r\n";
         }
       
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show save file dialog
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        File file = fileChooser.showSaveDialog(window);
       
    }
    /**
     * Export appointment information to a file
    */
    private void SaveFile(String content, File file) {
        try {
            FileWriter fileWriter = null;
            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            //   Logger.getLogger(JavaFX_Text.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
     /**
     * Display user interface to create prescription 
     */
       public void  handleCreatePrescription(ActionEvent event) throws IOException{
      
        Parent Parent = FXMLLoader.load(getClass().getResource("/TreatmentManage/CreatePrescription.fxml"));
        Scene  Scene = new Scene(Parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(Scene);
        window.setTitle("CreatePrescription");
        window.show();
    }
       
       
    /**
     * Display one patient's prescription history
    */
    public void  handlePatientPrescription(ActionEvent event) throws IOException{
      
        Parent Parent = FXMLLoader.load(getClass().getResource("/TreatmentManage/PrescriptionHistoryPatient.fxml"));
        Scene  Scene = new Scene(Parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(Scene);
        window.setTitle("PatientPrescription");
        window.show();
    }
       
    /**
     * Display one doctor's prescription history
    */
    public void  handleDoctorPrescription(ActionEvent event) throws IOException{
      
        Parent Parent = FXMLLoader.load(getClass().getResource("/TreatmentManage/PrescriptionHistoryDoctor.fxml"));
        Scene  Scene = new Scene(Parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(Scene);
        window.setTitle("DoctorPrescription");
        window.show();
    }
           
}
