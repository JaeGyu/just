package chj.algorithm;

import java.util.BitSet;

public class BitOperation {
	public static void main(String[] args) {
		
		int a = 1;
		int b = 1;
		
		System.out.println(a&b);
		System.out.println(a|b);
		System.out.println(a^b);
		
		System.out.println(13 % 2);
		System.out.println(13 & 1);
		
		// {1,3,4,5,9}
		System.out.println(Integer.toBinaryString(570));
		
		//570을 이진수로 바꾼 비트 벡터에 3이 포함 되어 있다. 
		System.out.println(570 & (1<<3));
		
		//570을 이진수로 바꾼 비트벡터에 2를 추가 한다. 
		System.out.println(570 | (1<<2));
		
		//570을 이진수로 바꾼 비트벡터에서 1을 제거한다. 
		System.out.println(570 & ~(1<<1));
		
		BitSet bs = new BitSet();
		bs.set(1);
		bs.set(3);
		bs.set(4);
		bs.set(5);
		bs.set(9);
		
		System.out.println(bs);
	}
}
