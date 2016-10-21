package io.ex;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SimpleClient2 {
	public static void main(String[] args) {
		Socket socket = null;
		InputStream is = null;
		DataInputStream dis = null;

		try {
			socket = new Socket("localhost", 8111);
			is = socket.getInputStream();
			dis = new DataInputStream(is);
			System.out.println(dis.readUTF());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dis.close();
				is.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
