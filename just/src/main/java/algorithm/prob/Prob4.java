package algorithm.prob;

/*
 * 개미수열
 * 이전 개미 수열을 입력 받으면 이후의 개미수열을 내 밷는다.
 * 1
 * 11
 * 21
 * 1211
 * 111221
 * 312211
 * 13112221
 * 1113213211
 * ...
 * */
public class Prob4 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("1");
		String tmp = "1";
		for (int i = 0; i < 30; i++) {
			Thread.sleep(3000);
			tmp = nextAntNum(tmp);
			System.out.println(tmp);
		}
	}

	public static String nextAntNum(String strNum) {
		char buf = 0;
		int cnt = 1;
		StringBuilder output = new StringBuilder();

		char[] tmp = strNum.toCharArray();
		buf = tmp[0];

		for (int i = 1; i < tmp.length; i++) {
			if (buf == tmp[i]) {
				cnt++;
			} else {
				output.append(String.valueOf(cnt));
				output.append(buf);
				buf = tmp[i];
				cnt = 1;
			}
		}

		output.append(String.valueOf(cnt));
		output.append(buf);

		return output.toString();
	}
}
