import java.util.Arrays;

public class Playlist {
    private final String[] songs;
    private int count;

    public Playlist(int maxSize) {
        songs = new String[maxSize];
        count = 0;
    }

    public void addSong(String title) {
        if (count < songs.length) {
            songs[count] = title;
            count++;
        }
    }

    public String[] getSongs() {
        // return a copy, so the original array can't be changed from outside
        return Arrays.copyOf(songs, count);
    }

    public int getSongCount() {
        return count;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        System.out.println("Copy after tampering: " + Arrays.toString(copy));
        System.out.println("Actual playlist: " + Arrays.toString(p.getSongs()));
        System.out.println("Song count: " + p.getSongCount());
    }
}
