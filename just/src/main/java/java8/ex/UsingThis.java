package java8.ex;

public class UsingThis {

	public int outterField = 10;

	class Inner {

		int innerField = 20;

		void method() {
			MyFunctionInterface fi = () -> {
				System.out.println("outterField: " + outterField);

				// 바깥 객체의 참조를 얻기 위해서는 클래스명.this를 사용
				System.out.println("outterField: " + UsingThis.this.outterField + "\n");

				System.out.println("InnerField: " + innerField);
				System.out.println("InnerField: " + this.innerField + "\n");

			};

			fi.method();
		}
	}
}
