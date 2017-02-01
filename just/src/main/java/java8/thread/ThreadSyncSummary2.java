package java8.thread;


/*
 * 우선 2개의 쓰레드(런타임 중인 프로그램)에서 run()메서드가 임계영역이여야 할 것같다.
 * run()메서드는 한번에 하나의 쓰레드만 실행되어야 Memory객체가 관리하는 mem을 보호 할 수 있을 것 같다.
 * 
 * 그래서 두군데의 run() 메서드에 syncronized 키워드를 붙여 준다.
 * 실행 하면 원하는데로 안된다.
 * 
 * 우선 User1객체를 실행하고 있는 쓰레드가 User1객체의 임계영역을 혼자 실행한다. 
 * mem을 변경한다 그리고 2초의 휴식이 시작된다.
 * User2객체를 실행하고 있는 쓰레드역시 run()의 임계영역을 실행하기 시작한다.
 * User1객체의 run()을 실행시 mem을 보호 할것 같으나 Memory의 어느 부분에도 임계영역은 없기 때문에 
 * User2가 수정을 시도하면 수정이 된다. 
 * User1의 임계영역하고는 별개의 영역이기 때문에 synchronized를 두 군데 붙였어도 의미가 없다.
 * 
 * Memory의 setMem메서드에 synchronized를 붙이 더라도 USer1 User2 객체의 임계영역과는 별개의 임계 영역이라
 * USer1의 임계영역이 끝나기 전에도 User2가 setMem을 호출 할 수 있게 된다.
 * 즉 USer1의 임계영역과 Memory의 setMem이 원자적이지 않다. 
 * 
 * 
 * */
public class ThreadSyncSummary2 {
	public static void main(String[] args) {

		Ts2_Memory mem = new Ts2_Memory();

		Ts2_User1 user1 = new Ts2_User1(mem);
		user1.start();
		Ts2_User2 user2 = new Ts2_User2(mem);
		user2.start();
	}
}

class Ts2_User1 extends Thread {

	private Ts2_Memory mem;

	public Ts2_User1() {
	}

	public Ts2_User1(Ts2_Memory mem) {
		this.mem = mem;
		setName("User1");
	}

	public void setMemory(Ts2_Memory mem) {
		this.mem = mem;
	}

	@Override
	public synchronized void run() {
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

class Ts2_User2 extends Thread {
	private Ts2_Memory mem;

	public Ts2_User2() {
	}

	public Ts2_User2(Ts2_Memory mem) {
		this.mem = mem;
		setName("User2");
	}

	public void setMemory(Ts2_Memory mem) {
		this.mem = mem;
	}

	@Override
	public synchronized void run() {
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

class Ts2_Memory {
	private int mem;

	public int getMem() {
		return mem;
	}

	public synchronized void setMem(int mem) {
		System.out.println("공유 객체의 set : " + Thread.currentThread().getName());
		this.mem = mem;
	}

}