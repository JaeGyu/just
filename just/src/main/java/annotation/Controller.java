package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
/*
 * ElementType.TYPE 우리가 만들려는 어노테이션을 클래스에다가 걸수 있다는 소리.
 */
public @interface Controller {
	
	/*
	 * value()는 
	 * @Controller(value="XXX")에서
	 * (value="XXX")가 필요하다는 의미이다. 
	 * */
	public String value();
}
