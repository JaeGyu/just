package network.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocketEx {
	public static void main(String[] args) {

		Socket sc = null;

		try {
			sc = new Socket("127.0.0.1", 5050);

			BufferedReader bf = new BufferedReader(new InputStreamReader(sc.getInputStream()));

			PrintWriter pw = new PrintWriter(sc.getOutputStream());
			pw.println("Client~~~~");
			pw.flush();

			System.out.println(bf.readLine());
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				sc.close();
			} catch (IOException e) {
			}
		}

	}
}
