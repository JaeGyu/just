package io.ex;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTest {
	public static void main(String[] args) throws Exception {

		ServerSocket serverSocket = new ServerSocket(8111);
		System.out.println("클라이언트 연결 대기중!");
		Socket socket = serverSocket.accept(); // listener
		System.out.println("클라이언트 연결: " + socket);

		// 클라이언트가 하나 연결이 되면 자동으로 serverSocket를 close해서 서버를 내린다.
		socket.close();
		serverSocket.close();
	}
}
