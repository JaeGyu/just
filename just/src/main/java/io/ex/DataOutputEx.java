package io.ex;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class DataOutputEx {
	public static void main(String[] args) throws Exception {
		String str = "이 문자열을 기록해 볼까 합니다.";
		OutputStream out = new FileOutputStream("ddd.txt");
		DataOutputStream dos = new DataOutputStream(out);
		dos.writeUTF(str);
		dos.close();
		out.close();
	}
}
