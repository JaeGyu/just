package java8.ex;

public class UsingThisReview {
	public int outterField = 10;

	class InnerReview {
		int innerField = 20;

		void method() {
			MyFunctionInterface fi = () -> {
				System.out.println("outterField : " + outterField);
				 //바깥 객체의 참조를 얻기 위해서는 클래스명.this를 사용한다. 
				System.out.println("outterField : " + UsingThisReview.this.outterField + "\n");

				System.out.println("innerField : " + innerField);
				System.out.println("innerField : " + this.innerField + "\n");
			};

			fi.method();
		}
	}
}
