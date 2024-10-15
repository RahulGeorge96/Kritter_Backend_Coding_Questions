import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Chatbot {
    private Map<String, String> qaPairs;

    // Constructor initializes question-answer pairs
    public Chatbot() {
        qaPairs = new HashMap<>();
        initializeQAPairs();
    }

    // Method to initialize predefined question-answer pairs
    private void initializeQAPairs() {
        qaPairs.put("What is your name?", "My name is Chatbot.");
        qaPairs.put("How can I help you?", "I can assist you with your queries.");
        qaPairs.put("What is the weather today?", "The weather is sunny.");
    }

    // Method to get an answer based on user input
    public String getAnswer(String userQuestion) {
        String closestQuestion = findClosestQuestion(userQuestion);
        return closestQuestion.isEmpty() ? "Sorry, I don't understand." : qaPairs.get(closestQuestion);
    }

    // Method to find the closest matching predefined question
    private String findClosestQuestion(String userQuestion) {
        String closestQuestion = "";
        int highestMatchCount = 0;

        for (String question : qaPairs.keySet()) {
            int matchCount = countMatchingWords(userQuestion, question);
            if (matchCount > highestMatchCount) {
                highestMatchCount = matchCount;
                closestQuestion = question;
            }
        }
        return closestQuestion;
    }

    // Method to count matching words between user input and predefined question
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

    // Main method to run the chatbot
    public static void main(String[] args) {
        Chatbot chatbot = new Chatbot();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ask me a question:");
        String userInput = scanner.nextLine();
        
        String answer = chatbot.getAnswer(userInput);
        System.out.println(answer);

        scanner.close();
    }

    // Time Complexity:
    // getAnswer() - O(n * m), where n is the number of predefined questions and m is the average number of words in user input and questions
    // findClosestQuestion() - O(n * m)
    // countMatchingWords() - O(m * p), where m is the number of user words and p is the number of predefined words

    // Space Complexity:
    // O(n + m) for storing the question-answer pairs and user-defined strings
}
