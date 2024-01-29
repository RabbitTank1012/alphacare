
package UserManage;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author Binnan Dong
 */
public  class User {
    
    private String firstName;
    private String lastName;
    private String username;
    private String emailaddress;
    private String password;
    private LocalDate dateOfBirth;
    private String usertype; // the user type can MedicalAdministrator, patient, doctor or nurse
    
   /**
     * This is the constructor for the User class
     * @param firstName Set the first name
     * @param lastName  Set the last name 
     * @param username  set the username
     * @param emailaddress set the email address
     * @param  password setthe password 
     * @param  type set the user type
   */
   public User(String firstName, String lastName, String username, String emailaddress, String password, LocalDate dateOfBirth,String type  ){
          this.firstName =firstName;
          this.lastName = lastName;
          this.username = username;
          this.emailaddress = emailaddress;
          this.password = password;
          this.dateOfBirth = dateOfBirth;
          this.usertype = type;
    }
   
    
    /**
     * Returns the first name of User
     * @return  A string representing the first name of a user
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of a user
     * @param firstName The first name of a user
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name of a user
     * @return A string representing the last name of a user
     */
    public String getLastName() {
        return lastName;
    }

   /**
     * Sets the last name of a user
     * @param lastName Sets the last name of a user
    */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

   /**
     * Returns the username of a user
     * @return A string representing the username of a user
    */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the type of a user
     * @param username The type of a user
     */
    public void setUsername(String userName) {
        this.username =username;
    }
    
    
    /**
     * Returns the password of a user
     * @return A string representing the password of a user
    */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of a user
     * @param userName The password of a user
    */
    public void setPassword(String password) {
        this.password =password;
    }
    
    
    /**
     * Returns the fullname of a user
     * @return A string representing the fullname of a user
     */
     public String getFullName(){
        return firstName+ " " + lastName;
    }
     
    /**
     * Returns the type of a user
     * @return A string representing the type of a user
    */
    public String getUserType() {
        return usertype;
    }

   /**
     * Sets the type of a user
     * @param type The type of a user
    */
    public void setUserType(String usertype) {
        this.usertype = usertype;
    }

   /**
     * Returns the email address of a user
     * @return The email address of a user
    */
    public String getEmailaddress() {
        return emailaddress;
    }

    /**
     * Sets the email address of a user
     * @param emailaddress The email address of a user
    */
    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }
    
    /**
     * Returns the date of birth 
     * @return  A string representing the date of birth
    */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}


