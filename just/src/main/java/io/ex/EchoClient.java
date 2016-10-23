package io.ex;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/*
 * 사용자로 부터 키보드로 문자열을 입력 받은 다음
 * 지정된 서버로 문자열을 전송 한다. 
 * 1. 문자열을 입력 받는다.
 * 2. Socket를 생성한다. 
 * 3. OutputStream을 생성 한다.
 * 4. outputStream을 통해 지정된 서버로 문자열을 보낸다.
 * 5. InputStream을 생성 한다.
 * 6. inputstream을 통해 서버에서 보내오는 문자열을 read한다.
 * */
public class EchoClient {
	public static void main(String[] args) {
		Socket socket = null;
		OutputStream out = null;
		DataOutputStream dos = null;

		InputStream in = null;
		DataInputStream din = null;
		try {
			socket = new Socket("localhost", 8111);
			System.out.println("서버에 연결 되었습니다.");
			out = socket.getOutputStream();
			dos = new DataOutputStream(out);

			in = socket.getInputStream();
			din = new DataInputStream(in);

			Scanner sc = new Scanner(System.in);
			while (true) {
				System.out.println("전송할 메시지를 입력해 주세요! ");
				String str = sc.nextLine();
				dos.writeUTF(str);
				dos.flush();

				if (str.equals("EXIT")) {
					System.out.println("클라이언트 종료 합니다.");
					break;
				}

				String readMsg = din.readUTF();
				System.out.println("받은 메시지 : " + readMsg);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				din.close();
				in.close();
				dos.close();
				out.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
