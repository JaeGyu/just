package threadEx;

public class MainThreadExample {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		
		User1 user1 = new User1();
	    System.out.println(user1.getState());
		user1.setCalculator(calculator);
		System.out.println(user1.getState());
		user1.start();
		System.out.println(user1.getState());
		
		User2 user2 = new User2();
		user2.setCalculator(calculator);
		user2.start();
		
	}
}
