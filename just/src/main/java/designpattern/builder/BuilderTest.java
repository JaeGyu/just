package designpattern.builder;


/*
 * 텔리스코핑 생성자 패턴과 자바빈즈의 생성자 패턴의 혼용이다.
 * 
 * */
public class BuilderTest {
	public static void main(String[] args) {
		Rects r = new Rects.Builder(10, 10).margin(5).build();
		
		System.out.println(r);

	}
}

class Rects {
	private final int width;
	private final int height;
	private final int margin;
	private final int padding;

	@Override
	public String toString() {
		return "Rects [width=" + width + ", height=" + height + ", margin=" + margin + ", padding=" + padding + "]";
	}

	public static class Builder {
		private final int width;
		private final int height;
		private int margin;
		private int padding;

		public Builder(int width, int height) {
			this.width = width;
			this.height = height;
		}

		public Builder margin(int margin) {
			this.margin = margin;
			return this;
		}

		public Builder padding(int padding) {
			this.padding = padding;
			return this;
		}

		public Rects build() {
			return new Rects(this);
		}

	}

	public Rects(Builder builder) {
		this.width = builder.width;
		this.height = builder.height;
		this.margin = builder.margin;
		this.padding = builder.padding;
	}
}
