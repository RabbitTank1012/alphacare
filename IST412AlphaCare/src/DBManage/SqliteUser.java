
package DBManage;

import UserManage.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
/**
 * @author Bingnan Dong
 */
public class SqliteUser extends SqliteDB {
    
    private ArrayList<User> user = new ArrayList<>();
    
     /**
     * Create Table User
     */
    public  void createTable(Connection conn){
       String sql = "CREATE TABLE IF NOT EXISTS User " +
                   " (FirstName     CHAR(30)    NOT NULL, " + 
                   " LastName       CHAR(30)    NOT NULL, " + 
                   " Username       CHAR(30)    NOT NULL, " + 
                   " Password       CHAR(50), " + 
                   " Emailaddress   CHAR(60), " +
                   " birthDate      text, " +
                   " UserType       CHAR(20))";
       try (
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            stmt.close();
            System.out.println("Table created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
     /**
     * Insert a new user in the database
     * @param conn The connection of the database
     * @param user The user information inserted in the database
     */
    public  void insertTable(Connection conn,User user){
         
        try (
            Statement stmt = conn.createStatement()) {
           
           String sql = "INSERT INTO User (FirstName,LastName,Username,Password,Emailaddress,birthDate,UserType) " +
                   "VALUES (+"
                     + "'" + user.getFirstName() + "', " 
                     + "'" + user.getLastName() + "', " 
                     + "'" + user.getUsername() + "', "
                     + "'" + user.getPassword() + "', "
                     + "'" + user.getEmailaddress() + "', "
                     + "'" + user.getDateOfBirth().toString() + "', "
                     + "'" + user.getUserType() + "'); ";
                
            stmt.execute(sql);
             
            stmt.close();
            System.out.println("Table inserted successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
     }
     
     /**
     * Returns all users in the database    
     * @param conn The connection of the database
     * @return An Arraylist representing all users in the database
     */
     public ArrayList<User> selectTable(Connection conn)  {
           
           ArrayList<User> user = new ArrayList<>();
           try (
            Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery( "SELECT * FROM User;" );
            DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
            while ( rs.next() ) {
             String  FirstName = rs.getString("FirstName");
             String  LastName = rs.getString("LastName");
             String  Username = rs.getString("Username");
             String  Password = rs.getString("Password");
             String  Emailaddress = rs.getString("Emailaddress");
             String  UserType = rs.getString("UserType");
             String  dateBirth = rs.getString("birthDate");
             
             user.add(new User(FirstName,LastName,Username,Emailaddress,Password,LocalDate.parse(dateBirth, DateTimeFormatter.ISO_DATE),UserType));
           }
            rs.close();
            stmt.close();
            System.out.println("Table selected successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;  
      }
     
      /**
     * Returns whether a user existed in the database    
     * @param conn  The connection of the database    
     * @param username The specified username
     * @return A Boolean representing whether a user existed in the database
     */
     
      public  Boolean selectTableByUsername(Connection conn, String username){
           Boolean userExist = false;
           ResultSet rs =null;
           ArrayList<User> user = new ArrayList<>();
           try (
            Statement stmt = conn.createStatement()) {
             rs = stmt.executeQuery( "SELECT * FROM User where Username =" + "'" + username + "';" );
           if(rs.next()){
             userExist= true;
           }
           else{
             userExist= false;
           }
            rs.close();
            stmt.close();
          
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userExist;  
      }
      
     /**
     * Returns the user information existed in the database
     * @param conn The connection of the database
     * @param username The specified username
     * @param password  The password of the specified user
     * @return the user information existed in the database
     */
      public  User loginCheck(Connection conn, String username,String password) {
           User user=null;
           ResultSet rs =null;
         
           try (
            Statement stmt = conn.createStatement()) {
           
             rs = stmt.executeQuery( "SELECT * FROM User where Username =" + "'" + username + 
                                                               "' AND Password =" + "'" + password  +"';" );
             DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
            if(rs.next()){
              
             String  FirstName = rs.getString("FirstName");
             String  LastName = rs.getString("LastName");
             String  Username = rs.getString("Username");
             String  Password = rs.getString("Password");
             String  Emailaddress = rs.getString("Emailaddress");
             String  dateBirth = rs.getString("birthDate");
             String  UserType = rs.getString("UserType");
             user = new User(FirstName,LastName,Username,Emailaddress,Password,LocalDate.parse(dateBirth, DateTimeFormatter.ISO_DATE),UserType);   
           }
           
            rs.close();
            stmt.close();
          
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;  
      }
      
      
    /**
     * Returns all patients' username
     * @param conn  The connection of the database
     * @return An Arraylist representing all patients' username
     */
     public ArrayList<String> getPatientName(Connection conn)  {
           
           ArrayList<String> patientUsername = new ArrayList<>();
           try (
            Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery( "SELECT * FROM User where UserType =" + "'Patient';" );
            while ( rs.next() ) {
             String  patientID = rs.getString("Username");
             patientUsername.add(patientID);
           }
            rs.close();
            stmt.close();
         
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return  patientUsername;  
      }
     
     /**
     * Returns all doctors' username
     * @param conn  The connection of the database
     * @return An Arraylist representing all doctors' username
     */
     public ArrayList<String> getDoctorName(Connection conn)  {
           
           ArrayList<String> doctorUsername = new ArrayList<>();
           try (
            Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery( "SELECT * FROM User where UserType =" + "'Doctor';" );
            while ( rs.next() ) {
             String  patientID = rs.getString("Username");
             doctorUsername.add(patientID);
           }
            rs.close();
            stmt.close();
         
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return doctorUsername;  
      }
   
}


