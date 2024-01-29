
package UserManage;

import TreatmentManage.Prescription;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Bingnan Dong
 */
public class Doctor extends User {
     
    private ArrayList<Patient> myPatientList = new ArrayList<Patient>();
    private ArrayList<Prescription> myPrescription = new ArrayList<Prescription>();
    
    /**
     * This is the constructor for the Doctor class
     * @param firstName Set the first name
     * @param lastName  Set the last name
     * @param username  Set the username
     * @param emailaddress Set the email address
     * @param  password Set the password
     * @param  type Set the type
   */
    
   public Doctor(String firstName, String lastName, String username, String emailaddress, String password, LocalDate dateBirth,String type  ){
       super(firstName, lastName, username, emailaddress, password,dateBirth, type  );
    }
    
    /**
     * Returns a patient list of the doctor
     * @return  A patient list of the doctor 
     */
    public ArrayList<Patient> getMyPatientList(){
        return myPatientList;
    }
    
   /**
     * Sets a patient list of the doctor
     * @param PatientList a patient list of the doctor  
    */
    public void setMyPatientList(ArrayList<Patient> PatientList){
        myPatientList = PatientList;
    }  
    
   /**
     * Returns a prescription list of the doctor
     * @return a prescription list of the doctor
    */
    public ArrayList<Prescription> getMyPrescription(){
        return myPrescription;
    }
   
   /**
     * Sets a prescription list of the doctor
     * @param myPrescription a prescription list of the doctor 
    */ 
    public void setMyPrescription(ArrayList<Prescription>  myPrescription){
        this.myPrescription =myPrescription;
    }  
}

