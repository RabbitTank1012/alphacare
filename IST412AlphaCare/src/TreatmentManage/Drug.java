package TreatmentManage;

/**
 *
 * @author group9
 */
public class Drug {
    private String drugID;
    private String drugName;
    private int drugDosage;
    private String drugForm;
    private String drugInstructions;
    private String sideEffects;
    private String manufacturer;
    
    /**
     * This creates a drug for the prescription
     * @param drugID  Set  the drug ID 
     * @param drugName Set the drug name 
     * @param drugDosage Set the drug dosage
     * @param drugForm  Set the drug form 
     * @param drugInstructions Set the drug instruction
     * @param sideEffects Set the drug effects  
     * @param manufacturer Set the drug manufacturer
   */ 
    
    public Drug(String drugID, String drugName, int drugDosage, String drugForm, String drugInstructions, String sideEffects, String manufacturer   ){
        this.drugID = drugID ;
        this.drugName = drugName;
        this.drugDosage = drugDosage;
        this.drugForm = drugForm;
        this.drugInstructions =drugInstructions;
        this.sideEffects =  sideEffects;
        this.manufacturer = manufacturer;
        
    }
    
   /**
     * Returns  Drug ID  
     * @return   A String representing the drug ID  
   */
    public String getDrugID(){
        return drugID;
    }
    
   /**
     * Returns  Drug Name  
     * @return  A String representing the drug Name  
   */
    public String getDrugName(){
        return drugName;
    }
    
   /**
     * Returns  Drug dosage
     * @return   A String representing the drug dosage  
   */
    public int getDrugDosage(){
        return drugDosage;
    }
    
   /**
     * Returns  Drug form
     * @return  A String representing the drug form  
   */
    public String getDrugForm(){
        return drugForm;
    }
    
   /**
     * Returns  Drug instructions
     * @return   A String representing the drug instructions 
   */
    public String getDrugInstructions(){
        return drugInstructions;
    }
    
   /**
     * Returns Drug effects
     * @return  A String representing the drug effects 
    */
    public String getDrugsideEffects(){
        return sideEffects;
    }
    
   /**
     * Returns  Drug manufacturer
     * @return   A String representing the drug manufacturer
   */
    public String getManufacturer(){
        return manufacturer;
    }
    
}

