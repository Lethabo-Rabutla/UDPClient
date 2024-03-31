
package udpclient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UDPClient {

    public static void main(String[] args) {
       try(DatagramSocket ds = new DatagramSocket();){
           
           byte[] message;
           
           message = "Hello from UDP client".getBytes();
           
           InetSocketAddress ep = new InetSocketAddress("127.0.8.1",1000);
           
           DatagramPacket p = new DatagramPacket(message,message.length, ep);
           
           ds.send(p);
           
           message = new byte[128];
           
           p = new DatagramPacket(message, message.length, ep);
           
           ds.receive(p);
           
           System.out.println(new String(p.getData(),0,p.getLength()));
           
           
       }catch(SocketException exc){
           System.out.println(exc.getMessage());
       } catch (IOException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
