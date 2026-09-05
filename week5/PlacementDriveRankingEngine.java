import java.util.Arrays;

class Candidate implements Comparable<Candidate> {
    private String name;
    private double cgpa;
    private int codingScore;
    private double compositeScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
        this.compositeScore = (cgpa * 10) + (codingScore * 0.5);
    }

    // Quick filter - strong CGPA alone is enough
    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    // Combined filter - borderline CGPA plus a genuinely good coding score
    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    public double getCompositeScore() {
        return compositeScore;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int getCodingScore() {
        return codingScore;
    }

    @Override
    public int compareTo(Candidate other) {
        // Descending order of composite score
        return Double.compare(other.compositeScore, this.compositeScore);
    }
}

public class PlacementDriveRankingEngine {

    static String shortlistAndRank(Candidate[] candidates) {
        // Step 1: shortlist eligible candidates
        Candidate[] temp = new Candidate[candidates.length];
        int count = 0;

        for (Candidate c : candidates) {
            if (Candidate.isEligible(c.getCgpa()) || Candidate.isEligible(c.getCgpa(), c.getCodingScore())) {
                temp[count] = c;
                count++;
            }
        }

        Candidate[] shortlisted = Arrays.copyOf(temp, count);

        // Step 2: rank using Candidate's own compareTo()
        Arrays.sort(shortlisted);

        // Step 3: build the result string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            result.append(i + 1).append(". ")
                  .append(shortlisted[i].getName())
                  .append(" (").append(shortlisted[i].getCompositeScore()).append(")");

            if (i != shortlisted.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
    }
}
