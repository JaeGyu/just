package io.ex;

import java.io.File;
import java.io.IOException;

public class FileEx {
	public static void main(String[] args) throws IOException {
		File file = new File("aaa.txt");
		String absolutPath = file.getAbsolutePath();
		System.out.println("절대 경로:" + absolutPath);
		boolean isFile = file.isFile();
		System.out.println("파일 여부 : " + isFile);
		System.out.println("디렉토리 여부 : " + file.isDirectory());
		System.out.println("경로 구분자 : " + file.separator);
		System.out.println(file.getCanonicalPath());
		System.out.println(file.getPath());
	}
}
