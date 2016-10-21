package io.ex;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer2 {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		OutputStream out = null;
		DataOutputStream dos = null;

		try {
			serverSocket = new ServerSocket(8111);
			System.out.println("서버가 올라 갔습니다.");
			socket = serverSocket.accept();
			System.out.println("클라이언트가 접속 했습니다. : " + socket);
			out = socket.getOutputStream();
			dos = new DataOutputStream(out);
			String str = "이건 문장 입니다.";
			dos.writeUTF(str);
			System.out.println("문장을 보냈습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dos.close();
				out.close();
				socket.close();
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
