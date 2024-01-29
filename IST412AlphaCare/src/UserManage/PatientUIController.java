
package UserManage;

import TreatmentManage.AppointmentHistoryViewController;
import TreatmentManage.CreateAppointmentController;
import TreatmentManage.PrescriptionHistoryPatientController;
import AlphaCare.Navigation;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 * @author Bingnan Dong
 */
public class PatientUIController implements Initializable {

    @FXML private Label  helloTxt;
    @FXML private Label Status;
    private  static User loginUser;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         helloTxt.setText("Hello, " +  loginUser.getUsername() +"   ");
    }  
    
    /**
     * Set the login user
     */
    public void userSet(User user){
        this.loginUser = user;
    }
     
    /**
     * Display user interface to login
    */
    public void  handleLogout(ActionEvent event) throws IOException{
        Navigation navigation = new  Navigation();
        navigation.handleLogout(event);
    }
    
    /**
     * Display user interface to create appointment
    */
    public void  handleCreateAppointment(ActionEvent event) throws IOException{
        CreateAppointmentController createAppointment  = new CreateAppointmentController();
        createAppointment.userSet(loginUser);
        Navigation navigation = new  Navigation();
        navigation.handleCreateAppointment(event);
    }
    
    /**
     * Display user interface to access appointment history
    */
    public void  handleAppointmentHistory(ActionEvent event) throws IOException{  
        AppointmentHistoryViewController AppointmentHistory  = new AppointmentHistoryViewController();
        AppointmentHistory.userSet(loginUser);
        Navigation navigation = new  Navigation();
        navigation.handleAppointmentHistory(event);
    }
   
    /**
    * Display user interface to update selected appointment
    */
    public void  handleUpdateAppointment(){
          Status.setText("Please display appointment history, then select updated appointment in the table");
    }
    
    /**
     * Display user interface to export appoinment
     */
    @FXML
    private void handleExportAppointment(ActionEvent event) throws IOException {
        Navigation navigation = new  Navigation();
        navigation.handleExportAppointment(event,loginUser.getUsername());
    }
    
   /**
     *  Display user interface to access the patient's prescription
    */
    @FXML
   private void handlePatientPrescription(ActionEvent event) throws IOException {
       PrescriptionHistoryPatientController PrescriptionHistoryPatient  = new  PrescriptionHistoryPatientController();
       PrescriptionHistoryPatient.userSet(loginUser);
       Navigation navigation = new  Navigation();
       navigation.handlePatientPrescription(event);
    }
}
