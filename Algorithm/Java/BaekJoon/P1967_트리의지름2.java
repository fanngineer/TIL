package BaekJoon;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P1967_트리의지름2 {
	static int V;
	static ArrayList<int[]>[] edges;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		edges = new ArrayList[V + 1];

		for (int i = 0; i <= V; i++) {
			edges[i] = new ArrayList<>();
		}
		for (int i = 1; i < V; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int w = sc.nextInt();
			edges[st].add(new int[] { ed, w });
			edges[ed].add(new int[] { st, w });
		} // 입력
		max = 0;
		visited = new boolean[V + 1];
		visited[1] = true;
		dfs(1, 0);
		max = 0;
		visited = new boolean[V + 1];
		visited[next] = true;
		dfs(next, 0);
		System.out.println(max);
	}// main

	static int max;
	static int next;

	static void dfs(int st, int sum) {
		if (max < sum) {
			max = sum;
			next = st;
		}
		for (int i = 0; i < edges[st].size(); i++) {
			int[] edge = edges[st].get(i);
			int ed = edge[0];
			int w = edge[1];
			if (visited[ed] == true)
				continue;
			// i번째 고를 경우
			visited[ed] = true;
			dfs(ed, sum + w);
		}
	}// dfs
}
