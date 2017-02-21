package client;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Lisa on 2/14/2017.
 */
public class ClientServer {

    static Logger log = Logger.getLogger(ClientServer.class.getName());

    public static void main(String[] args) throws IOException {



        Socket socket = new Socket("192.168.0.18",8888);
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        log.info("Send message");
        pw.write("eva\n");
        pw.flush();

        while (true){

            readStrean(socket.getInputStream());

        }

    }

    private static void readStrean(InputStream inputStream) throws IOException {
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNext()){
            System.out.println(scanner.nextLine());
        }
    }

}
