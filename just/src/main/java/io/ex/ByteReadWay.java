package io.ex;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class ByteReadWay {
	public static void main(String[] args) throws Exception {
		InputStream in = new FileInputStream("aaaa.txt");
		Scanner sc = new Scanner(in);

		while (true) {
			try {
				String str = sc.nextLine();
				System.out.println(str);
			} catch (Exception e) {
				break;
			}
		}

		in.close();
		sc.close();

	}
}
