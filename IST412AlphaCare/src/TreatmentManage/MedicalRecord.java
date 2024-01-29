
package TreatmentManage;

import UserManage.Doctor;
import UserManage.Patient;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Group9
 */
public class MedicalRecord {
    private String  recordID;
    private String  patientID;
    private Date    recordDate;
    private String  symptom;
    private String  allergyTest;
    private String  doctorName;
    private String  miscInfo;
    private String  prescriptionID;
    
    private Patient patient;
    private Doctor doctor;
    private Prescription prescription;
  
    /**
     * This creates a medical record for a patient
     * @param patientID Set the patient ID 
     * @param recordDate  Set the creating date
     * @param symptom Set the symptoms
     * @param allergyTest Set allergy test
     * @param doctorName Set doctor name 
     * @param prescriptionID Set the prescription ID 
     * @param miscInfo Set the misc information 
   */
    public MedicalRecord(String recordID,String patientID, Date recordDate, String symptom, String allergyTest, String doctorName, String prescriptionID, String miscInfo){
     this.recordID = recordID;
     this.patientID = patientID;
     this.recordDate = recordDate;
     this.symptom = symptom;
     this.allergyTest = allergyTest;
     this.doctorName = doctorName;
     this.prescriptionID = prescriptionID;
     this.miscInfo = miscInfo; 
    }

   
 /**
     * This creates a medical record for a patient
     * @param patientID Set patient ID for the medical record
     * @param recordDate  Set create date for the medical record
     * @param symptom set description for the medical record 
     * @param allergyTest set allergyTest for the medaical record
     * @param doctorName set doctor name for the medaical record
     * @param prescriptionID set  prescription ID for the medaical record
     * @param miscInfo set  misc information for the medaical record
   */
    
 /* public void CreateMedicalRecord(String patientID, Date recordDate, String symptom, String allergyTest, String doctorName, String prescriptionID, String miscInfo ){
        
     this.patientID = patientID;
     this.recordDate = recordDate;
     this.symptom = symptom;
     this.allergyTest = allergyTest;
     this.doctorName = doctorName;
     this.prescriptionID = prescriptionID;
     this.miscInfo = miscInfo;
     System.out.println(" create a mdical record in DB");
     
 }*/
    
  /**
     * Returns the patient's complete mdical history that matches the patientID provided.
     * @param patientID the patientID
     * @return An ArrayList of medical history for a patient
   */
    public static ArrayList<MedicalRecord> getMedicalHistory(String patientID){
        ArrayList<MedicalRecord> medicalrecord = new ArrayList<MedicalRecord>();
        System.out.println("Mdical record comes from DB");
        return medicalrecord;
    }
    
    public Patient getPatientInfo(String patientID){
        //patient info comes from DB
        return patient;
    }
    
    public Doctor getDoctorInfo(String doctorName){
        //patient info comes from DB
        return doctor;
    }
    
    public Prescription getPrescriptionInfo(String patientID,String doctorName){
        //prescription info comes from DB
        return prescription;
    }
    
     public String getrecordID(){
       return recordID;
    }
   
   /**
     * Returns the patient ID of a medical record
     * @return   A string representing the patient ID of a medical record
     */
    
    public String getpatientID(){
       return patientID;
    }
    
   /**
     * Returns the create date  of a medical record
     * @return  A date representing the create date  of a medical record
   */
    
    public Date getrecordDate(){
      return recordDate;
    }
    
  /**
   * Returns the misc information  of a medical record
   * @return  A string representing misc information  of a medical record
   */
   public String getmiscInfo(){
      
       return miscInfo;
    }
   
   
   /**
    * Returns the description  of a medical record
    * @return  A string representing the description  of a medical record
   */
   public String getSymptom(){
      return symptom;
    }
   
   
 /**
  * Returns the allergy test of a medical record
  * @return  A string representing the allergy test of a medical record
  */
   
  public String getallergyTest(){
     return allergyTest;
  }
   
  /**
   * Returns the doctor name of a medical record
   * @return  A string representing the doctor name of a medical record
   */
   
   public String getdoctorName(){
       return doctorName;
    }
    
   /**
     * Returns the prescription ID of a medical record
     * @return  A string representing the prescription ID of a medical record
   */
    public String getPrescriptionID(){
       return prescriptionID;
    }
  
}


