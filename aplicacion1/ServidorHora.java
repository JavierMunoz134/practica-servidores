package ServidorContinuo;

import java.net.*;
import java.util.Date;

public class ServidorHora {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(9876);

            while (true) {
                byte[] buffer = new byte[256];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                socket.receive(packet);

                // Manejar cada solicitud en un hilo separado
                new Thread(() -> {
                    try {
                        InetAddress clientAddress = packet.getAddress();
                        int clientPort = packet.getPort();

                        if (new String(packet.getData(), 0, packet.getLength()).equals("time")) {
                            String hora = new Date().toString();
                            byte[] response = hora.getBytes();
                            DatagramPacket responsePacket = new DatagramPacket(response, response.length, clientAddress, clientPort);
                            socket.send(responsePacket);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
