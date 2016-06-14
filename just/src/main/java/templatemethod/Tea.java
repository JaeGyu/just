package templatemethod;

public abstract class Tea {

	final String recipe() { //facade?! vs template method의 장점
		return boil() + "\n" + brew() + "\n" + takeCup();
	}

	// 물을 끓인다.
	public String boil() {
		return "Water Boil~";
	}

	// 물 잔에 따른다.
	public String takeCup() {
		return "take Cup";
	}

	public abstract String brew();
}
