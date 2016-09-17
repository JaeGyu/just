package threadEx;

public class User1 extends Thread {
	private Calculator calculator;

	public void setCalculator(Calculator calculator) {
		this.setName("User1");
		this.calculator = calculator;
	}

	@Override
	public void run() {
		calculator.setMemory(100);
		System.out.println("쓰레드 내부의 run메서드 :: "+this.getState());
	}
}
