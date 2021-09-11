package tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client01 {
	public static void main(String[] args) throws Exception {//(예외처리)
		// 서버와 접속 시도 (접속하고자하는 서버ip, 포트번호)
		Socket sock = new Socket("localhost", 12345);
		// (이 코드는 내부에서 접속하기 때문에 localhost로 ip를 작성해줌)
		// 만약 외부에 접속하려면 그 외부서버의 ip와 포트번호를 적어줌
		
		//서버와 연결된 통로(Stream) 만듬
		OutputStream out = sock.getOutputStream();
		
		System.out.println("수 입력");
		int num = new Scanner(System.in).nextInt();
		out.write(num);
		
		out.close();  // 나중에 연 것부터 닫아줌
		sock.close(); // 먼저 열었기 때문에 나중에 닫음
	}
}
