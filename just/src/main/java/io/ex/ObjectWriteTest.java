package io.ex;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ObjectWriteTest {
	public static void main(String[] args) {
		PersonInfo p = new PersonInfo();

		p.setAge(20);
		p.setName("Hong gil Dong");
		p.setSsn("123232323");

		OutputStream out = null;
		ObjectOutputStream oos = null;
		
		try {
			out = new FileOutputStream("person.dat");
			oos = new ObjectOutputStream(out);
			oos.writeObject(p);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
