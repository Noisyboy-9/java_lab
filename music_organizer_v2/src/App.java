import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {
        Music music1 = new Music("Loving you is a losing game", "Duncan Laurence", LocalDate.now().minusYears(1));
        Music music2 = new Music("Therefor I Am", "Billie Eilish", LocalDate.now().minusDays(10));
        Music music3 = new Music("WAP", "Cardie B", LocalDate.now().minusMonths(5));
        Music music4 = new Music("lovely", "Billie Eilish", LocalDate.now().minusDays(23));

        MusicCollection pop = new MusicCollection(new MusicPlayer());
        pop.addMusic(music1);
        pop.addMusic(music2);
        pop.addMusic(music3);
        pop.addMusic(music4);

        pop.listMusic(1);

        pop.listAllMusics();

        System.out.println("number of saved musics are : " + pop.countSavedMusics());

        pop.addToFavourite(0);
        pop.addToFavourite(3);
        pop.listFavourites();

        pop.removeFromFavourites(0);
        pop.listFavourites();

        pop.startPlaying(music1);

        pop.stopPlaying();

        pop.searchBySigner("Billie Eilish");
    }
}

/**
 * here answer to all questions of the manual will be written :
 * 
 * question 1: can we delete or get an item with index, what if we put wrong
 * index or negative index ? yes we can delete an item with index, and if the
 * index is not in range IndexOfBoundsException will be thrown
 * 
 * question 2: if from a 20 member array list we delete the 10th item what will
 * be the last item index? can we add items in the middle of the array ?the last
 * item index will be 18,and can specify for the array list add method as first
 * parameter for addition position
 * 
 * 
 */