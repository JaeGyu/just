package java8.thread;


/*
 * User1의 임계영역에 synchronezed블록을 지정하고 공유 객체를 mem으로 지정한다.
 * synchronized 블록 내의 임계영역과 Memory 객체를 원자적으로 묶겠다는 의미이다.
 * 단 Memory 객체 내에 synchronized 같 붙은 임계영역에 한해서이다.
 * 
 * 아래의 결과는 원하는 결과가 나온다. 
 * 
 * User1이 2초 동안 쉴때 User2가 Memory의 setMem을 통해 값을 수정하려 하나 User1의 임계영역과 같은 라이프싸이클을 setMem이 가지게
 * 되서 User1의 임계영역이 다 끝날때까지 기다릴 수 밖에 없다. 
 * 
 * */
public class ThreadSyncSummary3 {
	public static void main(String[] args) {

		Ts3_Memory mem = new Ts3_Memory();

		Ts3_User1 user1 = new Ts3_User1(mem);
		user1.start();
		Ts3_User2 user2 = new Ts3_User2(mem);
		user2.start();
	}
}

class Ts3_User1 extends Thread {

	private Ts3_Memory mem;

	public Ts3_User1() {
	}

	public Ts3_User1(Ts3_Memory mem) {
		this.mem = mem;
		setName("User1");
	}

	public void setMemory(Ts3_Memory mem) {
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

class Ts3_User2 extends Thread {
	private Ts3_Memory mem;

	public Ts3_User2() {
	}

	public Ts3_User2(Ts3_Memory mem) {
		this.mem = mem;
		setName("User2");
	}

	public void setMemory(Ts3_Memory mem) {
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

class Ts3_Memory {
	private int mem;

	public int getMem() {
		return mem;
	}

	public synchronized void setMem(int mem) {
		System.out.println("공유 객체의 set : " + Thread.currentThread().getName());
		this.mem = mem;
	}

}