
/**********Task**********/
ATZ Healthcare provides services in the healthcare domain. The company wants to develop a role-based health care application called AlphaCare.
Through AlphaCare, patients can see and manage their own medical records. Medical personnel can manage the medical records of their patients 
including those provided by other medical personnel, be alerted of patients with warning signs of chronic illness or missing immunizations, 
and perform bio-surveillance such as epidemic detection.

/**********User interface**********/
The user interface should be designed to be both simple and user-friendly. We choose JavaFX FXML, which is an XML-based language that provides 
the structure for building a user interface separate from the application logic of your code, thereby making the code easier to maintain.
It also improves programming efficiency.

/**********Data Persistence**********/
Data Persistence:Sqlite Database

/************User Case **********/
You can use user below to login or Click "Create Account" to create a new patient or doctor to login.
patient: username/password(bvd1234/bvd1234)
doctor:  username/password(doctor1234/doctor1234)

***Use Case one:Create Appointment **
Steps 
1. Run AlphaCare Application
2. Use default username and password to Login or Click "Create Account" to create a new patient to login
3. Click on "Create Appointment"
4. You can input and complete appointment information.
5. Click "Create", an appointment will be stored in the application database.

***Use Case Two: Appointment History ***
Steps 
1. Run AlphaCare Application
2. Use default username and password to Login or Click "Create Account" to create a new patient to login
3. Click on "Appointment History"
4. All apponitment information for this patient will be displayed in the table.

**Use Case Three: Update Appointment ***
Steps 
1. Run AlphaCare Application
2. Use default username and password to Login or Click "Create Account" to create a new patient user to login
3. Click on "Appointment History"
4. All appointment for this patient will be displayed in the table.
5. Select the updated appointment in the table
6. Click on "Update Appointment"
7. The patient is allowed to change the information in the fields that was entered in the “Create appointment” screen
8. Click "Update", the updated appointment will be stored in the application database.

**Use Case Four: Export Appointment ***
Steps 
1. Run AlphaCare Application
2. Use default username and password to Login.
3. Click on "Export Appointment"
4. Select folder,input filename. Click on "Save", the patient's all appointment information will export to this file.

**Use Case Five: Patient Prescription***
Steps 
1. Run AlphaCare Application
2. Use default username and password to Login.
3. Click on "Patient Prescription"
4. All prescription information for this patient will be displayed in the table.

**Use Case Six: Create Prescription***
Steps 
1. Run AlphaCare Application
2. Use username and password below to Login or Click "Create Account" to create a new doctor to login.
  username:doctor1234 
  password:doctor1234
3. Click on "Create Prescription"
4. You can input and complete prescription information for the selected patient
5. Click "Create", a prescription will be stored in the application database.





