package linkedlist;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


/*
 * linkedList 구현
 * ADT 
 * 
 * 1) add(value)
 * 2) get(index)
 * */
public class LinkedListTest {

	@Test
	public void createListTest() {
//		MyList myList = new MyList();
	}
	
	@Test
	public void testArrayList() throws Exception {
		List<Integer> list = new ArrayList<>();
		
		list.add(1);
		System.out.println(list.get(0));
		System.out.println(list.size());
		list.remove(0);
		System.out.println(list.size());
		list.add(0, 10);
		System.out.println(list.size());
	}
}
