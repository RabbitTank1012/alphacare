
package TreatmentManage;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Group9
 */
public class Prescription {
    private Integer prescriptionID;
    private String patientID;
    private String symptoms;
    private String drugName;
    private String drugUse;
    private Integer drugDays;
    private String doctorName;
    private LocalDate prescriptionDate;
    private ArrayList<Drug> drug;
    
    /**
     * This creates a prescription for the patient
     * @param prescriptionID Set the prescription ID 
     * @param patientID  Set the patient ID 
     * @param symptoms  Set the patient's symptoms
     * @param drugName Set the drug name
     * @param drugUse Set the drug use
     * @param drugDays Set rhe drug days
     * @param doctorName Set the doctor name
     * @param prescriptionDate Set the date for the prescription
   */ 
    public Prescription(Integer prescriptionID, String patientID, String symptoms,String drugName, String drugUse,Integer drugDays,String doctorName,LocalDate prescriptionDate){
        this.prescriptionID = prescriptionID;
        this.patientID = patientID;
        this.symptoms =symptoms;
        this.drugName = drugName;
        this.drugUse = drugUse;
        this.drugDays =drugDays;
        this.doctorName =doctorName;
        this.prescriptionDate = prescriptionDate;
    }
    
    
   /**
     * This creates a prescription for a patient
     * @param patientID  Set the patient ID 
     * @param symptoms  Set the patient's symptoms
     * @param drugName Set the drug name
     * @param drugUse Set the drug use
     * @param drugDays Set rhe drug days
     * @param doctorName Set the doctor name
     * @param prescriptionDate Set the date for the prescription
   */ 
    
     public Prescription(String patientID, String symptoms,String drugName, String drugUse,Integer drugDays,String doctorName,LocalDate prescriptionDate){
        this.prescriptionID = prescriptionID;
        this.patientID = patientID;
        this.symptoms =symptoms;
        this.drugName = drugName;
        this.drugUse = drugUse;
        this.drugDays =drugDays;
        this.doctorName =doctorName;
        this.prescriptionDate = prescriptionDate;
    }
    
   /**
    * Returns the prescription ID of a prescription
    * @return  A Integer representing the prescription ID of a prescription
   */
    
    public Integer getPrescriptionID(){
       return prescriptionID;
    }
    
   /**
     * Returns the patient's symptoms of a prescription
     * @return  A string representing the patient's symptoms of a prescription
   */
    
   public String getSymptoms(){
     return symptoms;
    }
   
    
   /**
    * Returns the patient ID of a prescription
    * @return  A string representing the patient ID of a prescription
   */
    public String getPatientID(){
       return patientID;
    }
    
  /**
   * Returns the order date of a prescription
   * @return  A date representing the order date of a prescription
   */
    public LocalDate getPrescriptionDate(){
       return prescriptionDate;
    }
    
   /**
     * Returns doctor name of a prescription
     * @return  A string  representing the doctor name of a prescription
     */
    public String getDoctorName(){
      return doctorName;
    }
    
   /**
     * Returns drug name of a prescription
     * @return  A string  representing the drug name of a prescription
   */
    public String getDrugName(){
     return drugName;
    }
     
   /**
     * Returns drug use of a prescription
     * @return  A string  representing the drug use of a prescription
   */
    public String getDrugUse(){
       return drugUse;
    }
   
   /**
     * Returns drug days of a prescription
     * @return  A Integer  representing the drug days of a prescription
   */
    public Integer getDrugDays(){
       return drugDays;
    }
}

