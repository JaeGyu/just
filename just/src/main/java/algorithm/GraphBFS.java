package algorithm;

import java.util.LinkedList;
import java.util.Queue;

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
public class GraphBFS {

	private static boolean[] check = new boolean[4];

	public static void main(String[] args) {

		int[][] g = new int[4][4];

		g[1][2] = 1;
		g[1][3] = 1;
		g[2][1] = 1;
		g[3][1] = 1;

		bfs(g, 1);

	}

	public static void bfs(int[][] g, int x) {
		Queue<Integer> q = new LinkedList<>();
		check[x] = true;
		q.add(x);
		while (!q.isEmpty()) {
			int v = q.peek();
			q.poll();
			System.out.println(v);
			for (int i = 1; i <= 3; i++) {
				if (g[v][i] == x && check[i] == false) {
					check[i] = true;
					q.add(i);
				}
			}
		}
	}
}
