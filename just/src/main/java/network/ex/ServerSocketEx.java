package network.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketEx {
	public static void main(String[] args) throws InterruptedException {
		ServerSocket ssc = null;
		Socket sc = null;

		try {
			ssc = new ServerSocket(5050);
			System.out.println("Ready to Connect....");

			sc = ssc.accept();
			System.out.println("connected!");

			BufferedReader bf = new BufferedReader(new InputStreamReader(sc.getInputStream()));

			PrintWriter pw = new PrintWriter(sc.getOutputStream());
			System.out.println(bf.readLine());
			pw.println("Hi, Hello~~");
			pw.flush();
			
			Thread.sleep(10000);
			
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			try {
				sc.close();
			} catch (IOException e) {
			}
			
			try {
				ssc.close();
			} catch (IOException e) {
			}
		}
	}

}
