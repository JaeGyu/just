package java8.stream;

import java.util.Arrays;
import java.util.List;

public class StreamEx7 {
	public static void main(String[] args) {
		List<String> inputList1 = Arrays.asList("java8 lambda", "stream mapping");

		inputList1.stream()
		          .flatMap(data -> Arrays.stream(data.split(" ")))
		          .forEach(word -> System.out.println(word));
		
		System.out.println();
		
		//flatMap를 사용하지 않으면 아래와 같이 해야 된다. 
		inputList1.stream()
		          .map(data -> Arrays.stream(data.split(" ")))
		          .forEach(stream -> stream.forEach(data -> System.out.println(data)));
		System.out.println();
		
		List<String> inputList2 = Arrays.asList("1,2,3,4,5", "6,7,8,9,10");
		inputList2.stream()
		          .flatMapToInt(data -> {
		        	  return Arrays.asList(data.split(",")).stream()
		        			  .mapToInt(number -> Integer.valueOf(number));
		          })
				  .forEach(number -> System.out.println(number));
	}
}
