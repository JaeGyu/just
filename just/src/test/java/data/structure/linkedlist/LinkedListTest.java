package data.structure.linkedlist;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {

	private TestList<Integer> testList;

	@Before
	public void setUp() {
		List<Integer> dummy = new ArrayList<>();
		dummy.add(1);
		dummy.add(2);
		dummy.add(3);
		dummy.remove(1);

		testList = new TestList<Integer>();
	}

	@Test
	public void 리스트에_정수하나를_추가한다() throws Exception {

		testList.add(1);
		
		
		
	}
}
