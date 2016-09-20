package threadEx;

public class ThreadAForYield extends Thread {
	public boolean stop = false;
	public boolean work = true;

	@Override
	public void run() {

		while (!stop) {
			if (work) {
				System.out.println("ThreadAForYield 작업 내용");
			} else {
				System.out.println("A가 양보함");
				Thread.yield();
			}
		}
		System.out.println("ThreadAForYield 종료");
	}
}
