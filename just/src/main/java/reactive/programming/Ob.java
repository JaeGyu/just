package reactive.programming;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ob {

	// Iterable <-->쌍대성은 Obserable이더라.
	// 쌍대성이라는 것은 사실 궁극적인 기능은 똑같은데 그걸 반대방향으로 표현하는 것이다.
	// Iterable은 pull하는 방식이다. 즉 내가 땡겨오는 방식이다.
	// 반면에 Observer은 push방식이다. 어떤데이터나 이벤트등을 가지고 있는 소스쪽에서 밀어 넣어 주는방식이다.
	
	/*
	 *  MS에서 옵저버 패턴에 문제를 제시 했다
	 *  
	 *  1. 끝이라는 개념이 없다. Complete? 
	 *     물론 끝이 없어야하는 작업들도 존재하지만 끝이 있어야 하는 작업들도 존재 한다.
	 *  
	 *  2. Error? 54분부분을 볼것
	 *  
	 *  위의 두개의 취약한 부분을 추가해서 옵저버블을 구현한것이 리액티브 프로그래밍의 한 축이다.
	 * 
	 * */

	/*
	 * 데이터를 만드는 소스쪽이다.
	 */
	static class IntObserverable extends Observable implements Runnable {

		@Override
		public void run() {
			for (int i = 10; i < 50; i++) {
				setChanged(); // 내가 이전과 뭔가 달라졌다라는 것을 표현해준다.
				notifyObservers(i); // it.next()에 해당하는 부분다. 
				//잘보면 notifyObservers(i)는 파라미터에 값을 넘기고 it.next()는 리턴값이다.
				//잘보면 궁극적인 기능을 똑같으나 구현의 패러다임이 다르다.
			}
		}

	}

	public static void main(String[] args) {
		// 여러개의 데이터가 있다고 생각해보자!
		// 이런 멀티로 있는 데이터는 하나하나씩 가져와서 사용을 해야 한다.
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		for (Integer i : list) { // For-Each라 한다.
			// System.out.println(i);
		}

		Iterable<Integer> iter = () -> {
			return new Iterator<Integer>() {
				int i = 0;
				static final int MAX = 10;

				@Override
				public Integer next() {
					return ++i;
				}

				@Override
				public boolean hasNext() {
					return i < MAX;
				}
			};
		};

		for (Integer i : iter) {
			System.out.println(i);
		}

		System.out.println("-----------------------------------------");

		for (Iterator<Integer> it = iter.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}

		System.out.println("-----------------------------------------");

		// source --> Event/Data를 던진다.-->Observer한테 던진다. 즉 옵저버블이 이벤트나 데이터를 옵저버한테
		// 던진다.
		// 우리는 옵저버블과 옵저버를 만들어서 옵저버를 옵저버블한테 등록을 시키는 것이다. 내가 앞으로 발생하는 이벤트나
		// 시그널이나 데이터등을 나한테 보내줘 라고 ...

		/*
		 * 데이터를 받는 쪽이다.
		 */
		Observer ob = new Observer() {

			@Override
			public void update(Observable o, Object arg) {
				System.out.println(Thread.currentThread().getName() + ":" + arg);
			}
		};

		IntObserverable io = new IntObserverable();
		io.addObserver(ob); // 옵저버블한테 옵저버를 등록한다.

		
		/*
		 * 푸시 방식으로 옵저버 패턴을 이용하면 별개의 쓰레드에서 동작을 하는 코드를 손쉽게 만들 수 있다. 
		 * 이걸 이터러블을 이용하면 어렵다.
		 * */
		ExecutorService es = Executors.newSingleThreadExecutor();
		es.execute(io);
		
		System.out.println(Thread.currentThread().getName() + " EXIT");
		es.shutdown();

	}
}
