import java.util.ArrayList;

public class MusicCollection {
    private ArrayList<String> files;
    private MusicPlayer player;

    /**
     * Create a MusicCollection
     * 
     * @param player
     */
    public MusicCollection(MusicPlayer player) {
        this.files = new ArrayList<String>();
        this.player = player;
    }

    /**
     * Add a file to the collection.
     * 
     * @param filename The file to be added.
     */
    public void addFile(String filename) {
        this.files.add(filename);
    }

    /**
     * Return the number of files in the collection.
     * 
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles() {
        return this.files.size();
    }

    /**
     * List a file from the collection.
     * 
     * @param index The index of the file to be listed.
     */
    public void listFile(int index) {
        String music = this.files.get(index);
        System.out.println(music);
    }

    /**
     * Show a list of all the files in the collection.
     */
    public void listAllFiles() {
        for (String file : this.files) {
            System.out.println(file);
        }
    }

    /**
     * Remove a file from the collection.
     * 
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index) {
        if (index >= this.files.size()) {
            // could use a try-catch instead!
            System.out.println("index of out boundaries");
            return;
        }

        this.files.remove(index);
    }

    /**
     * Start playing a file in the collection. Use stopPlaying() to stop it playing.
     * 
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index) {
        String MusicToPlay = this.files.get(index);
        this.player.startPlaying(MusicToPlay);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying() {
        this.player.stop();
    }

    /**
     * Determine whether the given index is valid for the collection. Print an error
     * message if it is not.
     * 
     * @param index The index to be checked.
     */
    private boolean isValidIndex(int index) {
        return index < this.files.size();
    }
}