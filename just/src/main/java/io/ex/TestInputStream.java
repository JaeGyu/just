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
				
				//read()는 1byte를 읽어 드린다.
				int data = in.read();
				System.out.println(data);
				
				/*
				 * read()시 한바이트를 읽어오게 되면 -127~127 사이의 값을 대상으로 하지만
				 * 리턴되는 타입은 int이다. 이는 read()내부적으로 -127~127사이의 값에 255를 더해서
				 * 어떠한 경우에도 양수의 값을 리턴하기위함이다. 
				 * 따라서 -1이 나오면 더이상 읽을 값이 없다는 뜻이다. EOF
				 * */
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
