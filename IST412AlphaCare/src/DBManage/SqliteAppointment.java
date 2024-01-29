package DBManage;

import TreatmentManage.Appointment;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * @author Bingnan Dong
 */
public class SqliteAppointment extends SqliteDB {
    
    ArrayList<Appointment> appointment = new ArrayList<>();
    
     /**
     * Create Table Appointment
     */
     public  void createTable(Connection conn){
     
        String sql = "CREATE TABLE IF NOT EXISTS Appointment ("
                + "appointmentID integer PRIMARY KEY AUTOINCREMENT, "
                + "patientID text,"
                + "appointmentDate text," // Date format
                + "appointmentTime text, " 
                + "doctorName text,"
                + "appointmentDepartment text,"
                + "status text);";
       try (
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            stmt.close();
            System.out.println("Table Appointment created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
     /**
     * Insert a new appointment in the database
     * @param conn The connection of the database
     * @param appointment Appointment information inserted in the database
     */
    public  void insertTable(Connection conn,Appointment appointment){
         
        try (
            Statement stmt = conn.createStatement()) {
           
           String sql = "INSERT INTO Appointment (patientID,appointmentDate,appointmentTime,doctorName,appointmentDepartment,status) " +
                   "VALUES (+"
                     + "'" + appointment.getPatientID() + "', " 
                     + "'" + appointment.getAppointmentDate().toString() + "', " 
                     + "'" + appointment.getAppointmentTime() + "', "
                     + "'" + appointment.getDoctorName() + "', "
                     + "'" + appointment.getAppointmentDepartment() + "', "
                      + "'" +appointment.getStatus() + "'); ";
            stmt.execute(sql);
            stmt.close();
            System.out.println("Table Appointment inserted successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }        
     }
    
     /**
     * Update an appointment in the database
     * @param conn  The connection of the database
     * @param appointment Appointment information updated the database
     */
    public  void updateTable(Connection conn,Appointment appointment){    
        try (
            Statement stmt = conn.createStatement()) {
           
            String sql = "UPDATE Appointment SET "
                        + "patientID='" + appointment.getPatientID() + "', "
                        + "appointmentDate='" + appointment.getAppointmentDate().toString() + "',"
                        + "appointmentTime='" + appointment.getAppointmentTime() + "', "
                        + "doctorName='" +  appointment.getDoctorName() + "', "
                        + "appointmentDepartment='" +appointment.getAppointmentDepartment() + "',"
                        + "status='" + appointment.getStatus() + "' "
                        + " WHERE appointmentID=" + appointment.getAppointmentID();
            stmt.execute(sql);
            stmt.close();
            System.out.println("Table Appointment updated successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }        
     }
      
     /**
     * Returns the specified user's appointments
     * @param conn  The connection of the database
     * @param username The specified username
     * @return An Arraylist representing the specified user's appointments
     */
     public ArrayList<Appointment> selectTable(Connection conn, String username)  {
           
           ArrayList<Appointment> appointment = new ArrayList<>();
           try (
            Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery( "SELECT * FROM Appointment where patientID =" + "'" + username + "';" );
            while ( rs.next() ) {
            Integer appointmentID =  rs.getInt("appointmentID");
             String  patientID = rs.getString("patientID");
             String  appointmentDate = rs.getString("appointmentDate");
             String  appointmentTime = rs.getString("appointmentTime");
             String  doctorName = rs.getString("doctorName");
             String  appointmentDepartment = rs.getString("appointmentDepartment");
             String  status = rs.getString("status");
             appointment.add(new Appointment(appointmentID,patientID, appointmentDepartment,doctorName,LocalDate.parse(appointmentDate, DateTimeFormatter.ISO_DATE),appointmentTime, status));
           }
            rs.close();
            stmt.close();
            System.out.println("Table Appointment selected successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return  appointment;  
      }
   
}