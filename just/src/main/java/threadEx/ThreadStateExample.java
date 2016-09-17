package threadEx;

public class ThreadStateExample {
	public static void main(String[] args) {
		StatePrintThread st = new StatePrintThread(new TargetThread());
		st.start();
	}
}
