import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Class representing a College
class College {
    // Attributes of the College class
    private String name;
    private String location;
    private int fees;
    private int ranking;

    // Constructor to initialize college attributes
    public College(String name, String location, int fees, int ranking) {
        this.name = name;
        this.location = location;
        this.fees = fees;
        this.ranking = ranking;
    }

    // Getters for college attributes
    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getFees() {
        return fees;
    }

    public int getRanking() {
        return ranking;
    }

    // Method to calculate the score based on ranking and fees
    public double calculateScore(int maxFees, double rankingWeight, double feesWeight) {
        return (ranking * rankingWeight) + ((double) fees / maxFees * feesWeight);
    }
}

// Main class for selecting colleges based on user preferences
public class CollegeSelector {
    // Constants for weights
    private static final double RANKING_WEIGHT = 2.0;
    private static final double FEES_WEIGHT = 1.0;

    public static void main(String[] args) {
        // Initialize the list of colleges
        List<College> colleges = initializeColleges();

        // User preferences
        String preferredLocation = "New York";
        int maxFees = 20000;

        // Filter and sort colleges based on user preferences
        List<College> filteredColleges = filterColleges(colleges, preferredLocation, maxFees);

        // Display matching colleges
        displayMatchingColleges(filteredColleges, maxFees);
    }

    // Method to initialize colleges with sample data
    private static List<College> initializeColleges() {
        List<College> colleges = new ArrayList<>();
        colleges.add(new College("College A", "New York", 20000, 1));
        colleges.add(new College("College B", "California", 15000, 2));
        colleges.add(new College("College C", "New York", 25000, 3));
        colleges.add(new College("College D", "New York", 10000, 4));
        return colleges;
    }

    // Method to filter colleges based on user preferences
    private static List<College> filterColleges(List<College> colleges, String preferredLocation, int maxFees) {
        List<College> filteredColleges = new ArrayList<>();

        // Filter colleges based on location and fees
        for (College college : colleges) {
            if (college.getLocation().equalsIgnoreCase(preferredLocation) && college.getFees() <= maxFees) {
                filteredColleges.add(college);
            }
        }

        // Sort filtered colleges by calculated score
        filteredColleges.sort(Comparator.comparingDouble(c -> c.calculateScore(maxFees, RANKING_WEIGHT, FEES_WEIGHT)));

        return filteredColleges;
    }

    // Method to display matching colleges
    private static void displayMatchingColleges(List<College> filteredColleges, int maxFees) {
        System.out.println("Colleges that match the user's preferences:");
        for (College college : filteredColleges) {
            double score = college.calculateScore(maxFees, RANKING_WEIGHT, FEES_WEIGHT);
            System.out.printf("Name: %s, Location: %s, Fees: %d, Ranking: %d, Score: %.2f%n",
                    college.getName(), college.getLocation(), college.getFees(), college.getRanking(), score);
        }
    }
}

/* 
Time Complexity:
- The filtering process is O(n), where n is the number of colleges.
- The sorting process is O(m log m), where m is the number of filtered colleges.
- Thus, the overall time complexity is O(n + m log m).

Space Complexity:
- O(m) for storing the filtered colleges, where m is the number of matching colleges.
- O(n) for the initial list of colleges, where n is the total number of colleges.
*/
