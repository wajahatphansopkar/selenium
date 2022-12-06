package rpcdatetime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
	DatagramSocket udpSocket; 
	 InetAddress serverAddress; 
	int port; 
	 Scanner scanner; 
	 
	 public Client(int port) { 
	this.port = port; 
	 } 
	 
	 public void sendReq() { 
	String in; try { 
	 udpSocket = new DatagramSocket(); 
	 InetAddress host = InetAddress.getLocalHost(); 
	serverAddress = InetAddress.getByName(host.getHostName()); 
	 
	 BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
	 
	 System.out.println("UDP Client started at " + InetAddress.getLocalHost()); 
	 String paramlist=""; 
	 DatagramPacket p = new DatagramPacket(paramlist.getBytes(), paramlist.getBytes().length, serverAddress, port); udpSocket.send(p); 
	 
	 } 
	 catch(Exception e) { 
	 System.out.println(e.getMessage()); 
	} 
	 } 

	public static void main(String[] args) {
		Client sender = new Client(5003); 
		sender.sendReq();

	}

}
