package io.ex;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

import org.junit.Test;

public class TestOutputStream {
	public static void main(String[] args) {
		OutputStream out = null;
		try {
			out = new FileOutputStream("aaa.txt");
			String str = "이 문자열을 파일에 기록하고 싶습니다.";
			byte[] arr = str.getBytes();
			out.write(arr);
		} catch (FileNotFoundException e) {
			System.out.println("저장할 파일을 찾지 못 했습니다.");
		} catch (IOException e) {
			System.out.println("IO익셉션이 발생 했습니다.");
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void testGetByte() throws Exception {
		/*
		 * 한글을 3byte로 처리 하고 있다.
		 */
		String str = "한글";
		byte[] arr = str.getBytes();
		System.out.println(Arrays.toString(arr));
	}

	@Test
	public void testGetByteForChar() throws Exception {
		char chr = "한".charAt(0);
		System.out.println(chr);
		Character ch = chr;
		System.out.println(ch.BYTES);
	}
}
