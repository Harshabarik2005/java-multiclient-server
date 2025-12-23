# Java Multi-Client Server

## Description
A lightweight, easy-to-understand Java TCP server designed to handle multiple clients concurrently. This project demonstrates a simple multi-threaded server architecture where each connected client is served by a dedicated handler thread. It's ideal for learning network programming concepts, socket communication, threading, and basic message broadcasting between clients.

## Features
- TCP-based server using Java Sockets
- Supports multiple simultaneous client connections
- Per-client handler threads for isolated session handling
- Simple message broadcast capability (server-to-all clients)
- Clean start/stop lifecycle and graceful connection handling
- Minimal external dependencies — pure Java (JDK) implementation

## Getting Started
These instructions will help you run the project locally for development and learning purposes.

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Maven or your preferred Java build tool (optional if running from IDE)
- A terminal or IDE (IntelliJ IDEA, Eclipse, VS Code with Java extensions)

### Clone the repository

```bash
git clone https://github.com/Harshabarik2005/java-multiclient-server.git
cd java-multiclient-server
```

### Build (if using Maven)

```bash
mvn clean package
```

### Run the Server
You can run the server from your IDE or terminal. Adjust the port as needed.

```bash
# Example: run with java if you have a compiled jar
java -jar target/java-multiclient-server.jar

# Or run the main class from your IDE
```

### Run a Client (example)
You can test with simple telnet or netcat clients, or use the provided sample client if the repo includes one.

```bash
# Using telnet
telnet localhost 5000

# Using netcat
nc localhost 5000
```

Type messages in the client terminal and press Enter to send. Messages may be broadcast to other connected clients depending on server implementation.

## Configuration
- Default port: 5000 (or as specified in the server main class)
- Connection backlog, timeouts, and thread pool behavior can be adjusted in the server code or configuration file if present.

## How it works (high level)
1. Server listens on a specified TCP port.
2. When a client connects, the server accepts the socket and starts a new ClientHandler thread.
3. ClientHandler reads messages from the client and processes them (e.g., relays to other clients, logs, or responds).
4. Server maintains a list of active client handlers for broadcasting and cleanup.
5. When a client disconnects or an error occurs, the handler closes resources and removes itself from the active list.

## Contributing
Contributions, issues, and feature requests are welcome. Please follow these steps:
1. Fork the repository
2. Create a feature branch (git checkout -b feature-name)
3. Commit your changes (git commit -m "Add feature")
4. Push to the branch (git push origin feature-name)
5. Open a pull request describing your changes

Please include unit tests where applicable and keep changes small and focused.

## Testing
- Manual testing with multiple telnet/netcat sessions.
- Add automated unit/integration tests for message handling and connection lifecycle as improvements.

## Troubleshooting
- "Address already in use": ensure the configured port is free or change the port.
- Client cannot connect: check firewall settings and ensure server is running.

## License
Specify a license for the project (e.g., MIT License). Add a LICENSE file at the repository root.

## Contact
Maintainer: Harshabarik2005
