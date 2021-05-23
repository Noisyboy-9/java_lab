package sina.shariati;

import sina.shariati.enums.MainMenuOrderEnum;
import sina.shariati.exceptions.InvalidMenuOrderException;
import sina.shariati.note.NoteManager;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InvalidMenuOrderException {
        showMainMenu();

        File db = new File("src/sina/shariati/database/notes.database.binary");
        NoteManager noteManager = new NoteManager(db);

        MainMenuOrderEnum mainMenuOrder = getMenuOrder();

        while (mainMenuOrder != MainMenuOrderEnum.EXIT) {
            switch (mainMenuOrder) {
                case SHOW_ALL_NOTES -> noteManager.showAllNotes();
                case CREATE_NEW_NOTE -> noteManager.handleCreateNewNote();
                case DELETE_NOTE -> noteManager.handleNoteDelete();
                case SHOW_NOTE -> noteManager.HandleShowNote();
            }
            showMainMenu();
            mainMenuOrder = getMenuOrder();
        }

//        order is exit
        System.out.println("hope you have enjoyed :)");
    }

    private static MainMenuOrderEnum getMenuOrder() throws InvalidMenuOrderException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("please input your order: ");
        int inputOrder = scanner.nextInt();

        while (inputOrder != 1 && inputOrder != 2 && inputOrder != 3 && inputOrder != 4 && inputOrder != 5) {
            System.out.println("invalid order");
            System.out.print("please input your order: ");
            inputOrder = scanner.nextInt();
        }

        if (inputOrder == 1) {
            return MainMenuOrderEnum.SHOW_ALL_NOTES;
        } else if (inputOrder == 2) {
            return MainMenuOrderEnum.CREATE_NEW_NOTE;
        } else if (inputOrder == 3) {
            return MainMenuOrderEnum.DELETE_NOTE;
        } else if (inputOrder == 4) {
            return MainMenuOrderEnum.SHOW_NOTE;
        } else {
            return MainMenuOrderEnum.EXIT;
        }

//        invalid order entered
    }


    private static void showMainMenu() {
        System.out.println("Note Making app");
        System.out.println("1) show all notes");
        System.out.println("2) create a new note");
        System.out.println("3) delete a note");
        System.out.println("4) watch a note with detail");
        System.out.println("5) exit");
    }
}
