package modules;
import controllers.UserController;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class Patient extends User {

    private String dob;
    private String hasHiv;
    private String dignosisDate;
    private String onArtDrug;
    private String dateBeganDrug;
    private String countryOfResidence; // SIO

    UserController userController;

    // Zero Param constructor
    public Patient() {
        super();
        userController = new UserController();
    }

    //Constructor overloading
    //Sets the default values for the patient. This is used when initializing the patient account creation
    public Patient(String uuid, String email) {
        super();
        super.setUuid(uuid);
        super.setEmail(email);
        super.setPassword("NULL");
        super.setRole(UserRole.Patient);
        super.setFirstname("NULL");
        super.setLastname("NULL");
        this.dob="NULL";
        this.hasHiv="NULL";
        this.dignosisDate="";
        this.onArtDrug="NULL";
        this.dateBeganDrug="NULL";
        this.countryOfResidence="NULL";
    }

    // -------Setters-----------
    public void setDob(String dob) {
        this.dob = dob;
    }
    public void setHasHiv(String hasHIV) {
        this.hasHiv = hasHIV;
    }
    public void setDiagnosisDate(String dignosisDate) {
        this.dignosisDate = dignosisDate;
    }
    public void setOnArtDrug(String onArtDrug) {
        this.onArtDrug = onArtDrug;
    }
    public void setDateBeganDrug(String dateBeganDrug) {
        this.dateBeganDrug = dateBeganDrug;
    }
    public void setCountryOfResidence(String countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
    }

    // ----------Getters---------------
    public String getDob() {
        return this.dob;
    }
    public String getHasHiv() {
        return this.hasHiv;
    }
    public String getDignosisDate() {
        return this.dignosisDate;
    }
    public String getOnArtDrug() {
        return onArtDrug;
    }
    public String getDateBeganDrug() {
        return dateBeganDrug;
    }
    public String getCountryOfResidence() {
        return countryOfResidence;
    }

    // ----------implementation of the login abstract method---------------
    @Override
    public boolean userLogin(String email, String password) {
        // Check if entered details are correct
        if (userController.verifyLoginCredentials(email, password).equals("patient")) {
            System.out.println("Patient Logged in successful.");
            return true;
        } else {
            return false;
        }
    }
}
