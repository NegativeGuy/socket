package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client03 {
	public static void main(String[] args) throws Exception {
		
		Socket sock = new Socket("127.0.0.1",12345);
		
		OutputStream os = sock.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		
		// 한번만 발신을 보내는 방법 (한번 보낸 후 통신이 종료됨)
		System.out.println("전송 데이터 입력");
		String s = new Scanner(System.in).next();		
		dos.writeUTF(s);
		System.out.println("전송 완료");

		// 무한한 발신을 보내는 방법
//		while(true) {
//			
//			System.out.println("전송 데이터 입력");
//			String s = new Scanner(System.in).next();		
//			dos.writeUTF(s);
//			System.out.println("전송 완료");
//		}
		
		// 무한한 발신의 경우 아래 코드들도 주석처리 해야함 스트림이 끊어지기 때문
		dos.close();
		os.close();
		sock.close();
	}
}
