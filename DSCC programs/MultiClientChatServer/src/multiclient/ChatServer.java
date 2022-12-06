package multiclient;

import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	int port;
	ServerSocket serverSocket;
	Socket socket;
	
public ChatServer(int port) {
	super();
	this.port=port;
}

public void listen() {
	try {
		serverSocket=new ServerSocket(port);
		System.out.println("Listening on ip:"+serverSocket.getInetAddress().getHostAddress()+"and port:"+port);
		while(true)
		{
			socket=serverSocket.accept();
			System.out.println("Client Accepted"+socket);
			ServRequest sr=new ServRequest(socket,this);
			sr.start();
		}
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
}

	public static void main(String[] args) {
		ChatServer cs=new ChatServer(5000);
		cs.listen();
		

	}

}
