package java8.thread;

/*
* Ts1_User1 객체가 Ts1_Memory에 100을 세팅 후 2초를 쉰다.
* 그때 Ts1_User2 객체가 Ts1_Memory에 50을 세팅 후 2초를 쉰다. 
* 
* 원하는 결과는 user1 : 100
*            user2 : 50 이다.
* 
* 그러나 아래의 실행 결과는 
* user1 : 50
* user2 : 50 이다.
*
* 쓰레드는 하나의 작은 프로그램이다. 
* user1쓰레드(프로그램)에서 공유객체에 해당하는 Memory의 값을 수정하고 나서 쉴때
* user2쓰레드(프로그램)에서 공유객체의 값을 수정해서 원하는 결과를 엊지 못한다. 
* 
* 임계영역 : 멀티 쓰레드에서 한번에 하나의 쓰레드만 실행 할수 있는 영역
* 
* ThreadSyncSummary2 에서 첫번째 시도를 알아 본다. 
* */
public class ThreadSyncSummary1 {
	public static void main(String[] args) {

		Ts1_Memory mem = new Ts1_Memory();

		Ts1_User1 user1 = new Ts1_User1(mem);
		user1.start();
		Ts1_User2 user2 = new Ts1_User2(mem);
		user2.start();
	}
}

class Ts1_User1 extends Thread {

	private Ts1_Memory mem;

	public Ts1_User1() {
	}

	public Ts1_User1(Ts1_Memory mem) {
		this.mem = mem;
		setName("User1");
	}

	public void setMemory(Ts1_Memory mem) {
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

class Ts1_User2 extends Thread {
	private Ts1_Memory mem;

	public Ts1_User2() {
	}

	public Ts1_User2(Ts1_Memory mem) {
		this.mem = mem;
		setName("User2");
	}

	public void setMemory(Ts1_Memory mem) {
		this.mem = mem;
	}

	@Override
	public void run() {
//		synchronized (mem) {
			System.out.println("user2 start");
			this.mem.setMem(50);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(this.getName() + ":-" + this.mem.getMem());
//		}
	}
}

class Ts1_Memory {
	private int mem;

	public int getMem() {
		return mem;
	}

	public synchronized void setMem(int mem) {
		System.out.println("공유 객체의 set : "+Thread.currentThread().getName());
		this.mem = mem;
	}

}
