import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Slaves {
    
    public static void main(String[] args) throws IOException {
        Integer timestamp = 0;
        int socketPortStart = 6001;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o numero de clientes");
        int quantityOfClients = scanner.nextInt();

        for (int i = 0; i < quantityOfClients; i++) {
            Utils.sockets.add(socketPortStart++);
        }

        for (int i = 0; i < Utils.sockets.size(); i++) {
            DatagramSocket socket = new DatagramSocket(Utils.sockets.get(i)); 
            SlavesThread t = new SlavesThread(i, socket, timestamp);
            timestamp = timestamp + 5;
            t.start();
        }
    }
}
