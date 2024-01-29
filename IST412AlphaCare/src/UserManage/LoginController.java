
package UserManage;

import DBManage.SqliteDB;
import DBManage.SqliteUser;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 * @author Group9
 */
public class LoginController implements Initializable {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Button createAccountButton;
    @FXML private Button loginButton;
    @FXML private Label errorLabel;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        usernameField.setText("bvd1234");
        passwordField.setText("bvd1234");
    }    
    
    /**
     * Check login user in DB
    */
    public void LoginCheck(ActionEvent event){
          
        String username = usernameField.getText();
        String password = passwordField.getText();
       
        Connection conn =SqliteDB.getConnection();
        SqliteUser sqlite_user= new SqliteUser();
        User user =sqlite_user.loginCheck(conn, username, password);
        if (user == null ){
           errorLabel.setText("Invalid credentials, please try again or create account");  
        }
        else { 
             Dashboard(user);
        }
    }
      
  
   /**
    * Display user interface to create account
   */
    public void CreateAccount() {
        
        Stage mainStage = (Stage) createAccountButton.getScene().getWindow();
        Parent root;
        Scene scene;
        try {
            root = FXMLLoader.load(getClass().getResource("CreateAccountUI.fxml"));
            scene = new Scene(root);
            mainStage.setTitle("CreateAccount");
            mainStage.setScene(scene);
            mainStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
   /**
    * Accroding to user type to display PatientDashboard or DoctorDashboard
    */
    public void Dashboard(User user){
        Stage mainStage = (Stage) loginButton.getScene().getWindow();
        Parent root;
        Scene scene;
        try {
            if(user.getUserType().equalsIgnoreCase("patient")){
               PatientUIController patientController  = new PatientUIController();
               patientController.userSet(user);
               root = FXMLLoader.load(getClass().getResource("PatientUI.fxml"));
               mainStage.setTitle("PatientDashboard");
            }
            else{
                DoctorUIController doctorController  = new DoctorUIController();
                doctorController.userSet(user);
                root = FXMLLoader.load(getClass().getResource("DoctorUI.fxml"));
                mainStage.setTitle("DoctorDashboard");
            }
            scene = new Scene(root);
            mainStage.setScene(scene);
            mainStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     /**
     * Return to login user interface
     */
     public  void handleLogoutAction(ActionEvent event) throws IOException {
        // TODO
        Parent Parent = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene Scene = new Scene(Parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(Scene);
        window.setTitle("Login");
        window.show();
    }    
}