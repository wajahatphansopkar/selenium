package multiclient;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServRequest {
	private Socket socket;
	@SuppressWarnings("unused")
		private ChatServer chatServer;
	
	public ServRequest(Socket socket,ChatServer chatServer) {
		this.socket=socket;
		this.chatServer=chatServer;
	}
	public void run()
	{
		try{
			DataInputStream dis=new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			
			DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
			
			BufferedReader keyRead=new BufferedReader(new InputStreamReader(System.in));
			boolean done=false;
			
			while(!done) {
				String line=dis.readUTF();
				System.out.println("Client Msg-"+line+"\n");
				done=line.equals("bye");
				line=keyRead.readLine();
				dos.writeUTF(line);
				dos.flush();
			}
			dis.close();
			socket.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		

	}

}
