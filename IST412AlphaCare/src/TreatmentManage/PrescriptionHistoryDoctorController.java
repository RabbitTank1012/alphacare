
package TreatmentManage;

import DBManage.SqliteDB;
import DBManage.SqlitePrescription;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 * @author Group9
 */
public class PrescriptionHistoryDoctorController implements Initializable {
    
    @FXML private Button goBack;
    @FXML  private TableView<Prescription> table;
    @FXML private TableColumn prescriptionIDCol;
    @FXML private TableColumn symptomsCol;
    @FXML private TableColumn drugNameCol;
    @FXML private TableColumn drugUseCol;
    @FXML private TableColumn drugDaysCol;
    @FXML private TableColumn patientNameCol;
    @FXML private TableColumn dateCol;
    @FXML private Label  helloTxt;
    @FXML private Label Status;
    private static User loginUser;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
       helloTxt.setText(loginUser.getUsername() +"'s Prescription History ");
       ArrayList<Prescription> prescriptions =  new ArrayList<>();
       Connection conn =SqliteDB.getConnection();
       SqlitePrescription sqlite_prescription= new SqlitePrescription();
       prescriptions =sqlite_prescription.selectTable(conn,loginUser.getUsername(),"Doctor");
        
       ObservableList<Prescription> listPrescription = FXCollections.observableArrayList(prescriptions);
       prescriptionIDCol.setCellValueFactory(new PropertyValueFactory<Prescription,Integer >("prescriptionID"));
       symptomsCol.setCellValueFactory(new PropertyValueFactory<Prescription,String >("symptoms"));
       drugNameCol.setCellValueFactory(new PropertyValueFactory<Prescription,String >("drugName"));
       drugUseCol.setCellValueFactory(new PropertyValueFactory<Prescription,String >("drugUse"));
       drugDaysCol.setCellValueFactory(new PropertyValueFactory<Prescription,Integer >("drugDays"));
       patientNameCol.setCellValueFactory(new PropertyValueFactory<Prescription,String >("patientID"));
       dateCol.setCellValueFactory(new PropertyValueFactory<Prescription,LocalDate >("prescriptionDate"));
      
       table.setItems(listPrescription); 
    }    
    
   /**
     * Sets the username of login
     * @param user The the username of login
   */
    public void userSet(User user){
        this.loginUser =user;
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
    * Display user interface to display prescription history
    */
    public void  handlePrescriptionHistory(ActionEvent event) throws IOException{
    }
    
}
