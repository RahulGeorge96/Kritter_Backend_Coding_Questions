import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Q2 {
    
    private Map<String, String> qaPairs;

    public Q2() {
        qaPairs = new HashMap<>();
        qaPairs.put("What is your name?", "My name is Chatbot.");
        qaPairs.put("How can I help you?", "I can assist you with your queries.");
        qaPairs.put("What is the weather today?", "The weather is sunny.");
    }

    public String getAnswer(String userQuestion) {
        String closestQuestion = "";
        int highestMatchCount = 0;

        for (String question : qaPairs.keySet()) {
            int matchCount = countMatchingWords(userQuestion, question);
            if (matchCount > highestMatchCount) {
                highestMatchCount = matchCount;
                closestQuestion = question;
            }
        }

        // Return the corresponding answer or a default message if no match found
        return closestQuestion.isEmpty() ? "Sorry, I don't understand." : qaPairs.get(closestQuestion);
    }

    private int countMatchingWords(String userQuestion, String predefinedQuestion) {
        String[] userWords = userQuestion.toLowerCase().split("\\W+");
        String[] predefinedWords = predefinedQuestion.toLowerCase().split("\\W+");
        int matchCount = 0;

        for (String userWord : userWords) {
            for (String predefinedWord : predefinedWords) {
                if (userWord.equals(predefinedWord)) {
                    matchCount++;
                }
            }
        }
        return matchCount;
    }

    public static void main(String[] args) {
        Q2 chatbot = new Q2();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ask me a question:");
        String userInput = scanner.nextLine(); 
        
        String answer = chatbot.getAnswer(userInput);
     
        System.out.println(answer);

        scanner.close(); 
    }
}
