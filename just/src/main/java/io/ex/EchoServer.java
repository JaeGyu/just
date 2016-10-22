package io.ex;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 클라이언트로 부터 전송되온 문자열을 되돌려 준다.
 * 
 * */
public class EchoServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		InputStream in = null;
		DataInputStream dis = null;
		
		OutputStream out = null;
		DataOutputStream dos = null;

		try {
			serverSocket = new ServerSocket(8111);
			socket = serverSocket.accept();
			System.out.println("클라이언트가 붙었습니다.");
			in = socket.getInputStream();
			dis = new DataInputStream(in);
			String result = dis.readUTF();
			System.out.println("문자열을 읽었습니다. : " +result);
			
			out = socket.getOutputStream();
			dos = new DataOutputStream(out);
			dos.writeUTF(result);
			System.out.println("문자열을 보냈습니다. ");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dos.close();
				out.close();
				dis.close();
				in.close();
				socket.close();
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
