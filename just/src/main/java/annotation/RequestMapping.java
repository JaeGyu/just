package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
/*
 * ElementType.TYPE 우리가 만들려는 어노테이션을 클래스에다가 걸수 있다는 소리.
 * ElementType.METHOD 우리가 만들려는 어노테이션을 메소드에다가 걸수 있다는 소리.
 * 즉 위에서 두가지가 선언 되었으므로 우리가 만들려는 어노테이션은
 * 클래스와 메소드에 걸 수 있다.
 * */
public @interface RequestMapping {
	public String value();
}
