package io.ex;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class ObjectReadTest {
	public static void main(String[] args) {
		InputStream is = null;
		ObjectInputStream ois = null;

		try {
			is = new FileInputStream("person.dat");
			ois = new ObjectInputStream(is);

			PersonInfo p = (PersonInfo) ois.readObject();
			System.out.println(p.getAge());
			System.out.println(p.getName());
			System.out.println(p.getSsn());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
