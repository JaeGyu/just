package java8.ex;

/*
 * 아래의 애노테이션은 함수적인터페이스를 작성할때
 * 함수적 인터페이스의 규칙인 하나의 추상메서드만 존재해야함을
 * 컴파일시에 체크 해준다. 
 *
 * @Override 와 비슷한 기능 
 * 안써도 개발자가 알아서 하나의 추상메서드만 선언 한다면 문제 없다.
 * */
@FunctionalInterface
public interface MyFunctionInterface {

	public void method();

}
