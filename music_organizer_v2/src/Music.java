import java.time.LocalDate;
import java.util.Objects;

public class Music {
    private String name;
    private String singer;
    private LocalDate releaseDate;

    /**
     * get name of the music
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * get release date of music
     *
     * @return LocalDate
     */
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    /**
     * set release date of music
     *
     * @param releaseDate
     */
    public void setReleaseDate(LocalDate releaseDate) {
        if (releaseDate.isAfter(LocalDate.now())) {
            System.out.println("a music can not have a release date in future!");
            return;
        }

        this.releaseDate = releaseDate;
    }

    /**
     * get signer name of music
     *
     * @return String
     */
    public String getSinger() {
        return singer;
    }

    /**
     * set singer of music
     *
     * @param singer
     */
    public void setSinger(String singer) {
        this.singer = singer;
    }

    /**
     * set name of music
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * create a music
     *
     * @param name
     * @param singer
     * @param releaseDate
     */
    public Music(String name, String singer, LocalDate releaseDate) {
        this.setName(name);
        this.setSinger(singer);
        this.setReleaseDate(releaseDate);
    }

    public void print() {
        System.out.println(this.getName());
        System.out.println("singer:" + this.getSinger());
        System.out.println("release date: " + this.getReleaseDate().toString());
        System.out.println("**************************************************************");
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Music music = (Music) object;
        return name.equals(music.name) && singer.equals(music.singer) && releaseDate.equals(music.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, singer, releaseDate);
    }
}
