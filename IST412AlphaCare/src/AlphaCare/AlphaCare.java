package AlphaCare;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Develop a role-based health care application called AlphaCare.
 * Through AlphaCare, patients can see and manage their own medical records.
 * Medical personnel can manage the medical records of their patients.
 * @author Bingnan Dong
 */
public class AlphaCare extends Application  {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
       
       Parent root = FXMLLoader.load(getClass().getResource("/UserManage/Login.fxml"));
    
       Scene scene = new Scene(root);
       primaryStage.setTitle("AlphaCare System");
       primaryStage.setScene(scene);
       primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
