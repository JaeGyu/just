package java8.thread;

public class ThreadRun3 {
	public static void main(String[] args) {
		Thread t = new Thread() {
			@Override
			public void run() {
				super.run();
				System.out.println("Inner");
			}
		};

		Worker w = new Worker();
		w.start();
		t.start();

		TestClass tc = new TestClass() {
			public void printSys2() {
				System.out.println("printSys2");
			};
		};

		tc.printSys();
		tc.printSys2();
	}
}

class Worker extends Thread {
	@Override
	public void run() {
		super.run();
		System.out.println("Thread ~~");
	}
}

class TestClass {
	private String name;

	public void printSys2() {

	}

	public void printSys() {
		System.out.println("printSys");
	}
}
