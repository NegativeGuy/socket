package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client02 {
	public static void main(String[] args) throws Exception {
		
		// 서버에 접속 요청 (서버ip, 포트번호)
		Socket sock = new Socket("127.0.0.1",12345);
		
		// 접속 후 기본 스트림 연결 (데이터를 보내기 때문에 output스트림으로)
		OutputStream os = sock.getOutputStream();
		
		// String형으로 데이터를 보내기 위해 보조 스트림 생성
		DataOutputStream dos = new DataOutputStream(os);
		
		System.out.println("발신 데이터 입력");
		String s = new Scanner(System.in).next();
		dos.writeUTF(s);
		System.out.println("전송 완료");
		
		//---------서버로 부터 데이터 수신하는 코드
		
		InputStream is = sock.getInputStream();
		DataInputStream ids = new DataInputStream(is);
		
		System.out.println("수신데이터 : "+ids.readUTF());
		
		ids.close();
		is.close();
		
		//-------------------
		
		dos.close();
		os.close();
		sock.close();
		System.out.println("통신 종료");
	}
}
