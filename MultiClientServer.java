import java.io.*;
import java.net.*;

public class MultiClientServer {
    public static void main(String[] args) {
        int port = 5000; // Port number
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is running on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket);

                // Start a new thread for each client
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Handles communication with a single client
class ClientHandler implements Runnable {
    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            out.println("Welcome to the Multi-Client Server!");

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Client says: " + message);
                out.println("Server received: " + message);

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            System.out.println("Client disconnected.");
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
