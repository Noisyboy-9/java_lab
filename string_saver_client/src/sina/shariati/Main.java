package sina.shariati;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 5000)) {
            PrintWriter request = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader response = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String userInput = "";
            do {
                Scanner scanner = new Scanner(System.in);

                System.out.print("please input your text: ");
                userInput = scanner.nextLine().trim();

                request.println(userInput);

                String responseString = response.readLine().trim();
                System.out.println(responseString);
            } while (!userInput.equals("exit"));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
