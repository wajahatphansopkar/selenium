package rpc;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.StringTokenizer;

public class Server {
	private DatagramSocket udpSocket; 
	 private int port; 
	 
	 public Server(int port) { 
	this.port = port; 
	 } 
	 public static int addition(int num1,int num2) 
	 { 
	 return num1+num2; 
	 } 
	 public static int substraction(int num1,int num2) 
	 { 
	 return num1-num2; 
	 } 
	 public static int multiplication(int num1,int num2) 
	 { 
	 return num1*num2; 
	 } 
	 public static int division(int num1,int num2) 
	 { 
	 return num1/num2; 
	 }
	 
	 private void listen() { 
		 try { 
		  DatagramSocket udpSocket = new DatagramSocket(port); 
		  System.out.println("Server started at " + InetAddress.getLocalHost()); 
		  String msg; 
		  
		  
		  byte[] buf = new byte[1024]; 
		  DatagramPacket packet = new DatagramPacket(buf, buf.length); 
		  
		  // blocks until a packet is received 
		 udpSocket.receive(packet); msg = new String(packet.getData()).trim(); 
		  
		  StringTokenizer str=new StringTokenizer(msg,"-"); 
		  int mthNo=Integer.parseInt(str.nextToken()); 
		  int num1=Integer.parseInt(str.nextToken()); 
		  int num2=Integer.parseInt(str.nextToken()); 
		  int result; if(mthNo==1) 
		  { 
		  result=addition(num1,num2); 
		 msg="Addition:"+result; 
		  } 
		 if(mthNo==2) 
		  { 
		  result=substraction(num1,num2); 
		 msg="substraction:"+result; 
		  } 
		 if(mthNo==3) 
		 { 
		  result=multiplication(num1,num2); 
		 msg="multiplication:"+result;
		 
		 } 
		 if(mthNo==4) 
		  { 
		  result=division(num1,num2); 
		 msg="division:"+result; 
		  } 
		  
		  System.out.println("Message from " + packet.getAddress().getHostAddress() + 
		 ": " + msg); 
		  
		 } 
		  catch(Exception e) { 
		  System.out.println(e.getMessage()); 
		  } 
		 finally { 
		  //udpSocket.close(); 
		  } 
		 }

	public static void main(String[] args) {
		Server client = new Server(5002); 
		client.listen(); 

	}

}
