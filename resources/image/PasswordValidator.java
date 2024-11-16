package resources.image;
import java.util.Scanner;

public class PasswordValidator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Your password has to be:");
        System.out.println("1. Length must be between 8 and 12 characters.");
        System.out.println("2. At least one uppercase letter.");
        System.out.println("3. At least one lowercase letter.");
        System.out.println("4. At least one digit.");
        System.out.println("5. At least one special character.");

        while (true) {
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            try {
                validatePassword(password);
                System.out.println("Password is valid!");
                break; 
            } catch (InvalidPasswordException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }

    public static void validatePassword(String password) throws InvalidPasswordException {
        if (password.length() < 8 || password.length() > 12) {
            throw new InvalidPasswordException("Password length must be between 8 and 12 characters.");
        }

        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        String specialChars = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/`~";

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUppercase = true;
            if (Character.isLowerCase(c)) hasLowercase = true;
            if (Character.isDigit(c)) hasDigit = true;
            if (specialChars.indexOf(c) != -1) hasSpecialChar = true;
        }

        if (!hasUppercase) {
            throw new InvalidPasswordException("Password must contain at least one uppercase letter.");
        }
        if (!hasLowercase) {
            throw new InvalidPasswordException("Password must contain at least one lowercase letter.");
        }
        if (!hasDigit) {
            throw new InvalidPasswordException("Password must contain at least one digit.");
        }
        if (!hasSpecialChar) {
            throw new InvalidPasswordException("Password must contain at least one special character.");
        }
    }
}
class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}
