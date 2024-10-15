import java.util.*;

public class Q1 {
        public static void main(String[] args) {

        String input = " Hello! World@ This is a Test !. ";
        
        String result = normalize(input);
        
        System.out.println(result); 
    }
    public static String normalize(String input) {

        String trimmedInput = input.trim();
        
        String cleanedInput = trimmedInput.replaceAll("[^a-zA-Z0-9 ]", "");
        
        cleanedInput = cleanedInput.replaceAll("\\s+", " ");
        String[] words = cleanedInput.split(" ");
        StringBuilder camelCaseOutput = new StringBuilder();
        
        for (String word : words) {
            if (!word.isEmpty()) {
                camelCaseOutput.append(Character.toUpperCase(word.charAt(0)))
                               .append(word.substring(1).toLowerCase())
                               .append(" ");
            }
        }

        return camelCaseOutput.toString().trim();
    }
}
