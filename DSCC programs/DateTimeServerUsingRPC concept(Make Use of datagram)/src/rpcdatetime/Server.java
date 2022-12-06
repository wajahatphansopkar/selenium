package rpcdatetime;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.time.LocalDateTime;

public class Server {
	private DatagramSocket udpSocket; 
	 private int port; 
	 
	 public Server(int port) { 
	this.port = port; 
	 } 
	 public static LocalDateTime date() 
	 {
		 return java.time.LocalDateTime.now(); 
	 } 
	 
	 private void listen() { 
	try { 
	 DatagramSocket udpSocket = new DatagramSocket(port); 
	 System.out.println("Server started at " + InetAddress.getLocalHost()); 
	 LocalDateTime msg; 
	 
	 
	 byte[] buf = new byte[1024]; 
	 DatagramPacket packet = new DatagramPacket(buf, buf.length); 
	 
	 // blocks until a packet is received 
	udpSocket.receive(packet); 
	 
	msg=date(); 
	 System.out.println("Message from " + packet.getAddress().getHostAddress() + ": " + msg); 
	 
	 } 
	 catch(Exception e) { 
	 System.out.println(e.getMessage()); 
	 } 
	 finally { 
	 //udpSocket.close(); 
	 } 
 }
	 

	public static void main(String[] args) {
		Server client = new Server(5003); 
		client.listen(); 


	}

}
