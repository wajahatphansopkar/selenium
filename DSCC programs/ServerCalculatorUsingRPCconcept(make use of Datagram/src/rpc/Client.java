package rpc;

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
	 String in; 
	try { 
	 udpSocket = new DatagramSocket(); 
	 InetAddress host = InetAddress.getLocalHost(); serverAddress = InetAddress.getByName(host.getHostName()); 
	 
	 BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in)); 
	 System.out.println("UDP Client started at " + InetAddress.getLocalHost()); 
	 String paramlist=""; 
	 System.out.println("Enter Method:\n1.Addition:\n2.Subtraction\n3.Multiplication\n4.Devision"); 
	 in = keyRead.readLine(); paramlist=paramlist+in+"-"; 
	 System.out.println("Enter Number 1:"); 
	 in = keyRead.readLine(); 
	paramlist=paramlist+in+"-"; 
	
	System.out.println("Enter Number 2:"); 
	 in = keyRead.readLine(); 
	paramlist=paramlist+in; 
	 DatagramPacket p = new DatagramPacket(paramlist.getBytes(), 
	paramlist.getBytes().length, serverAddress, port); udpSocket.send(p); 
	 
	 } 
	 catch(Exception e) { 
	 System.out.println(e.getMessage()); 
	} 
	 } 


	public static void main(String[] args) {
		Client sender = new Client(5002); 
		sender.sendReq();

	}

}
