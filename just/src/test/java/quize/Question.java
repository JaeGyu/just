package quize;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.hamcrest.core.Is;
import org.junit.Test;

public class Question {

	public int search(int[] args) {

		int sum = Arrays.stream(args).limit(3).map(i -> Math.abs(i) % 2).sum();
		int type = (sum == 0 || sum == 1) ? 1 : 0;

		return Arrays.stream(args)
				.filter(i -> Math.abs(i) % 2 == type)
				.findFirst()
				.getAsInt();
	}

	@Test
	public void test_odd() throws Exception {
		int[] a1 = { 24, 14, 0, 22, 30, 38, -2, -1 };
		assertThat(-1, Is.is(search(a1)));
	}

	@Test
	public void test_odd_2() throws Exception {
		int[] a1 = { 24, 14, 0, 22, 30, 38, -2, -3 };
		assertThat(-3, Is.is(search(a1)));
	}
	
	@Test
	public void test_even() throws Exception {
		int[] a1 = { 23, -13, 3, 1, 2, -23, -33, 33 };
		assertThat(2, Is.is(search(a1)));
	}
}
