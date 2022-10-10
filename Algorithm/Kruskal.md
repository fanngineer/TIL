
```Java
package Self;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Graph_Kruskal {
	static int[] p;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt();
		int E = sc.nextInt();

		// 간선의 배열 저장
		int[][] edges = new int[E][3];

		for (int i = 0; i < E; i++) {
			edges[i][0] = sc.nextInt();// 시작 정점
			edges[i][1] = sc.nextInt();// 도착 정점
			edges[i][2] = sc.nextInt();// 가중치
		}

		// 크루스칼 알고리즘
		// 정렬
		Arrays.sort(edges, new Comparator<int[]>() {

			// 음수 양수 0 에 따라 값을 비교 결정
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		p = new int[V]; // 대표자 배열

		for (int i = 0; i < V; i++) {
			makeSet(i);
		} // 배열 초기화 (make-set)

		// mst를 위해 간선 선택
		int ans = 0;
		int pick = 0; // 뽑은 간선 갯수
		for (int i = 0; i < E; i++) {
			// 정렬된 순서대로
			// i번재 간선을 뽑아서 두 정점의 대표를 확인
			// 대표가 같으면 pass, 다르면 union
			if (findSet(edges[i][0]) != edges[i][1]) {
				union(findSet(edges[i][0]), findSet(edges[i][1]));
				ans += edges[i][2];
				pick++;
			}

			if (pick == V - 1)
				break;

		} // 전체 간선 돌기
		System.out.println(ans);
	}// main

	private static void makeSet(int x) {
		p[x] = x;
	}

	private static int findSet(int x) {
		if (x == p[x])
			return p[x];
		return findSet(p[x]);
	}

	private static int findSet2(int x) {
		if (x != p[x])
			p[x] = findSet2(p[x]);
		return p[x];
	}

	private static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}
}
```
