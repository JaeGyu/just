package io.ex;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		InputStream in = null;
		DataInputStream dis = null;
		OutputStream out = null;
		DataOutputStream dos = null;
		InputStream fin = null;
		try {
			serverSocket = new ServerSocket(8111);
			System.out.println("서버 준비 완");
			socket = serverSocket.accept();
			System.out.println("소켓 연결 완료");

			in = socket.getInputStream();
			dis = new DataInputStream(in);
			out = socket.getOutputStream();
			dos = new DataOutputStream(out);

			String fileNameStr = dis.readUTF();
			System.out.println("사용자가 요청한 파일:" + fileNameStr);

			fin = new FileInputStream(fileNameStr);

			while (true) {
				int data = fin.read();

				if (data == -1) {
					break;
				}

				dos.write(data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fin.close();
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
