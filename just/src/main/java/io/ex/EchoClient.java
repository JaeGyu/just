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

		InputStream is = null;
		DataInputStream dis = null;
		try {
			socket = new Socket("localhost", 8111);
			out = socket.getOutputStream();
			dos = new DataOutputStream(out);
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			dos.writeUTF(str);
			System.out.println("현재 보냈음!!");

			is = socket.getInputStream();
			dis = new DataInputStream(is);
			System.out.println("받은 문자열 : " + dis.readUTF());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dis.close();
				is.close();
				dos.close();
				out.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
