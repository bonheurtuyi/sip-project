package modules;
import controllers.MenuController;
import controllers.UserController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Patient extends User {

    private String dob;
    private String hasHiv;
    private String diagnosisDate;
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
        this.diagnosisDate ="";
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
    public void setDiagnosisDate(String diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
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
    public String getDiagnosisDate() {
        return this.diagnosisDate;
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
            System.out.println("Patient Logged in successfully!");
            System.out.println("---");
            return true;
        } else {
            return false;
        }
    }

    public void storeUserDataToFile() {
        MenuController menuController = new MenuController();
        Patient patient = menuController.getPatientInfo();
        String[] cmd = new String[] { "bash", "./scripts/complete-registration.sh",
                patient.getUUID(),
                patient.getFirstName(),
                patient.getLastname(),
                patient.getEmail(),
                patient.getPassword(),
                patient.getDob(),
                patient.getHasHiv(),
                patient.getDiagnosisDate() != null ? patient.getDiagnosisDate() : "NULL",
                patient.getOnArtDrug() != null ? patient.getOnArtDrug() : "NULL",
                patient.getDateBeganDrug() != null ? patient.getDateBeganDrug() : "NULL",
                patient.getCountryOfResidence(), "NULL",
                "Patient"
        };

        try {
            ProcessBuilder pb = new ProcessBuilder(cmd);
            Process p = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String s;
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }

            BufferedReader errorReader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String errorLine;
            while ((errorLine = errorReader.readLine()) != null) {
                System.err.println("ERROR: " + errorLine);
            }
            p.waitFor();
        } catch (Exception e) {
            System.out.println("Error Occurred: " + e);
        }
    }

    public static void getUserInfo(String id) {
        StringBuilder userInfo = new StringBuilder();
        try {
            // Create the ProcessBuilder instance
            List<String> command = new ArrayList<>();
            command.add("bash");
            command.add("-c");
            command.add("./scripts/get-user-info.sh " + id);

            ProcessBuilder processBuilder = new ProcessBuilder(command);

            // Start the process
            Process process = processBuilder.start();

            // Capture the output from the Bash script
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                userInfo.append(line).append("\n");
            }
            // Wait for the process to complete
            process.waitFor();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(userInfo.toString().trim());

    }
}
