package threadEx;

public class JoinExample {
	public static void main(String[] args) {
		SumThread sumThread = new SumThread();
		sumThread.start();

		try {
			/*
			 * sumThread 가 다끝날때 까지 기다린다.
			 * */
			sumThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("1~100 합: " + sumThread.getSum());
	}
}
