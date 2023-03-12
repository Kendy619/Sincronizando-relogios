import java.time.Clock;
import java.time.Instant;
import java.io.IOException;
import java.net.*;

public class SlavesThread extends Thread {
    public int id;
    public int timestamp = 0;
    private DatagramSocket bcs;
    private DatagramPacket pkg;

    public SlavesThread(int id, DatagramSocket bcs, int timestamp) throws SocketException {
        this.id = id;
        this.bcs = bcs;
        this.pkg = new DatagramPacket(new byte[256], 256);
        this.timestamp = timestamp;
    }

    public void run() {
        System.out.println("thread id: " + this.getName() + " timestamp: " + this.timestamp + bcs.getLocalPort());
        while (true) {
            System.out.println("Thread " + id + " rodando");
            try {
                bcs.receive(pkg);
                String data = new String(pkg.getData(), 0, pkg.getLength());
                System.out.println("Dados recebidos: " + data + " pela thread " + id);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }
    }

}