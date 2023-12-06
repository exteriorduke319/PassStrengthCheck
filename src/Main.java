import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner hov = new Scanner(System.in);

        String password;
        int testPassed = 0;
        boolean doneCheck = true;

        do {
            password = InputHelper.getNonZeroLenString(hov, "Please enter your password");

            if (password.length() >= 12) {
                testPassed++;
            } else {
                System.out.println("Your password should be at least 12 characters long");
            }

            if(password.matches("[A-Z]")) {
                testPassed++;
            } else {
                System.out.println("Your password should contain at least 1 capital letter.");
            }

            if(password.matches("[a-z]")) {
                testPassed++;
            } else {
                System.out.println("Your password should contain at least 1 lowercase letter.");
            }

            if(password.matches("[0-9]")) {
                testPassed++;
            } else {
                System.out.println("Your password should contain at least 1 number.");
            }

            if(password.matches("[!@#$%^&*]")) {
                testPassed++;
            } else {
                System.out.println("Your password should contain at least 1 special character.");
            }

            System.out.println("Your password passed " + testPassed + "/5 tests.");
            if (testPassed >= 4) {
                System.out.println("Your password's strength is strong");
            } else if (testPassed == 3) {
                System.out.println("Your password's strength is medium.");
            } else {
                System.out.println("Your password's strength is weak.");
            }

            doneCheck = InputHelper.getYNConfirm(hov, "Would you like to check another password?");
        } while (doneCheck);

    }
}