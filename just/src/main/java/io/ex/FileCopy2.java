package io.ex;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy2 {
	public static void main(String[] args) {
		InputStream in = null;
		OutputStream out = null;

		try {
			in = new FileInputStream("/Users/jaegyuhan/dev/javaEx/zzz/bbb.txt");
			out = new FileOutputStream("ccc.txt");

			byte[] arr = new byte[5];
			while (true) {
				int count = in.read(arr);
				if (count == -1) {
					break;
				}

				out.write(arr, 0, count);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
