import java.util.*;

public class StringNormalizer {
    public static void main(String[] args) {
        String input = " Hello! World@ This is a Test !. ";
        String result = normalize(input);
        System.out.println(result); 
    }

    // Method to normalize the input string
    public static String normalize(String input) {
        String trimmedInput = trimInput(input);
        String cleanedInput = cleanInput(trimmedInput);
        return formatToCamelCase(cleanedInput);
    }

    // Method to trim leading and trailing spaces
    private static String trimInput(String input) {
        return input.trim();
    }

    // Method to clean the input by removing special characters and normalizing spaces
    private static String cleanInput(String input) {
        String cleanedInput = input.replaceAll("[^a-zA-Z0-9 ]", ""); // Remove special characters
        return cleanedInput.replaceAll("\\s+", " "); // Normalize spaces
    }

    // Method to format cleaned input into camel case
    private static String formatToCamelCase(String cleanedInput) {
        String[] words = cleanedInput.split(" ");
        StringBuilder camelCaseOutput = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                camelCaseOutput.append(Character.toUpperCase(word.charAt(0)))
                               .append(word.substring(1).toLowerCase())
                               .append(" ");
            }
        }
        return camelCaseOutput.toString().trim(); // Return the formatted string
    }

    // Time Complexity:
    // normalize() - O(n) due to trimming and cleaning
    // trimInput() - O(n)
    // cleanInput() - O(n)
    // formatToCamelCase() - O(n) for splitting and formatting
    
    // Space Complexity:
    // O(n) for the cleaned and formatted output strings
}
