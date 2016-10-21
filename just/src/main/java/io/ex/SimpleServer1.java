package io.ex;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer1 {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		OutputStream out = null;
		try {
			serverSocket = new ServerSocket(8111);
			System.out.println("서버준비 완료");
			socket = serverSocket.accept();
			System.out.println("클라이언트 연결 완료");
			byte[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
			out = socket.getOutputStream();
			out.write(arr);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
				socket.close();
				serverSocket.close();
			} catch (IOException e) {
			}
		}
	}
}
