package io.ex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TestInputStream {
	public static void main(String[] args) {
		InputStream in = null;
		try {
			in = new FileInputStream("/Users/jaegyuhan/dev/javaEx/zzz/aaa.txt");
			while (true) {
				int data = in.read();
				System.out.println(data);
				if (data == -1) {
					break;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재 하지 않습니다.");
		} catch (IOException e) {
			System.out.println("IOException이 발생을 했습니다.");
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
