package io.ex;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer1 {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket(8111);

			for (int i = 0; i < 10; i++) {
				
				/*
				 * listener을 10개 띄운다.
				 * 즉 클라이언트가 10개 접속 가능하다. 
				 * */
				Socket socket = serverSocket.accept();
				System.out.println(socket);
				socket.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
