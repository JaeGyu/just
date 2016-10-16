package io.ex;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTest {
	public static void main(String[] args) throws Exception {

		ServerSocket serverSocket = new ServerSocket(8111);
		System.out.println("클라이언트 연결 대기중!");
		Socket socket = serverSocket.accept();
		System.out.println("클라이언트 연결: " + socket);
		socket.close();
		serverSocket.close();
	}
}
