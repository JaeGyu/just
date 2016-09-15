package threadEx;

public class FirstThreadEx {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Task());
		
		t1.start();
		System.out.println("Main Thread!!");
	}
}

/*
 * 쓰레드가 실행할 수 있는 코드를 가진 객체이다.
 * 이객체는 작업 명세를 가지고 있다.
 * 실제 쓰레드는 아니다. 
 * */
class Task implements Runnable{

	@Override
	public void run() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread!!!");
	}
	
}
