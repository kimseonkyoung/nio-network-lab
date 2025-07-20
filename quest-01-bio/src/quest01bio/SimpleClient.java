package src.quest01bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("서버가 연결됩니다. 입력해주세요: ");

        String line;
        while ((line = keyboard.readLine()) != null) {
            out.println(line);
            System.out.println("From server: " + in.readLine());
        }
    }
}
