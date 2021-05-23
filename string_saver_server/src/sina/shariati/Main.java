package sina.shariati;

import runnables.StringSaverSocket;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            while (true) {
                new Thread(
                        new StringSaverSocket(serverSocket.accept())
                ).run();
            }
        } catch (IOException ioException) {
            System.out.println("Io exception: " + ioException.getMessage());
        }
    }
}
