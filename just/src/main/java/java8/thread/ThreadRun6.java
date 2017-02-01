package java8.thread;

/*
 * User1 객체가 Memory에 100을 세팅 후  2초를 쉰다.
 * 그때 user2 객체가 Memory에 50을 세팅 한다.
 * 
 * user1이 memory의 내용을 출력 한다.
 * user2가 memory의 내용을 출력 한다. 
 *
 * 아래와 같이 코딩 되어 있을 경우 동기화는 어떻게 할까?
 * 
 * 결과로 User1: 100
 *      User2: 50 이 나와야 함
 * */
public class ThreadRun6 {
	public static void main(String[] args) {

		Memory mem = new Memory();

		User1 user1 = new User1(mem);
		user1.start();
		User2 user2 = new User2(mem);
		user2.start();
	}

}

class User1 extends Thread {

	private Memory mem;

	public User1() {
	}

	public User1(Memory mem) {
		this.mem = mem;
		setName("User1");
	}

	public void setMemory(Memory mem) {
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

class User2 extends Thread {
	private Memory mem;

	public User2() {
	}

	public User2(Memory mem) {
		this.mem = mem;
		setName("User2");
	}

	public void setMemory(Memory mem) {
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

class Memory {
	private int mem;

	public int getMem() {
		return mem;
	}

	public synchronized void setMem(int mem) {
		System.out.println("공유 객체의 set : "+Thread.currentThread().getName());
		this.mem = mem;
	}

}
