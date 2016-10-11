package io.ex;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class DataInputEx {
	public static void main(String[] args) {
		InputStream in = null;
		DataInputStream dis = null;
		try {
			in = new FileInputStream("ddd.txt");
			dis = new DataInputStream(in);
			String str = dis.readUTF();
			System.out.println(str);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				dis.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
