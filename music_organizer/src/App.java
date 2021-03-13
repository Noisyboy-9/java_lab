public class App {
    public static void main(String[] args) throws Exception {
        MusicCollection pop = new MusicCollection(new MusicPlayer());
        MusicCollection jazz = new MusicCollection(new MusicPlayer());
        MusicCollection rock = new MusicCollection(new MusicPlayer());
        MusicCollection country = new MusicCollection(new MusicPlayer());

        pop.addFile("I think there for I am");
        pop.addFile("WAP");
        pop.removeFile(1);
        pop.listAllFiles();

        jazz.addFile("elahe naz");
        jazz.listAllFiles();
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