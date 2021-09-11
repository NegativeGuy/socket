package socket;


import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientReceiver extends Thread{
	private Socket sock;
	ClientReceiver(Socket sock){ this.sock = sock; }
	public void run() {
		InputStream in;
		String readData;
		try {
			in = sock.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			while(true) {
				readData = dis.readUTF(); // writeUTF 매서드와 연동되있음
				// writeUTF에서 입력값이 들어가면 작동(그 전까지는 대기상태)
				System.out.println(readData);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
