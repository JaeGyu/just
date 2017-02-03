package java8.thread;

/*
 * 10개의 스레드를 생성해서 각각 누적을 구한다음
 * 
 * 최종적으로 10개 스레드의 누적들을 더한 값을 구한다.
 * */
public class ThreadRun11 {
	public static void main(String[] args) {
		long tot = 0;
		for (int i = 1; i <= 10; i++) {
			Sum sum = new Sum(i);
			if (i == 10) {
				sum.setPriority(Thread.MAX_PRIORITY);
			}
			sum.start();
			try {
				sum.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			tot += sum.getNum();
		}

		System.out.println("tot : " + tot);
	}
}

class Sum extends Thread {
	private long num;

	public Sum(int i) {
		setName("Sum" + i);
	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(100);
				System.out.println(getName() + " : " + Thread.currentThread().getState());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			num += i;
		}
	}

}
