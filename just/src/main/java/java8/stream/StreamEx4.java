package java8.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StreamEx4 {
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("aaa.txt");

		Files.lines(path, Charset.defaultCharset()).forEach(System.out::println);
		System.out.println();

		File file = path.toFile();
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		br.lines().forEach(System.out::println);

	}
}
