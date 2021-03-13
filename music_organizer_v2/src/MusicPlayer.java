public class MusicPlayer {
    // The current player. It might be null.
    private boolean isPlaying;

    /**
     * Constructor for objects of class MusicFilePlayer
     */
    public MusicPlayer() {
        isPlaying = false;
    }

    /**
     * Start playing the given audio file. The method returns once the playing has
     * been started.
     * 
     * @param filename The file to be played.
     */
    public void startPlaying(Music music) {
        System.out.println(music.getName() + " is playing...");
        isPlaying = true;
    }

    /**
     * if there is a music playing stop playing
     */
    public void stop() {
        if (this.isPlaying) {
            System.out.println("player has stopped!");
            isPlaying = false;
        }
    }
}