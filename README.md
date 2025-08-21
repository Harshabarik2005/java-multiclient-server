Java Multi-Client Server 🚀
This project demonstrates Java Socket Programming with support for multiple clients connecting to a single server. Each client runs independently, and the server handles them using multithreading.

📌 Features
Multi-threaded server that can handle multiple clients concurrently
Real-time message exchange between server and clients
Clients can connect/disconnect independently
Simple command-line interface for testing

🛠 Tech Stack
Java (Core Java, Sockets, Multi-threading)
ServerSocket and Socket APIs
I/O Streams for communication

⚡ How It Works
The server runs on a given port and waits for client connections.
Each client connects to the server via socket.
The server spawns a new thread (ClientHandler) for every client.
Clients can send messages to the server, and the server responds back.
Typing exit disconnects a client.

▶️ How to Run
1. Clone the Repository
git clone https://github.com/your-username/java-multi-client-server.git
cd java-multi-client-server

2. Compile the Code
javac MultiClientServer.java MultiClient.java

3. Run the Server
java MultiClientServer


Output:
Server is running on port 5000

4. Run the Clients

Open another terminal (or multiple) and run:

java MultiClient
