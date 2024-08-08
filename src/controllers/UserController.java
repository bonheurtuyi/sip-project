package controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserController {
    public String verifyLoginCredentials(String email, String password) {
        String[] cmd = new String[] { "bash", "src/scripts/login.sh", email, password };
        try {
            ProcessBuilder pb = new ProcessBuilder(cmd);
            Process p = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String s = null;
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }

            // Capture the error stream
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String errorLine = null;
            while ((errorLine = errorReader.readLine()) != null) {
                System.err.println("ERROR: " + errorLine);
            }
            p.waitFor();
            if (p.exitValue() == 0) {
                return "admin";
            } else if (p.exitValue() == 2) {
                return "patient";
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "invalid"; // invalid credentials
    }
}
