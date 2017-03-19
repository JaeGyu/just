package threadEx2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Thd2 {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		System.out.println(Runtime.getRuntime().availableProcessors());
		ExecutorService executorService2 = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

		ExecutorService executorService3 = new ThreadPoolExecutor(3, 100, 120L, TimeUnit.SECONDS,
				new SynchronousQueue<Runnable>());
		
		
	}
}
