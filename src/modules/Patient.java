package modules;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

public class Patient extends User {

    public Patient(String firstName, String lastName, String email, String password, LocalDate dateOfBirth, boolean hasHIV, LocalDate diagnosisDate, boolean onART, LocalDate artStartDate, String countryOfResidence) {
        super(firstName, lastName, email, password);
    }

    public static void userLogin() {
            try {
                ProcessBuilder pb = new ProcessBuilder("bash", "./login.sh");
                Map<String, String> env = pb.environment();
                env.put("name", "Nonsense");
                pb.directory(new File("./"));
                File log = new File("log.txt");
                pb.redirectErrorStream(true);
                pb.redirectOutput(ProcessBuilder.Redirect.appendTo(log));
                Process p = pb.start();

                // Convert the byte array to a string
//            byte[] output = p.getInputStream().readAllBytes();
//            String outputString = new String(output);
//            System.out.println(outputString);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}

