package sina.shariati.note;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The type Note manager.
 */
public class NoteManager {
    private File database;
    private FileInputStream reader;
    private FileOutputStream writer;

    /**
     * Instantiates a new Note manager.
     *
     * @param database the database
     * @throws FileNotFoundException the file not found exception
     */
    public NoteManager(File database) throws FileNotFoundException {
        this.database = database;
        this.reader = new FileInputStream(database);
        this.writer = new FileOutputStream(database, true);
    }


    /**
     * Show all notes.
     *
     * @throws IOException the io exception
     */
    public void showAllNotes() throws IOException {
        if (this.database.length() == 0) {
            System.out.println("no note has been saved. please create one first!");
            return;
        }

        this.reader.getChannel().position(0);
        while (true) {
            try {
                ObjectInputStream noteReader = new ObjectInputStream(this.reader);
                Note note = (Note) noteReader.readObject();

                System.out.println("-------------------------");
                System.out.println(note.getName());
                System.out.println("-------------------------");
            } catch (EOFException eofException) {
                break;
            } catch (IOException | ClassNotFoundException ioException) {
                ioException.printStackTrace();
                break;
            }
        }

    }

    /**
     * Handle create new note.
     *
     * @throws IOException the io exception
     */
    public void handleCreateNewNote() throws IOException {
//        get user input
        Note inputNote = this.makeNoteFromUserInput();

//        validating user input
        while (this.noteWithNameExist(inputNote.getName())) {
            System.out.println("note with already exist!");
            inputNote = this.makeNoteFromUserInput();
        }

//        adding note to database
        try {
            ObjectOutputStream noteSaver = new ObjectOutputStream(this.writer);
            noteSaver.writeObject(inputNote);
            noteSaver.flush();
        } catch (IOException ioException) {
            System.out.println("there was a problem writing to database");
            ioException.printStackTrace();
        }
    }

    private boolean noteWithNameExist(String name) throws IOException {
        this.reader.getChannel().position(0);
//        resetting reader file position pointer
        while (true) {
            try {
                ObjectInputStream noteReader = new ObjectInputStream(this.reader);
                Note iterationNote = (Note) noteReader.readObject();
                if (iterationNote.getName().equals(name)) {
                    return true;
                }
            } catch (EOFException eofException) {
                break;
            } catch (IOException | ClassNotFoundException ioException) {
                ioException.printStackTrace();
                break;
            }
        }

        return false;
    }

    private Note makeNoteFromUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("please input note name:\t");
        String name = scanner.nextLine();

        System.out.print("please input note body:\t");
        String body = scanner.nextLine();

        return new Note(name, body);
    }

    /**
     * Handle note delete.
     *
     * @throws IOException the io exception
     */
    public void handleNoteDelete() throws IOException {
        if (this.database.length() == 0) {
            System.out.println("no note has been created!");
            return;
        }

        Note deleteNote = this.fetchMatchingNoteWithDatabase();

        ArrayList<Note> noteBuffer = new ArrayList<>();

        this.reader.getChannel().position(0);
        while (true) {
            try {
                ObjectInputStream noteReader = new ObjectInputStream(this.reader);
                Note note = (Note) noteReader.readObject();

                if (note.getName().equals(deleteNote.getName())) {
                    continue;
                }

                noteBuffer.add(note);
            } catch (EOFException eofException) {
                this.database.delete();
                reader.close();
                writer.close();

                this.database = new File("src/sina/shariati/database/notes.database.binary");
                this.writer = new FileOutputStream(this.database, true);
                this.reader = new FileInputStream(this.database);

                ObjectOutputStream noteWriter = new ObjectOutputStream(this.writer);

                for (Note note : noteBuffer) noteWriter.writeObject(note);

                noteWriter.flush();
                break;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                break;
            }
        }

    }

    private Note fetchMatchingNoteWithDatabase() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("please input note name:\t");
        String name = scanner.nextLine();

        while (!this.noteWithNameExist(name)) {
            System.out.println("note with name does not exist!");
            System.out.print("please input note name:\t");
            name = scanner.nextLine();
        }

        this.reader.getChannel().position(0);
        while (true) {
            try {
                ObjectInputStream objectReader = new ObjectInputStream(this.reader);
                Note iterationNote = (Note) objectReader.readObject();

                if (iterationNote.getName().equals(name)) {
                    return iterationNote;
                }
            } catch (EOFException eofException) {
                break;
            } catch (IOException | ClassNotFoundException ioException) {
                ioException.printStackTrace();
                break;
            }
        }

        return null;
    }

    /**
     * Handle show note.
     *
     * @throws IOException the io exception
     */
    public void HandleShowNote() throws IOException {
        Note note = this.fetchMatchingNoteWithDatabase();

        System.out.println("------------------------------");
        System.out.println("Note name: " + note.getName());
        System.out.println("Note body: " + note.getBody());
        System.out.println("-------------------------------");
    }
}
