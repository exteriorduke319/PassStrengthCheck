import java.util.Scanner;
// Make it substring instead of checking entire password
public class Main {
    public static void main(String[] args) {
        Scanner hov = new Scanner(System.in);
        boolean doneCheck;

        do {
            // Resets everything if the user enters another password
            int testPassed = 5;
            boolean caps = false;
            boolean lower = false;
            boolean num = false;
            boolean specialChar = false;
            String password = InputHelper.getNonZeroLenString(hov, "Please enter your password");
            String current;

            // Determines if the password passes the tests or not
            for (int i = 0; i < password.length(); i++) {
                current = password.substring(i, i+1);

                if(current.matches("[A-Z]")) {
                    caps = true;
                }

                if(current.matches("[a-z]")) {
                    lower = true;
                }

                if(current.matches("[0-9]")) {
                    num = true;
                }

                if(current.matches("[!@#$%^&*]")) {
                    specialChar = true;
                }
            }

            // Overly complicated section of code that takes away from tests passed if a test isn't passed
            if(!caps) {
                System.out.println("Your password should contain at least 1 capital letter.");
                testPassed--;
            }

            if (!lower) {
                System.out.println("Your password should contain at least 1 lowercase letter.");
                testPassed--;
            }

            if (!num){
                System.out.println("Your password should contain at least 1 number.");
                testPassed--;
            }

            if (!specialChar){
                System.out.println("Your password should contain at least 1 special character.");
                testPassed--;
            }

            if (password.length() < 12) {
                System.out.println("Your password should be at least 12 characters long");
                testPassed--;
            }

            // Tells the user the password strength and how many tests it passed
            System.out.println();
            System.out.println("Your password passed " + testPassed + "/5 tests.");
            if (testPassed >= 4) {
                System.out.println("Your password's strength is strong");
            } else if (testPassed == 3) {
                System.out.println("Your password's strength is medium.");
            } else {
                System.out.println("Your password's strength is weak.");
            }

            System.out.println();
            doneCheck = InputHelper.getYNConfirm(hov, "Would you like to check another password?");

        } while (doneCheck);

    }
}