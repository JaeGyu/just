package java8.thread;

import java.io.IOException;

public class ThreadRun15 {
	public static void main(String[] args) throws IOException {
//		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		System.out.println(Runtime.getRuntime().freeMemory() / 1024 / 1024);
		System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);
		System.out.println(Runtime.getRuntime().availableProcessors());
	}
}
