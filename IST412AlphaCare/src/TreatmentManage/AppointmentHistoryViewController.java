
package TreatmentManage;

import DBManage.SqliteAppointment;
import DBManage.SqliteDB;
import UserManage.User;
import AlphaCare.Navigation;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 * @author Bingnan Dong
 */
public class AppointmentHistoryViewController implements Initializable {
    
    @FXML  private TableView<Appointment> table;
    @FXML private TableColumn IDCol;
    @FXML private TableColumn dateCol;
    @FXML private TableColumn timeCol;
    @FXML private TableColumn doctorCol;
    @FXML private TableColumn departmentCol;
    @FXML private TableColumn statusCol;
    @FXML private Label  helloTxt;
    @FXML private Label Status;
    private static User loginUser;
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<Appointment> appointments =  new ArrayList<>();
        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        
        helloTxt.setText(loginUser.getUsername() +"'s Appointment History ");
        Connection conn =SqliteDB.getConnection();
        SqliteAppointment sqlite_appointment= new SqliteAppointment();
        appointments =sqlite_appointment.selectTable(conn,loginUser.getUsername());
  
        ObservableList<Appointment> listAppointment = FXCollections.observableArrayList(appointments);
        IDCol.setCellValueFactory(new PropertyValueFactory<Appointment,Integer >("appointmentID"));
        dateCol.setCellValueFactory(new PropertyValueFactory<Appointment,LocalDate >("appointmentDate"));
       
        timeCol.setCellValueFactory(new PropertyValueFactory<Appointment,String >("appointmentTime"));
        doctorCol.setCellValueFactory(new PropertyValueFactory<Appointment,String >("doctorName"));
        statusCol.setCellValueFactory(new PropertyValueFactory<Appointment,String >("Status"));
        departmentCol.setCellValueFactory(new PropertyValueFactory<Appointment,String >("appointmentDepartment"));
        table.setItems(listAppointment); 
    }    
    
     /**
     * Sets the username of login
     * @param user the the username of login
     */
    public void userSet(User user){
        this.loginUser =user;
    }
   
    /**
     * Return to login user interface
     */
    @FXML
    private void handleLogout(ActionEvent event) throws IOException {
        Navigation navigation = new  Navigation();
        navigation.handleLogout(event);
    }

    /**
     * Display user interface to create appointment
     */
    @FXML
    private void handleCreateAppointment(ActionEvent event) throws IOException {
     
        CreateAppointmentController createAppointment  = new CreateAppointmentController();
        createAppointment.userSet(loginUser);
        Navigation navigation = new  Navigation();
        navigation.handleCreateAppointment(event);
    }
    
    /**
     * Display user interface to update appointment
    */
    @FXML
    private void handleUpdateAppointment(ActionEvent event) throws IOException {
        Appointment appointment = table.getSelectionModel().getSelectedItem();
        if (appointment == null){
           Status.setText("Please select the updated appointment in the table");
            return;
        }
        UpdateAppointmentController updateAppointment  = new UpdateAppointmentController();
        updateAppointment.userSet(loginUser);
        updateAppointment.apppointmentSet(appointment);
        Navigation navigation = new  Navigation();
        navigation.handleUpdateAppointment(event);
    }

   /**
     * Display user interface to access appointment history
   */
    @FXML
    private void handleAppointmentHistory(ActionEvent event) throws IOException { 
        
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
     * Display user interface to patient's prescription
   */
    @FXML
   private void handlePatientPrescription(ActionEvent event) throws IOException {
       PrescriptionHistoryPatientController PrescriptionHistoryPatient  = new  PrescriptionHistoryPatientController();
       PrescriptionHistoryPatient.userSet(loginUser);
       Navigation navigation = new  Navigation();
       navigation.handlePatientPrescription(event);
    }
}
