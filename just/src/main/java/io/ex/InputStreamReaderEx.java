package io.ex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamReaderEx {
	public static void main(String[] args) {
		InputStream in = null;
		InputStreamReader isr = null;
		BufferedReader br = null;

		try {
			in = new FileInputStream("aaaa.txt");
			isr = new InputStreamReader(in);
			br = new BufferedReader(isr);

			while (true) {
				String str = br.readLine();
				if (str == null) {
					break;
				}

				System.out.println(str);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				isr.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
