package pgtop.process.implement;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class TimeChkTest {
	
	private static final Integer HZ = 1000;

	private Long lastTime;
	private Long thisTime;
	private Long now;
	private Double timeDiff;
	
	@Test
	public void testTime() throws Exception{
		System.out.println(System.currentTimeMillis());
		System.out.println(System.currentTimeMillis() / 1000l);
		System.out.println(System.currentTimeMillis() % 1000l);
	}

	@Test
	public void testCurrencyTime() throws Exception {

		thisTime = System.currentTimeMillis();

		if (lastTime != null) {
			timeDiff = (thisTime - lastTime) / 1000d;
		} else {
			timeDiff = 0.0d;
		}
		
		lastTime = thisTime;
		
		now = thisTime / 1000l;
		
		System.out.println(timeDiff);
	}

	@Test
	public void timeTest() throws Exception {

		long startMillis = System.currentTimeMillis();
		long startNanoTime = System.nanoTime();

		long startSecond = TimeUnit.MILLISECONDS.toSeconds(startMillis);

		System.out.println(startMillis);
		System.out.println(TimeUnit.MILLISECONDS.toMicros(startMillis));

		long sS = startMillis / 1000l;

		int result = 1;
		for (int i = 0; i < 100; i++)
			for (int j = 0; j < 100; j++)
				for (int k = 0; k < 100 + 100; k++)
					for (int l = 0; l < 100 * 100; l++)
						result *= 2;

		long endMillis = System.currentTimeMillis();
		long endNanoTime = System.nanoTime();

		long endSecond = TimeUnit.MILLISECONDS.toSeconds(endMillis);

		long eS = endMillis / 1000l;

		System.out.println((endMillis - startMillis) / 1000d);
		System.out.println((endNanoTime - startNanoTime) / 1000000000d);

		System.out.println((endSecond - startSecond) / 1.0d);
		System.out.println(eS - sS);
	}
}
