
package UserManage;
import TreatmentManage.CreatePrescriptionController;
import TreatmentManage.PrescriptionHistoryDoctorController;
import AlphaCare.Navigation;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 * @author Bingnan Dong
 */
public class DoctorUIController implements Initializable {
    @FXML private Button goBack;
    @FXML private Label  helloTxt;
    @FXML private Label Status;
    private static User loginUser;
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
     * Display user interface to create prescription 
    */
    public void  handleCreatePrescription(ActionEvent event) throws IOException{
         // Status.setText("We'll implement this case later");
        CreatePrescriptionController createAppointment  = new CreatePrescriptionController();
        createAppointment.userSet(loginUser);
        Navigation navigation = new  Navigation();
        navigation.handleCreatePrescription(event); 
    }
    
   /**
     * Display user interface to update prescription 
    */
    public void  handleUpdatePrescription(ActionEvent event) throws IOException{
          Status.setText("We'll implement this case later");
    }
    
    /**
     *  Display user interface to access the doctor's prescription
    */
    public void  handlePrescriptionHistory(ActionEvent event) throws IOException{
        PrescriptionHistoryDoctorController PrescriptionDoctor  = new  PrescriptionHistoryDoctorController();
        PrescriptionDoctor.userSet(loginUser);
        Navigation navigation = new  Navigation();
        navigation.handleDoctorPrescription(event);
    }
}
