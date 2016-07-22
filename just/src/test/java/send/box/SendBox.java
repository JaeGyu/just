package send.box;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SendBox {

	@Test
	public void testOutOfMemory() throws Exception {
		List<String> buffer = new ArrayList<>();
		
		for(int i=0;i<100000000;i++){
			buffer.add(new String(i+""));
		}
		System.out.println("End");
	}
}
