package reactive.programming;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class PubSub {
	
	/*
	 * 동시성을 가지고 어떤 복잡한 작업을 처리하는 코드를 간결하게 해준다.
	 * */

	public static void main(String[] args) {
		// publisher <- Observerable
		// subscriber <- Observer

		/*
		 * Publish.subscribe(subscriber)을 통해 퍼블리셔에 등록해 준다.
		 * 
		 * 위와 같이 했을때 퍼블리셔가 서브스크라이버한테 주는 정보는 아래와 같은 프로토콜을 따라야 한다. 아래는 메서드들인데 일단
		 * 퍼블리셔가 서브스크라이버한테 반드시 전해줘야 하는 시그널을 onSubscribe이다. onSubscribe(필수이다)
		 * onNext*(0이상 무한대까지) (onError | onComplete)?(둘중에 하나를 할수있다.)
		 * 
		 */
		Iterable<Integer> iter = Arrays.asList(1, 2, 3, 4, 5);
		
		ExecutorService es = Executors.newSingleThreadExecutor();

		//위의 이터를 가져가서 던지는 퍼블리셔를 만들고 싶다. 
		//1:05:00 볼것
		//1:13:20 볼걸 전후로 해서 
		
		//퍼블리셔는 데이터를 주는 쪽이다. 
		/*
		 * 퍼블리셔가 서브스크한테 데이터를 주는 것을 멀티 스레드를 써서 10개정도를 동시에 날려도 되느냐?
		 * 이런생각을 해볼수 있을 텐데 왜냐 하면 퍼블리셔가 작업이 많기 떄문에 병렬적으로 처리 하고 싶다. 
		 * 그러나 그건 스펙상에 불가능으로 되어있다. 퍼블리셔는 반드시 서브스크는 시퀀셜하게 데이터가 날라올걸로 기대를 하고 
		 * 그거에 관련된 멀티스레드 문제를 신경쓰지 않아도 된다.  어느 한순간에는 어느 한 스레드에서만 온다는 걸 가정하기 때문에 
		 * 동시성에 관련 된 이슈 등에서 문제가 적다. 서브스크 한거에 대해서 onNext넘어오는 것은 한스레드에서만 쭉가는걸로 되어있다. 
		 * 물론 동시에 여러 서브스크가 생기는 것은 가능하다. 	그때는 각각 다른 스레드로 날라간다.  
		 * */
		Publisher<Integer> p = new Publisher<Integer>() {
			
			/*
			 * 데이터를 주는 쪽은 내가 누구한테 주는지를 알아야 하는데 
			 * 서브스크라이버가 나한테줘 하고 구독한다. 
			 * 
			 * 서브스크라이버가 퍼블리셔 한테 나 너 구독할래라고 subscribe()라는 메서드를 호출하면 퍼블리셔는
			 * subscription이라는 오브젝트를 만들어서 다시 서브스크라이버의 onSubscribe라는 메서드를 호출해주고 
			 * 나서 퍼블리셔가 데이터나 이벤트를 막던저주는 것이 아니라 subscription이 퍼블리셔와 서브스크라이버의 가교 역할을 하는데
			 * 서브스크라이버가 subscription을 통해서 요청을 할수가 있다 그럼 여기서 드는 의문하나 푸시방식인데 왜 이터레이터처럼 요청을
			 * 하느냐? 그런데 이 요청이라는 것이 이터때의 요청과는 다르다 백프레셔(역압)라고 하는데 퍼블리셔와 서브스크라이버의 사이에 
			 * 속도차가 발생했을 경우에 그걸 조절해주는 기술이다. 이부분을 리엑티브 스트림에선 subscription으로 처리하게 되어있다. 
			 * 그래서 퍼블리셔에서 너가가진 데이터가 10개건 100개건 1000만개건 다보내줘 라고 요청 할 수도 있고 나 지금 바쁘니깐 
			 * 일단 10개만 먼저주고 나머지는 대기하고 있어라고 요청 할 수 있다. 이때 사용하는 메서드가 request이다.  
			 *
			 * */
			@Override
			public void subscribe(Subscriber<? super Integer> subscriber) {
				/*
				 * 서브스크라이브는 한번에 여러개가 동작할 수도 있고 이어서 여러개가 동작 할 수도 있는데
				 * 그래서 매번 iterator을 새로 만들어서 써야 한다.	
				 * 서브스크라이브 하는 순간에 이터레이터를 하나 생성했다. 
				 * */
				Iterator<Integer> it = iter.iterator();
				
				/*
				 * Subscription이라는 객체가 만들어져서 
				 * onSubscribe메서드에 넘어가는데 여기에는 구현해야할 메서드 두개가 있다. 
				 * 
				 * */
				subscriber.onSubscribe(new Subscription() {
					
					
					/*
					 * 단지 정보만 전달한다. max값을 넘기면 long의 max값 
					 * 다달라는 소리 1을 넘기면 하나를 달라는 소리
					 * 요청을 해달라는 거지 나한테 이메서드의 실행우 응답을 달라는건 아니다. 
					 * 그리고 이 request를 호출하는 순간에 퍼블리셔는 아직 데이터가 없을 수 도 있다.
					 * 즉 이벤트가 발생하지 않을 수 도 있다.
					 * 실제로 onNext라고 해서 퍼블리셔가 데이터를 보내주는 것은 직접 서브스크라이버에게 보내준다.   
					 * */
					@Override
					public void request(long n) {
						
						/*
						 * 위에서 서브스크라이브 할때마다 이터를 하나 생성했고
						 * 리쿼에서는 거기서 하나씩 꺼내서 준다. 
						 * 그리고 무한정 줄순 없으니 체크를 해서 complete를 해준다.
						 * 
						 *  1:30:00 전후로 볼 것 
						 * */
						try{
							while(n-- > 0){
								if(it.hasNext()){
									subscriber.onNext(it.next());
								}else{
									subscriber.onComplete();
									break;
								}
							}
						}catch(RuntimeException e){
							/*
							 * 퍼블리셔 쪽에서 돌다가 뭐가 예외가 나면 
							 * onError을 호출하고 e를 넘겨 주면 된다.
							 * */
							subscriber.onError(e);
						}
					}
					
					@Override
					public void cancel() {
						
					}
				});
			}
		};
		
		/*
		 * 데이터를 가져오려면 나는 데이터를 어떻게 받겠어라는 나의 의도를 이야기 해야 한다.
		 * 역압이 필요한 이유이다.
		 * 어떤 경우에는 퍼블리셔가 너무빠르다 그런데 서브스크라이버는 하나를 처리하는데 1초가 걸린다면 
		 * 10000개를 받는다면 10000초가 걸린다. 만약 퍼블리셔가 100만개를 쏜다면 이 100만개는 어디에 가있는 것일까?
		 * 보통 이런경우 중간에 어마어마한 버퍼를 만들어 놔야 한다.
		 * 
		 * 그리고 반대의 경우도 있을수 있다. 즉 퍼블리셔는 느린대 서브스크가 빠른경우 
		 * 이게 균형이 맞으면 참 좋은데 보통 그렇지가 않다.
		 * 
		 * 비동기라는 것은 한서버의 쓰레드 사이에서만이 아니라 
		 * 서버와 서버사이 서버와 다른 서비스 사이에서도 이액티브가 적용이 가능하다 
		 * 이런경우에 디비를 읽거나 다른서버에서 뭔가 데이터를 읽어 오는 것 을 리액티브하게 하고싶다. 
		 * 네트웍타고 멀리 갔다 오는거 데이터량이 많은거 이거 오래걸린다. 그걸 받아서 나는 서머리만 하면되 이런경우
		 * 퍼블리셔들은 느리지만 서브스크는 빠른 경우에 해당한다. 반면에 데이터를 가져와서 뭔가를 다검사한다음에 디비에 집어 넣는다
		 * 이런경우는 생성하는쪽은 빠르지만 서브스크는 느린 경우에 해당한다. <-이런경우에는 할수만 있다면 생성 자체를 지연시키는게 좋다. 
		 * 이러면 여러가지 장점이 있는데 중간에 버퍼가 필요 없게 되어서 메모리가 확 절약이 된다. 
		 * 넷플릭스에서 발표한 자료에 따르면 리액티브를 적용전에는 메모리 사용율이 쭉올라갔다 떨어졌다를 반복하는 구조였는데 중간에 캐쉬에 확저장했
		 * 다가 확끌어가고 그래서 그렇다. 
		 * 리액티브를 도입하고 역압을 적용하고 나선 메모리가 피크를 치지않고 항상 일정한 크기로 흘러갔다고 한다. 
		 * */
		Subscriber<Integer> s = new Subscriber<Integer>() {
			Subscription subscription;
			//필수 
			@Override
			public void onSubscribe(Subscription subscription) {
				System.out.println("onSubsctibe");
				this.subscription = subscription; 
				
				//몽땅 다 빨리 받고 싶다 그럼 아래와 같이 세팅한다.
			    this.subscription.request(1); //10개를 줘 그러나 퍼블리셔가 10개보다 적게 가지고 있다면 그것만큼 주고 onComplete하고 끝낸다.   
			}
			
			//0 ~ n 
			/* 
			 * 옵저버 패턴의 업데이트와 똑같은거다.
			 * 퍼블리셔가 데이터를 주면 onNext가 받는다.
			 * */
			@Override
			public void onNext(Integer item) {
				System.out.println("onNext " + item);
				this.subscription.request(1);
				//1:27:00 전후로 볼 것 
			}
			
			//onComplete 중 하나만 선택 
			/*
			 * 익셉션을 발생 시키지 말고 익셉션에 해당하는 오브젝트를 만들어서 onError을 타고 나한테 넘겨줘 라는 의미
			 * 
			 * 우아하게 onError이란 메서드를 통해서 에러가 넘어 온다. 
			 * 그럼 이걸 체크해보고 감당할 수 있는거냐 없는거냐를 복구가 필요하냐 아님 종료를 해야 하냐에 따라서 뭔가를 처리 하면 된다.
			 * */
			@Override
			public void onError(Throwable throwable) {
				System.out.println("onError");
			}
			
			/*
			 * 퍼블리셔가 나 너한테 줄데이터가 더이상 없어라고 onComplete를 호출할수 있도록 한다. 
			 * */
			@Override
			public void onComplete() {
				System.out.println("onComplete");
			}
		};
		
		p.subscribe(s);
	}

}
