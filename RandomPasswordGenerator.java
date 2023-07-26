/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package randompasswordgenerator;

/**
 *
 * @author Sakib Sadri
 */
import java.util.Random;

public class RandomPasswordGenerator {

    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:,.<>?";

    public static void main(String[] args) {
        int passwordLength = 12; // Default password length if the user doesn't provide one
        boolean useUppercase = true;
        boolean useLowercase = true;
        boolean useNumbers = true;
        boolean useSpecialCharacters = true;

        // You can add code here to take user input for the above criteria if needed.

        String generatedPassword = generateRandomPassword(passwordLength, useUppercase, useLowercase, useNumbers, useSpecialCharacters);
        System.out.println("Generated Password: " + generatedPassword);
    }

    private static String generateRandomPassword(int length, boolean useUppercase, boolean useLowercase,
                                                 boolean useNumbers, boolean useSpecialCharacters) {
        StringBuilder password = new StringBuilder();
        String validCharacters = "";

        if (useUppercase) validCharacters += UPPERCASE_LETTERS;
        if (useLowercase) validCharacters += LOWERCASE_LETTERS;
        if (useNumbers) validCharacters += NUMBERS;
        if (useSpecialCharacters) validCharacters += SPECIAL_CHARACTERS;

        if (validCharacters.isEmpty()) {
            System.out.println("Error: At least one character type should be selected.");
            return "";
        }

        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(validCharacters.length());
            password.append(validCharacters.charAt(randomIndex));
        }

        return password.toString();
    }
}
