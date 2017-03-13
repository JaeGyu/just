package reflect;

public class TestObj {
	
	/*
	 * 클래스가 메모리상에 올라가면서 
	 * 스태틱 블럭이 실행이 된다.
	 * */
	static{
		System.out.println("TestObj static block");
	}
	
	public void doA() {
		System.out.println("doA....");
	}
	
	public static void main(String[] args) {
		
		System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzz ");
		
		TestObj obj = new TestObj();
		
	} 

}
