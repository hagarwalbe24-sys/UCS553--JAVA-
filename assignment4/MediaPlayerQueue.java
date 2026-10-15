
import java.util.*;

class Song {
    String songId;
    String title;
    String artist;

    Song(String songId, String title, String artist) {
        this.songId = songId;
        this.title = title;
        this.artist = artist;
    }

    @Override
    public String toString() {
        return title + " by " + artist;
    }
}

public class MediaPlayerQueue {

    LinkedList<Song> playlist = new LinkedList<>();
    LinkedList<Song> history = new LinkedList<>();

    // Keeps track of IDs currently present in the playlist.
    HashSet<String> songIds = new HashSet<>();

    // Adds a song at any valid position.
    void addSong(int position, Song song) {
        if (position < 0 || position > playlist.size()) {
            System.out.println("Invalid position.");
            return;
        }

        if (songIds.contains(song.songId)) {
            System.out.println("Duplicate song: " + song.title);
            return;
        }

        playlist.add(position, song);
        songIds.add(song.songId);

        System.out.println("Added: " + song.title);
    }

    // Adds a priority song at the beginning.
    void addPrioritySong(Song song) {
        if (songIds.contains(song.songId)) {
            System.out.println("Duplicate song: " + song.title);
            return;
        }

        playlist.addFirst(song);
        songIds.add(song.songId);

        System.out.println("Priority song added: " + song.title);
    }

    // Removes a song by its ID.
    void removeSong(String songId) {
        ListIterator<Song> iterator = playlist.listIterator();

        while (iterator.hasNext()) {
            Song song = iterator.next();

            if (song.songId.equals(songId)) {
                iterator.remove();
                songIds.remove(songId);
                System.out.println("Removed: " + song.title);
                return;
            }
        }

        System.out.println("Song not found.");
    }

    // Removes duplicate IDs while keeping the first occurrence.
    void removeDuplicates() {
        HashSet<String> seen = new HashSet<>();
        ListIterator<Song> iterator = playlist.listIterator();

        while (iterator.hasNext()) {
            Song song = iterator.next();

            if (!seen.add(song.songId)) {
                iterator.remove();
            }
        }

        songIds.clear();

        for (Song song : playlist) {
            songIds.add(song.songId);
        }

        System.out.println("Duplicate songs removed.");
    }

    // Plays the first song and records it in history.
    void playNext() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }

        Song song = playlist.removeFirst();
        songIds.remove(song.songId);
        history.addLast(song);

        System.out.println("Now playing: " + song);
    }

    void showHistory() {
        System.out.println("\nRecently played songs:");

        if (history.isEmpty()) {
            System.out.println("No songs played yet.");
            return;
        }

        for (Song song : history) {
            System.out.println(song);
        }
    }

    // Traverses from first song to last song.
    void traverseForward() {
        System.out.println("\nForward traversal:");

        ListIterator<Song> iterator = playlist.listIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    // Traverses from last song to first song.
    void traverseBackward() {
        System.out.println("\nBackward traversal:");

        ListIterator<Song> iterator =
                playlist.listIterator(playlist.size());

        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }

    void displayPlaylist() {
        System.out.println("\nCurrent playlist:");

        for (Song song : playlist) {
            System.out.println(song);
        }
    }

    public static void main(String[] args) {
        MediaPlayerQueue player = new MediaPlayerQueue();

        Song s1 = new Song("101", "Perfect", "Ed Sheeran");
        Song s2 = new Song("102", "Excuses", "AP Dhillon");
        Song s3 = new Song("103", "295", "Sidhu Moosewala");
        Song s4 = new Song("104", "Softly", "Karan Aujla");

        // Insert songs at arbitrary positions.
        player.addSong(0, s1);
        player.addSong(1, s2);
        player.addSong(2, s3);
        player.addSong(1, s4);

        // Add a priority song at the front.
        player.addPrioritySong(
                new Song("105", "Winning Speech", "Karan Aujla"));

        // Attempt to add a duplicate ID.
        player.addSong(2,
                new Song("102", "Excuses Remix", "AP Dhillon"));

        player.displayPlaylist();

        // Demonstrate bidirectional traversal.
        player.traverseForward();
        player.traverseBackward();

        // Play songs and maintain history.
        player.playNext();
        player.playNext();

        player.showHistory();

        // Remove a song by ID.
        player.removeSong("103");

        player.displayPlaylist();
    }
}
