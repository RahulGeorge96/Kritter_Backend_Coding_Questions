import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class College {
    String name;
    String location;
    int fees;
    int ranking;

    public College(String name, String location, int fees, int ranking) {
        this.name = name;
        this.location = location;
        this.fees = fees;
        this.ranking = ranking;
    }

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

    public double calculateScore(int maxFees, double rankingWeight, double feesWeight) {
        return (ranking * rankingWeight) + ((double) fees / maxFees * feesWeight);
    }
}

public class Q3 {
    public static void main(String[] args) {
        List<College> colleges = new ArrayList<>();
        colleges.add(new College("College A", "New York", 20000, 1));
        colleges.add(new College("College B", "California", 15000, 2));
        colleges.add(new College("College C", "New York", 25000, 3));
        colleges.add(new College("College D", "New York", 10000, 4));

      
        String preferredLocation = "New York";
        int maxFees = 20000;
        int rankingWeight = 2;
        int feesWeight = 1;

        List<College> filteredColleges = new ArrayList<>();

        // Filter colleges based on user preferences
        for (College college : colleges) {
            if (college.getLocation().equalsIgnoreCase(preferredLocation) && college.getFees() <= maxFees) {
                filteredColleges.add(college);
            }
        }

  
        filteredColleges.sort(Comparator.comparingDouble(c -> c.calculateScore(maxFees, rankingWeight, feesWeight)));

       
        System.out.println("Colleges that match the user's preferences:");
        for (College college : filteredColleges) {
            double score = college.calculateScore(maxFees, rankingWeight, feesWeight);
            System.out.printf("Name: %s, Location: %s, Fees: %d, Ranking: %d, Score: %.2f%n",
                    college.getName(), college.getLocation(), college.getFees(), college.getRanking(), score);
        }
    }
}
