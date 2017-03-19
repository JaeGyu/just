package test.ex;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestEx {
	TestEx t;
	
	public int getTest(int con1, int con2) {
		int x = 0;
		if (con1 == 0) {
			x += 1;
		}
		if (con2 > 1) {
			x *= 2;
		}
		return x;
	}
	
	@Before
	public void setUp() throws Exception{
		t = new TestEx();
	}

	@Test
	public void testGetTest1() throws Exception {
		assertEquals(1, t.getTest(0, 0));
	}
	
	@Test
	public void testGetTest2() throws Exception{
		assertEquals(2, t.getTest(0, 2));
	}
	
	@Test
	public void testGetTest3() throws Exception{
		assertEquals(0, t.getTest(1, 2));
	}
}
