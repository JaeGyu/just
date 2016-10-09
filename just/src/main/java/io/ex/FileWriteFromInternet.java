package io.ex;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class FileWriteFromInternet {
	public static void main(String[] args) {
		InputStream in = null;
		OutputStream out = null;

		try {
			URL url = new URL("http://sk.suwonlib.go.kr/");
			in = url.openStream();
			out = new FileOutputStream("internet.txt");

			byte[] arr = new byte[10];

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
