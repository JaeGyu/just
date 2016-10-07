package io.ex;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ByteWriteWay {
	public static void main(String[] args) throws IOException {
		String str = "이 문자열을 기록해볼까요?\n";
		OutputStream out = new FileOutputStream("aaaa.txt");
		byte[] arr = str.getBytes();
		out.write(arr);
		out.close();
	}
}
