import java.util.ArrayList;

public class MusicCollection {
    private ArrayList<Music> musics;
    private ArrayList<Music> favourites;
    private MusicPlayer player;

    /**
     * Create a collection of musics that can be played
     * 
     * @param player
     */
    public MusicCollection(MusicPlayer player) {
        this.musics = new ArrayList<Music>();
        this.favourites = new ArrayList<Music>();
        this.player = player;
    }

    public void searchBySigner(String signer) {
        for (Music iterationMusic : this.musics) {
            if (iterationMusic.getSinger().equals(signer)) {
                iterationMusic.print();
                return;
            }
        }

        System.out.println("Singer not found");
    }

    /**
     * print list of all favourite musics
     * 
     */
    public void listFavourites() {
        for (Music music : this.favourites) {
            music.print();
        }
    }

    /**
     * add a music to favourites
     * 
     * @param music
     */
    public void addToFavourite(Music music) {
        if (!this.musics.contains(music)) {
            System.out.println("music does not exist in the collection");
            return;
        }

        this.favourites.add(music);
    }

    /**
     * add a music to favourites
     * 
     * @param index
     */
    public void addToFavourite(int index) {
        try {
            Music favouriteMusic = this.musics.get(index);
            this.favourites.add(favouriteMusic);
        } catch (Exception exception) {
            System.out.println("error message: " + exception.getMessage());
            System.out.println("cause: " + exception.getCause());
        }
    }

    /**
     * remove music from favourites
     * 
     * @param music
     */
    public void removeFromFavourites(Music music) {
        if (!this.favourites.contains(music)) {
            System.out.println("music is not favourite");
            return;
        }

        this.favourites.remove(music);
    }

    /**
     * remove music from favourites
     * 
     * @param index
     */
    public void removeFromFavourites(int index) {
        try {
            this.favourites.remove(index);
        } catch (Exception exception) {
            System.out.println("error message: " + exception.getMessage());
            System.out.println("cause: " + exception.getCause());
        }
    }

    /**
     * add music to collection
     * 
     * @param music
     */
    public void addMusic(Music music) {
        this.musics.add(music);
    }

    /**
     * get number of musics saved
     * 
     * @return int
     */
    public int countSavedMusics() {
        return this.musics.size();
    }

    /**
     * print the music data at given index
     * 
     * @param index
     */
    public void listMusic(int index) {
        try {
            this.musics.get(index).print();
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("out of bounds exception");
            System.out.println("error message: " + exception.getMessage());
            System.out.println("cause: " + exception.getCause());
        } catch (Exception exception) {
            System.out.println("Ops something went wrong");
            System.out.println("error message: " + exception.getMessage());
            System.out.println("cause: " + exception.getCause());
        }
    }

    /**
     * print all musics added to collection
     */
    public void listAllMusics() {
        for (Music music : this.musics) {
            music.print();
        }
    }

    /**
     * remove music at given index if index is valid
     * 
     * @param index
     */
    public void removeMusic(int index) {
        try {
            this.musics.remove(index);
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("out of bounds exception");
            System.out.println("error message: " + exception.getMessage());
            System.out.println("cause: " + exception.getCause());
        } catch (Exception exception) {
            System.out.println("Ops something went wrong");
            System.out.println("error message: " + exception.getMessage());
            System.out.println("cause: " + exception.getCause());
        }
    }

    /**
     * start playing of music
     * 
     * @param music
     */
    public void startPlaying(Music music) {
        if (this.musics.contains(music)) {
            this.player.startPlaying(music);
        } else {
            System.out.println("input music is not part of the collection");
        }
    }

    /**
     * start playing of music
     * 
     * @param index
     */
    public void startPlaying(int index) {
        Music music;
        try {
            music = this.musics.get(index);
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("out of bounds exception");
            System.out.println("error message: " + exception.getMessage());
            System.out.println("cause: " + exception.getCause());
        } catch (Exception exception) {
            System.out.println("Ops something went wrong");
            System.out.println("error message: " + exception.getMessage());
            System.out.println("cause: " + exception.getCause());
        }

        this.player.startPlaying(music);
    }

    /**
     * stop playing of the music
     */
    public void stopPlaying() {
        this.player.stop();
    }
}