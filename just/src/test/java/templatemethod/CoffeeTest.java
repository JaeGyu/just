package templatemethod;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;

public class CoffeeTest {

	Tea coffe;
	
	@Before
	public void setUp(){
		coffe = new Coffe();
	}
	
	@Test
	public void testBoil() throws Exception {
		assertThat(coffe.boil(),is("Water Boil~"));
	}
	
	@Test
	public void testBrew() throws Exception {
		assertThat(coffe.brew(),is("Coffee Drip"));
	}
	
	@Test
	public void testTakeCup() throws Exception {
		assertThat(coffe.takeCup(),is("take Cup"));
	}
	
	@Test
	public void testName() throws Exception {
		assertThat(coffe.recipe(), is("Water Boil~\nCoffee Drip\ntake Cup"));
		
	}
}
