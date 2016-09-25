package java8.ex;

public class UsingThisExampleReview {
	public static void main(String[] args) {
		UsingThisReview ut = new UsingThisReview();
		UsingThisReview.InnerReview inner = ut.new InnerReview();
		inner.method();
	}
}
