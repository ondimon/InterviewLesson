package client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {
    private static final String HOST = "localhost";
    private static final int PORT = 8080;
    private static final Logger LOGGER = LogManager.getLogger(Client.class);


    public static void main(String[] args) {
        Client client = new Client();
        client.sendGet();
        client.sendPost();
    }

    public void sendGet() {
        StringBuilder sb = new StringBuilder();
        sb.append("GET / HTTP/1.1").append("\r\n");
        sb.append("Host: developer.mozilla.org").append("\r\n");
        sb.append("Connection: close").append("\r\n");
        sendRequest(sb.toString());
    }

    public void sendPost() {
        StringBuilder sb = new StringBuilder();
        sb.append("POST / HTTP/1.1").append("\r\n");
        sb.append("Host: developer.mozilla.org").append("\r\n");
        sb.append("Connection: close").append("\r\n");
        sendRequest(sb.toString());
    }

    private void sendRequest(String request) {
        try(Socket socket = new Socket(HOST, PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8)))  {
            out.println(request);
            out.println();
            out.flush();
            System.out.println(in.readLine());
            while (in.ready()) {
                System.out.println(in.readLine());
            }
        } catch (IOException e) {

        }

    }

}
