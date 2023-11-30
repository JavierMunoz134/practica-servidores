package ServidorContinuo;

import java.net.*;

public class ClienteHora {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            byte[] buffer = "time".getBytes();

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, serverAddress, 9876);
            socket.send(packet);

            byte[] responseBuffer = new byte[256];
            DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);
            socket.receive(responsePacket);

            String hora = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("Hora recibida: " + hora);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
