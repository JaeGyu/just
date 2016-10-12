package io.ex;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteEx {
	public static void main(String[] args) {
		String str = "이 문자열을 기록 할 겁니다.";
		Writer w = null;
		try {
			w = new FileWriter("eee.txt");
			w.write(str);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				w.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
