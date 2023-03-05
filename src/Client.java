import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8085;
        try (Socket serverSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()))) {
            final String qw = in.readLine();
            System.out.println(qw);
            Scanner scanner = new Scanner(System.in);
//            out.println("Sergey");
//            String resp = in.readLine();
//            System.out.println(resp);
            while (true) {
                out.println(scanner.nextLine());
                String ans = in.readLine();
                System.out.println(ans);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
