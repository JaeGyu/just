package io.ex;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class FileClient {
	public static void main(String[] args) {
		Socket socket = null;
		Scanner sc = null;
		InputStream in = null;
		DataInputStream dis = null;
		OutputStream out = null;
		DataOutputStream dos = null;

		try {
			socket = new Socket("localhost", 8111);
			sc = new Scanner(System.in);

			in = socket.getInputStream();
			dis = new DataInputStream(in);
			out = socket.getOutputStream();
			dos = new DataOutputStream(out);

			System.out.println("받고 싶은 파일명을 입력 하세요!");
			String fileNameMsg = sc.nextLine();

			dos.writeUTF(fileNameMsg);

			System.out.println("서버에 메시지를 보냈습니다.");
			System.out.println("서버가 보내는 파일 데이터를 받아 봅시다.");

			while (true) {
				int data = dis.read();
				if (data == -1) {
					break;
				}

				System.out.println(data);
			}
			System.out.println("파일 전송이 완료 되었습니다.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dos.close();
				out.close();
				dis.close();
				in.close();
				sc.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
