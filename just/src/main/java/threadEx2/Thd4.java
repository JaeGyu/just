package threadEx2;

public class Thd4 {
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(()->{
			System.out.println("Hello from new Thread");
			System.out.println(Thread.currentThread().getName());
		});
		
		t1.setName("Alice");
		t1.start();
		
		System.out.println(Thread.currentThread().getName());
		Thread.yield();
		
		System.out.println("Hello from main Thread");
		
		t1.join();
	}
}
