package java8.ex;

public class RunnableExample {
	public static void main(String[] args) {

		/*
		 * 자바의 기본 API들중 추상메서드가 하나만 있는 경우는 아래와 같이 람다를 이용할 수 있다.
		 * 
		 * 원래는 익명 객체를 생성해서 사용하거나 아님 Runnable인터페이스를 구현한 
		 * 객체를 이용하는데 아래처럼 표현하면 좀더 간결해진다.
		 */
		Runnable runnable = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(i);
			}
		};

		Thread thread = new Thread(runnable);
		thread.start();

		Runnable runnable2 = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 20; i++) {
					System.out.println(i);
				}
			}
		};

		Thread thread2 = new Thread(runnable2);
		thread2.start();

		// 이렇게 해도 된다.
		Thread thread3 = new Thread(() -> {
			for (int i = 0; i < 30; i++) {
				System.out.println(i);
			}
		});

		thread3.start();
	}
}
