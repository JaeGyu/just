package algorithm;

import java.util.Arrays;

/*
 * 
 * 1=2->3
 * 2=1
 * 3=1
 * 
 *     1 2 3
 *   1 0 1 1
 *   2 1 0 0
 *   3 1 0 0 
 * */
public class GraphDFS {
	private static boolean[] check = new boolean[4];

	public static void main(String[] args) {

		int[][] g = new int[4][4];

		g[1][2] = 1;
		g[1][3] = 1;
		g[2][1] = 1;
		g[3][1] = 1;

		dfs(g, 1);

	}

	public static void dfs(int[][] g, int x) {
		check[x] = true;
		System.out.println(x);
		for (int i = 1; i <= 3; i++) {
			if (g[x][i] == 1 && check[i] == false) {
				dfs(g, i);
			}
		}
	}
}
