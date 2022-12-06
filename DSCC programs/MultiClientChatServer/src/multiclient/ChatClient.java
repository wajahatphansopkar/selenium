package multiclient;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class ChatClient {
	Socket socket;
	int port;
	
	public ChatClient(int port) {
		super();
		this.port=port;
	}
	public void request() {
		try {
			InetAddress host=InetAddress.getLocalHost();
			socket=new Socket(host.getHostName(),port);
			
			DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
			
			DataInputStream dis=new DataInputStream(socket.getInputStream());
			System.out.println("Connected");
			BufferedReader keyRead=new BufferedReader(new InputStreamReader(System.in));
			String line="";
			
			while(!line.equals("bye")) {
				line=keyRead.readLine();
				dos.writeUTF(line);
				dos.flush();
				line=dis.readUTF();
				System.out.println("Server reply-"+line);
			}
			keyRead.close();
			dos.close();
			socket.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		ChatClient cc=new ChatClient(5000);
		cc.request();

	}

}
