import java.io.*;
import java.net.*;

public class MultiClient {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Change to server IP if needed
        int port = 5000;

        try (Socket socket = new Socket(serverAddress, port);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connected to the server.");
            System.out.println("Server: " + input.readLine());

            String userMessage;
            while (true) {
                System.out.print("You: ");
                userMessage = userInput.readLine();
                output.println(userMessage);

                if (userMessage.equalsIgnoreCase("exit")) {
                    break;
                }

                System.out.println("Server: " + input.readLine());
            }

            System.out.println("Disconnected from the server.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
