package io.ex;

import java.net.Socket;

public class SocketTest {
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost", 8111);
		System.out.println("연결 되었습니다. :" + socket);
		socket.close();
	}
}
