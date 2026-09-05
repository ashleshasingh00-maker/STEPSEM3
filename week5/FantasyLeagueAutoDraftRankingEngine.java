import java.util.Arrays;

class Player implements Comparable<Player> {
    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    // Experience-only rule for established players
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // Combined matches-and-fitness rule for everyone else
    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    public String getName() {
        return name;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public double getBattingAverage() {
        return battingAverage;
    }

    public boolean isInjured() {
        return injured;
    }

    @Override
    public int compareTo(Player other) {
        // Rank by fantasy points (batting average) descending
        return Double.compare(other.battingAverage, this.battingAverage);
    }
}

public class FantasyLeagueAutoDraftRankingEngine {

    static String draftAndRank(Player[] players) {
        // Step 1: filter draftable players
        Player[] temp = new Player[players.length];
        int count = 0;

        for (Player p : players) {
            if (Player.isDraftable(p.getMatchesPlayed())
                    || Player.isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                temp[count] = p;
                count++;
            }
        }

        Player[] draftable = Arrays.copyOf(temp, count);

        // Step 2: rank using Player's own compareTo()
        Arrays.sort(draftable);

        // Step 3: build the result string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            result.append(i + 1).append(". ").append(draftable[i].getName());

            if (i != draftable.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}
