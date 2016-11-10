package homework.lab10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in; // TODO convert to local vars (?)

    public ChatClient(String serverAddress, int serverPort) {
        System.out.println("Establishing connection. Please wait...");
        try {
            socket = new Socket(serverAddress, serverPort);
            System.out.println("Connected: " + socket);
            run(); // TODO check to be right
        } catch (UnknownHostException uhe) {
            System.out.println("Host unknown: " + uhe.getMessage());
        } catch (IOException ioe) {
            System.out.println("Unexpected exception: " + ioe.getMessage());
        }
    }

    public void run() { // TODO rewrite and change the whole implementation of server-client connections!
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            System.out.println(in.readLine());
            out.println(console.readLine());
            System.out.println(in.readLine());

            String message;
            System.out.print("> Message: ");
            while ((message = console.readLine()) != null) {
                out.println(message);
                System.out.println(in.readLine());
                System.out.print("> Message: ");
            }

            out.println(message);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }


    public static void main(String args[]) {
        ChatClient client = null;
        if (args.length != 2)
            System.out.println("Usage: java ChatClient [host] [port]");
        else
            client = new ChatClient(args[0], Integer.parseInt(args[1]));
    }
}
