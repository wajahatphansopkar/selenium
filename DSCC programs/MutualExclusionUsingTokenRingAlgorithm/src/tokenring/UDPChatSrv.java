package tokenring;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPChatSrv {
	
	public DatagramSocket udpSrvSocket; public int 
	port; 
	String in;
	
	
	public UDPChatSrv(int port) { 
		 this.port = port; 
		}
	
	
	private void listen() { 
		try { 
		 udpSrvSocket = new DatagramSocket(port); 
		 BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in)); 
		 String msg; 
		 int [] clientPortA = new int[2]; 
		InetAddress clientAddress; 
		int clientPort, clientCnt = 0; int tokenTo = -1, currentClient = -1; 
		 DatagramPacket recPacket, sndPacket; 
		 System.out.println("Server started at " + InetAddress.getLocalHost()); 
		 
		 while (true) { 
		 byte[] buf = new byte[1024]; 
		//System.out.println("while @server");
		 recPacket = new DatagramPacket(buf, buf.length); 
		 
		 // blocks until a packet is received 
		udpSrvSocket.receive(recPacket); msg = new String(recPacket.getData()).trim(); 
		clientAddress = recPacket.getAddress(); 
		clientPort = recPacket.getPort(); 
		 
		 boolean clientPortPresent = false;
		 
		 int i; 
		 for(i = 0; i < clientPortA.length; i++) { 
		if(clientPortA[i] == clientPort) { 
		 clientPortPresent = true; 
		currentClient = i; break; 
		 } 
		 } 
		 if(clientPortPresent == false) { 
		clientPortA[clientCnt] = clientPort; 
		currentClient = clientCnt; clientCnt++; 
		 } 
		 //System.out.println("Message from client " + currentClient + ": " + msg); 
		 
		 if(tokenTo == -1 && clientCnt == 1) { 
		 tokenTo = 0; //Assign token to 1st client in d list 
		 System.out.println("send Message :- Token assigned to client " + currentClient); 
		 in = "Token assigned"; 
		 sndPacket = new DatagramPacket(in.getBytes(), in.getBytes().length, clientAddress, clientPortA[currentClient]); udpSrvSocket.send(sndPacket); 
		 }
		 if(msg.contains("token")) { 
			 if(tokenTo == currentClient) { 
			  if(clientPortA.length == tokenTo) 
			  tokenTo = 0; 
			  else 
			  tokenTo++; 
			  System.out.println("send Message :- Token assigned to client " + currentClient); 
			  //in = keyRead.readLine(); 
			 in = "Token assigned"; 
			  sndPacket = new DatagramPacket(in.getBytes(), in.getBytes().length, 
			 clientAddress, clientPortA[tokenTo]); udpSrvSocket.send(sndPacket); 
			  } 
			  else { 
			  System.out.println("send Message :- "); 
			  //in = keyRead.readLine(); 
			  in = "Token is with Client - " + tokenTo +". Wait for your turn."; 
			  sndPacket = new DatagramPacket(in.getBytes(), in.getBytes().length, 
			 clientAddress, clientPortA[currentClient]); udpSrvSocket.send(sndPacket); 
			  } 
			 } 
			  else { 
			  if(currentClient == tokenTo) { 
			  System.out.println("send Message :- "); 
			  in = keyRead.readLine(); //in =  "Token assigned"; 
			  sndPacket = new DatagramPacket(in.getBytes(), in.getBytes().length, 
			 clientAddress, clientPortA[currentClient]); 
			  udpSrvSocket.send(sndPacket); 
			  } 
			  else{
				  System.out.println("send Message :- "); 
				  //in = keyRead.readLine(); 
				  in = "Token is with Client  - " + tokenTo +". Wait for your turn."; 
				  sndPacket = new DatagramPacket(in.getBytes(), in.getBytes().length, 
				 clientAddress, clientPortA[currentClient]); udpSrvSocket.send(sndPacket); 
				  } 
				  
				  } 
				  /*if(msg.equalsIgnoreCase("bye")) 
				  clientCnt--; 
				  */ 
				  } 
				 } 
				  catch(Exception e) { 
				  System.out.println(e.getMessage()); 
				  } 
				 finally { 
				 udpSrvSocket.close(); 
				 } 
			 }
			  

	public static void main(String[] args) {
		UDPChatSrv client = new UDPChatSrv(5001); 
		 client.listen();

	}

}
