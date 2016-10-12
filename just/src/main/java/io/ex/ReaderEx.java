package io.ex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReaderEx {
	public static void main(String[] args) {
		Reader r = null;
		BufferedReader br = null;
		try {
			r = new FileReader("eee.txt");
			br = new BufferedReader(r);

			while (true) {
				String str = br.readLine();
				if (str == null) {
					break;
				}
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				r.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
