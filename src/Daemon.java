import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

public class Daemon {

    public static void main(String[] args) {
        Integer timestamp = 10;
        

        try {
            InetAddress addr = InetAddress.getByName("255.255.255.255");
            byte[] time = timestamp.toString().getBytes();
            
            ArrayList<DatagramPacket> packets = new ArrayList();


            System.out.println(Utils.sockets.size());
            // Criando os pacotes
            for (int i = 0; i < Utils.sockets.size(); i++) {
                System.out.println(Utils.sockets.get(i));
                packets.add(new DatagramPacket(time, time.length, addr, Utils.sockets.get(i)));
            }

            DatagramSocket ds = new DatagramSocket();
            for (DatagramPacket datagramPacket : packets) {
                ds.send(datagramPacket);
            }

        } catch (Exception e) {
            System.out.println("Nao foi possivel enviar a mensagem");
        }
    }
}