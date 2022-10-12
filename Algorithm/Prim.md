# Prim Algorithm

- 하나의 정점에서 연결된 간선들 중에 하나씩 선택하면서 MST를 만들어 가는 방식
	- 임의 정점을 하나 선택해서 시작
	- 선택한 정점과 인접하는 정점들 중의 최소 비용의 간선이 존재하는 정점 선택
	- 모든 정점이 선택될 때 까지 1,2 과정을 반복

- 서로소인 2개의 집합 정보를 유지
	- 트리 정점 집합 : MST를 만들기 위해 선택된 정점들
	- 비트리 정점 집합 : 선택되지 않은 정점





```Java
package Self;

import java.util.Scanner;

public class Graph_Prim {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt();
		int E = sc.nextInt();

		// 간선의 정보 저장
		int[][] adjArr = new int[V][V];

		for (int i = 0; i < E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int w = sc.nextInt();

			adjArr[st][ed] = w;
			adjArr[ed][st] = w;
		}

		boolean[] visited = new boolean[V];

		int[] p = new int[V];
		int[] dist = new int[V];

		for (int i = 0; i < E; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		// 시작점 정하기
		dist[0] = 0;
		p[0] = -1;

		int ans = 0;

		// 프림알고리즘
		for (int i = 0; i < V; i++) {
			int min = Integer.MAX_VALUE;
			int idx = -1; // 내가 이번에 뽑을 정점의 번호
			// 아직 안뽑힌 것 중에서 제일 작은 값 뽑기
			for (int j = 0; j < V; j++) {
				if (!visited[j] && dist[j] < min) {
					min = dist[j];
					idx = j;
				}
			}
			// idx에는 이번에 선택한 정점이 들어있음
			visited[idx] = true;
			// 뽑은 정점과 연결된 간선들을 업데이트 하기
			for (int j = 0; j < V; j++) {
				if (!visited[j] && adjArr[idx][j] != 0 && dist[j] > adjArr[idx][j]) {
					dist[j] = adjArr[idx][j];
					p[j] = idx;

				}
			}
		}
		for (int i = 0; i < V; i++)
			ans += dist[i];

		System.out.println(ans);
	}// main
}
```
