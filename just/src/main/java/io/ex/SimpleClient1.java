package io.ex;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SimpleClient1 {
	public static void main(String[] args) {
		Socket socket = null;
		InputStream is = null;
		try {
			socket = new Socket("localhost", 8111);
			System.out.println("서버 연결 완료!");
			is = socket.getInputStream();
			int str = 0;
			while ((str = is.read()) != -1) {
				System.out.println(str);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
