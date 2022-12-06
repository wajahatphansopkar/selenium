package tokenring;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPChatClient {
	DatagramSocket udpClientSocket; 
	 int port; 
	 
	 public UDPChatClient(int port) { 
	 this.port = port; 
	 }
	 
	 
	 
	 public void sendReq() { 
		 InetAddress serverAddress; 
		 String in; 
		 
		 try { 
		 udpClientSocket = new DatagramSocket();
		 InetAddress host = InetAddress.getLocalHost(); serverAddress = InetAddress.getByName(host.getHostName()); 
		 
		 BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in)); 
		 System.out.println("UDP Client-1 started at " + InetAddress.getLocalHost()); 
		 
		 while (true) { 
			 System.out.println("Enter message for server: "); in = keyRead.readLine(); 
			 DatagramPacket sndPacket = new DatagramPacket(in.getBytes(), in.getBytes().length, serverAddress, port); 
			 udpClientSocket.send(sndPacket); 
		 
		if(in.equalsIgnoreCase("bye")) 
		break;
		byte[] buf = new byte[1024]; 
		DatagramPacket recPacket = new DatagramPacket(buf, buf.length); 
		udpClientSocket.receive(recPacket); 
		 String msg = new String(recPacket.getData()).trim(); 
		 System.out.println("Message from " + recPacket.getAddress().getHostAddress() + ": " + msg); 
		 }
		}
		 catch(Exception e) { 
			 System.out.println(e.getMessage()); 
			} 
			 finally { 
			 udpClientSocket.close(); 
			 } 
		 }

	public static void main(String[] args) {
		UDPChatClient sender = new UDPChatClient(5001); 
		 sender.sendReq();

	}

}
