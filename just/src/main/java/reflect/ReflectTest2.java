package reflect;

import java.lang.reflect.Constructor;

public class ReflectTest2 {
	public static void main(String[] args) throws Exception {

		String name = "reflect.TestObj";

		Class clz = Class.forName(name);
		
		
		//생성자가 없거나 ()생성자만 있는 경우는 클래스에서 바로 객체 생성 가능
//		Object newInstance = clz.newInstance();
//		
//		System.out.println(newInstance);

		
//		Constructor con = clz.getDeclaredConstructor(String.class);
//		
//		Object obj = con.newInstance("");
		
		Object obj = clz.newInstance();
		
		System.out.println(obj);
		
		
	} 
}
