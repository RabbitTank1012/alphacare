package UserManage;

import TreatmentManage.Appointment;
import TreatmentManage.MedicalRecord;
import TreatmentManage.Prescription;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Bingnan Dong
 */
public class Patient extends User {

    private ArrayList<Appointment> appointments;
    private ArrayList<MedicalRecord> medicalData;
    private ArrayList<Prescription> prescriptions;
  
    /**
     * This is the constructor for the Patient class
     * @param firstName Set the first name
     * @param lastName  Set the last name
     * @param username  Set the username
     * @param emailaddress Set the email address
     * @param  password Set the password
     * @param  type Set the type
   */ 
   public Patient(String firstName, String lastName, String username, String emailaddress, String password, LocalDate dateBirth,String type){
        super(firstName, lastName, username, emailaddress, password, dateBirth,type  );
    }
   
   /**
     * Returns a apointment list of the patient
     * @return a apointment list of the patient
   */
   public ArrayList<Appointment> getApointment(String username){
        return appointments;
    }
   
   /**
     * Returns a medicaldata list of the patient
     * @return a apointment list of the patient
   */
   public ArrayList<MedicalRecord> getMedicaldata(String username){
        return medicalData;
    }
   
   /**
     * Returns a prescription list of the patient
     * @return a prescription  list of the patient
    */
    public ArrayList<Prescription> getPrescription(String username){
        return prescriptions;
    }
   
   /**
     * Sets a appointment list of a patient
     * @param appointments a prescription list of a patient 
   */
   public void setAppointment(ArrayList<Appointment> appointments)
   {
       this.appointments = appointments;
   }
}

