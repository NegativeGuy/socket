package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server01 {
	public static void main(String[] args) throws IOException {
		
		// 서버 등록 (예외처리(throws IOException) 해야함)
		ServerSocket server = new ServerSocket(12345);
		// 자기자신의 ip와 port번호(12345)로 구동해줌 
		// 서버 클래스는 자동으로 자신의 ip설정됨, 포트번호만 임의로 설정해줌
		
		// port : 2byte크기를 가짐, 특정 프로그램(어플리케이션)를 구분지어준다
		// 2byte는 0~65535 까지 가능 (이 사이의 값에서 임의로 지정)
		// 포트번호가 겹치지 않기 위해 웰론포트는 피해서 정해준다
		// 웰론포트 : 자주 사용하는 포트번호
		
		// 서버 		: 서비스를 제공하는 컴퓨터
		// 클라이언트 	: 서비스를 제공 받는 컴퓨터
		
		System.out.println("접속 대기합니다");
		Socket sock = server.accept(); // 클라이언트의 접속요청 대기
		// sock 변수는 접속을 요청한 사용자(클라이언트)의 정보를 저장하는 역할
		// 접속사의 수만큼 sock변수가 필요함(1:1 매칭)
		
		// 위에서 접속을 대기 중이기 때문에 누군가 접속하기 전까지 아래 메시지가 안뜸
		System.out.println("접속 되었습니다");
		// 클라이언트에서 접속 요청이 들어오면 위의 메시지 출력됨
		
		System.out.println(sock.getInetAddress());
		// 접속한 사용자의 정보 (127.0.0.1)은 자기자신의 ip
		
		// 클라이언트로부터 데이터를 받기 위한 통로(Stream) 만듬
		InputStream input = sock.getInputStream(); 
		
		int readData = input.read();
		System.out.println("수신 데이터 : "+readData);
		input.close();
	}
}
