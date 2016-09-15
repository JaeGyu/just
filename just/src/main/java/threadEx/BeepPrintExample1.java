package threadEx;

import java.awt.Toolkit;

public class BeepPrintExample1 {
	public static void main(String[] args) throws InterruptedException {
		Toolkit toolkit = Toolkit.getDefaultToolkit();

		for (int i = 0; i < 5; i++) {
			toolkit.beep();
			Thread.sleep(500);
		}
		
		for(int i=0;i<5;i++){
			System.out.println("띵");
			Thread.sleep(500);
		}
	}
}
