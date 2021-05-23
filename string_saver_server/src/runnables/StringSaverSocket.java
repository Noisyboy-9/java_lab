package runnables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class StringSaverSocket implements Runnable {
    private final Socket socket;
    private String clientInputs; // all previous client inputs

    public StringSaverSocket(Socket socket) {
        this.socket = socket;
        this.clientInputs = "";
    }

    @Override
    public void run() {
        try {
            BufferedReader request = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            PrintWriter response = new PrintWriter(this.socket.getOutputStream(), true);

            String input = request.readLine().trim();
            do {
                this.clientInputs = this.clientInputs.concat(" | " + input);
                response.println(clientInputs);

                input = request.readLine().trim();
            } while (!input.equals("exit"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
