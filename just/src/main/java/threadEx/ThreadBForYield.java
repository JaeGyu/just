package threadEx;

public class ThreadBForYield extends Thread {
	public boolean stop = false;
	public boolean work = true;

	@Override
	public void run() {
		while (!stop) {
			if (work) {
				System.out.println("ThreadBForYield 작업 내용");
			} else {
				System.out.println("B가 양보함");
				Thread.yield();
				
			}
		}
		System.out.println("ThreadBForYield 종료");
	}
}
