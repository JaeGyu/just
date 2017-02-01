package java8.thread;

/*
 * 현재 Memory에는 어떠한 임계영역도 지정 되어 있지 않다.
 * 
 * USer1과 User2의 run()메서드에 synchronized(mem)을 설정하여 두 객체의 임계영역을 원자적으로 묶었다.
 * 동일한 공유변수때문에 묶이는 것같다. 즉 USer1의 쓰레드가 자신의 run()을 실행하고 있으면 USer2가 자신의 run()을 실행하지 못한다.
 * 왜냐하면 두 객체의 run()은 원자적으로 묶여 있기 때문이다. 
 * 
 * 아래의 결과는 원하는 결과가 나온다. 
 * 
 * */
public class ThreadSyncSummary4 {
	public static void main(String[] args) {

		Ts4_Memory mem = new Ts4_Memory();

		Ts4_User1 user1 = new Ts4_User1(mem);
		user1.start();
		Ts4_User2 user2 = new Ts4_User2(mem);
		user2.start();
	}
}

class Ts4_User1 extends Thread {

	private Ts4_Memory mem;

	public Ts4_User1() {
	}

	public Ts4_User1(Ts4_Memory mem) {
		this.mem = mem;
		setName("User1");
	}

	public void setMemory(Ts4_Memory mem) {
		this.mem = mem;
	}

	@Override
	public void run() {
		synchronized (mem) {
			System.out.println("user1 start");
			this.mem.setMem(100);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(this.getName() + ":" + this.mem.getMem());
		}
	}

}

class Ts4_User2 extends Thread {
	private Ts4_Memory mem;

	public Ts4_User2() {
	}

	public Ts4_User2(Ts4_Memory mem) {
		this.mem = mem;
		setName("User2");
	}

	public void setMemory(Ts4_Memory mem) {
		this.mem = mem;
	}

	@Override
	public void run() {
		synchronized (mem) {
			System.out.println("user2 start");
			this.mem.setMem(50);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(this.getName() + ":" + this.mem.getMem());
		}
	}
}

class Ts4_Memory {
	private int mem;

	public int getMem() {
		return mem;
	}

	public void setMem(int mem) {
		System.out.println("공유 객체의 set : " + Thread.currentThread().getName());
		this.mem = mem;
	}

}