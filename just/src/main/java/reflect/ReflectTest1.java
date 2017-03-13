package reflect;

import java.util.Scanner;

public class ReflectTest1 {
	public static void main(String[] args) throws InterruptedException {

//		Scanner sc = new Scanner(System.in);
//		System.out.println("로딩하고 싶은 클래스 이름은?");
//		String className = sc.nextLine();

		 String className = "reflect.TestObj";

		try {
			Class clazz = Class.forName(className);

			System.out.println(clazz);

			Thread.sleep(3000);
			Class clazz2 = Class.forName(className);
			System.out.println(clazz2);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
