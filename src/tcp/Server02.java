package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server02 {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(12345);
		System.out.println("서버 실행...");
		Socket sock = server.accept(); // 클라이언트 접속 대기
		
		// 클라이언트 접속 후 클라이언트의 정보(ip 등) 얻고나서 실행
		// 클라이언트로부터 데이터를 받기 때문에 input스트림으로 생성
		InputStream is = sock.getInputStream();
		
		//보조 스트림 (String형 데이터를 받아오기 위해)
		DataInputStream di = new DataInputStream(is); 
		System.out.println("수신 대기...");
		
		String readData = di.readUTF(); // 클라이언트가 write를 실행해야 실행됨
		System.out.println("수신 데이터 : "+readData);
		
		//-------서버에서 클라이언트에게 발신하는 코드
		System.out.println("클라이언트에게 발송 할 데이터 입력");
		String s = new Scanner(System.in).next();
		
		OutputStream os = sock.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		
		dos.writeUTF(s);
		
		dos.close();
		os.close();
		//--------------------
		
		di.close();
		is.close();
		sock.close();
		server.close();	
		System.out.println("통신 종료");
	}
}
