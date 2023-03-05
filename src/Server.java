import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("server started");
        int port = 8085;
        List<String> names = new ArrayList<>();
        names.addAll(Arrays.asList("milla", "elstanos", "somebody"));
        List<String> games = new ArrayList<>();
        games.addAll(Arrays.asList("shooter", "strategy", "fighting"));
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket socket = serverSocket.accept();
                     PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                     BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))
                ) {
                    System.out.println("New connection accepted");
//                    final String name = input.readLine();
//                    output.println(String.format("Hi %s, your port is %d", name, socket.getPort()));
                    output.println("Please enter your name");
                    final String name2 = input.readLine();

                    if (names.contains(name2)) {
                        output.println("Howdy partner " + name2 + "!" + " What would you like to play today?");
                    } else {
                        output.println("It looks like you are with us for the first time. Welcome " + name2 + " !" + " What would you like to play today?");
                    }

                    String game = input.readLine();
                    while (true) {
                        if (games.contains(game)) {
                            output.println("Great choice! Let's play!");
                            return;
                        } else {
                            output.println("We don't have that kind of game yet, maybe something else?");
                        }
                        game = input.readLine();
                    }
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
