
package TreatmentManage;

import java.time.LocalDate;

/**
 *
 * @author Bingnan Dong
 */
public class Appointment {
    private Integer appointmentID;
    private String patientID;
    private LocalDate appointmentDate;
    private String appointmentTime;
    private String doctorName;
    private String appointmentDepartment;
    private String status;
   
    /**
     * This creates an appointment for a patient
     * @param patientID  Set patient ID for the appointment
     * @param appointmentDepartment Set department for the appointment
     * @param doctorName Set doctor name for the appointment
     * @param appointmentDate Set apointment date for the appointment
     * @param appointmentTime Set appointment time for the appointment
     * @param status Set appointment status for appointment
   */ 

   public Appointment(String patientID, String appointmentDepartment,String doctorName,LocalDate appointmentDate, String appointmentTime, String status  ){
        this.patientID =patientID;
        this.appointmentDepartment=appointmentDepartment;
        this.doctorName =doctorName;
        this.appointmentDate  =appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status =status;  
   }
   
    /**
     * This creates an appointment for a patient
     * @param appointmentID Set appointment ID for the appointment
     * @param patientID  Set patient ID for the appointment
     * @param appointmentDepartment Set department for the appointment
     * @param doctorName Set doctor name for the appointment
     * @param appointmentDate Set apointment date for the appointment
     * @param appointmentTime Set appointment time for the appointment
     * @param status Set appointment status for appointment
   */ 
     public Appointment(Integer appointmentID,String patientID, String appointmentDepartment,String doctorName,LocalDate appointmentDate, String appointmentTime, String status  ){
        this.appointmentID = appointmentID;
        this.patientID =patientID;
        this.appointmentDepartment=appointmentDepartment;
        this.doctorName =doctorName;
        this.appointmentDate  =appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status =status;  
   }
  
   /**
     * Returns the appointment ID of an appointment
     * @return An Integer representing the appointment ID of an appointment
   */
    
    public Integer getAppointmentID(){
        return appointmentID;
    }   
    
    /**
     * Returns the patient ID of an appointment
     * @return A String representing the patient ID of an appointment
     */
    
    public String getPatientID(){
       return patientID;
    }
    
    /**
     * Returns the appointment date of an appointment
     * @return A LocalDate representing the appointment date of an appointment
     */
    
    public LocalDate getAppointmentDate(){
       return appointmentDate;
    } 
     /**
     * Returns the appointment time of an appointment
     * @return  A String representing the appointment time of an appointment
     */
    
    public String getAppointmentTime(){
     return appointmentTime;
    }
     /**
     * Returns the doctor name of an appointment
     * @return A String representing the doctor name of an appointment
     */
    
    public String getDoctorName(){
     return doctorName;
    }
    
   /**
     * Returns the appointment status of an appointment
     * @return  A String representing the appointment description of an appointment
   */
    public String getStatus(){
       return status;
    }

    /**
     * Returns the appointment department of an appointment
     * @return A String representing the appointment department of an appointment
     */
    
    public String getAppointmentDepartment(){
     return appointmentDepartment;
    } 
}
