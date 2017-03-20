package algorithm;

import java.util.Scanner;

public class Prob1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1;i<=n;i++){
			if(n % i == 0){
				sb.append(String.valueOf(i));
				sb.append(" ");
			}
		}
		
		System.out.println(sb.toString().trim());
	}
}
