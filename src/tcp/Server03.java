package tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

class UserThread extends Thread{ 
	// 메인과는 별개로 동작하는 공간을 만들기 위해 쓰레드 사용 (read와 write기능을 씀)
	Socket s;
	public UserThread(Socket s) {
		this.s = s;
		System.out.println(s.getInetAddress()+"님이 접속했습니다");
		start(); //run 매서드 실행 기능
	}
	
	public void run() {
		InputStream in;
		String readData = null;
		try {
			in = s.getInputStream(); // 접속한 클라이언트를 통해서 스트림 연결
			DataInputStream dis = new DataInputStream(in);
		
			// 한번의 수신만 받는 코드
			readData = dis.readUTF();
			System.out.println("수신 데이터 : "+readData);
			
			// 무한한 수신을 받는 방법
//			while(true){				
//				readData = dis.readUTF();
//				System.out.println("수신 데이터 : "+readData);
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

public class Server03 {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(12345); //소켓 생성
		while(true) { // 무한 접속 대기
			System.out.println("접속을 기다립니다");
			Socket s = server.accept();  //클라이언트가 접속요청하면
			new UserThread(s); // 클라이언트 정보를 쓰레드로 보냄
		}
	}
}
