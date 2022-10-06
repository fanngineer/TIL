package BJ;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P17472_다리만들기2 {

	static int N;
	static int M;
	static int[][] map;
	static int[][] edges;

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		} // 입력

		// 섬찾기
		int k = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					search(i, j, k++);

				}
			}
		} // 섬찾기

		// 가능한 다리 찾기
		edges = new int[k][k]; // 섬은 2부터 k-1까지 있음
		search2();
		int numB = 0;
		for (int i = 2; i < k; i++) {
			for (int j = 2; j < k; j++) {
				if (edges[i][j] > 0) {
					numB++;
				}
			}
		} // 다리 갯수 세아리기
		int[][] edges2 = new int[numB][3];

		// 다리 정렬하기
		int idx = 0;
		for (int i = 2; i < k; i++) {
			for (int j = 2; j < k; j++) {
				if (edges[i][j] > 0) {
					edges2[idx][0] = i; // start
					edges2[idx][1] = j; // end
					edges2[idx][2] = edges[i][j]; // length
					idx++;
				}
			}
		}
		Arrays.sort(edges2, new Comparator<int[]>() {

			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		// 크루스칼 알고리즘
		int[] P = new int[k]; // 대표자 집합
		for (int i = 2; i < k; i++) {
			P[i] = i;
		} // makeSet

		int cost = 0;
		int pick = 0;
		for (int i = 0; i < numB; i++) {
			if (P[edges2[i][0]] == P[edges2[i][1]]) {
			} else {
				int change = P[edges2[i][1]];
				for (int j = 2; j < k; j++) {
					if (P[j] == change) {
						P[j] = P[edges2[i][0]];
					}
				}
				pick++;
				cost +=edges2[i][2];
			}
			if (pick == k - 3) {
				break;
			}
		}
		if (pick != k - 3) {
			cost = -1;
		}

		if (cost == 0) {
			cost = -1;
		}

//		//최소신장트리 찾기
//		int[] distance = new int[k]; //거리값 저장할거야
//		int[] distance_one = new int[k];
//		for(int i =3; i<k;i++) {
//			distance[i] = Integer.MAX_VALUE; //무한대로 초기화
//		}//2부터 시작할거양
//		
//		int cost=0;//가중치 합
//		int minV=2; //2부터 시작
//		int[] visited = new int[k];
//		visited[2] = 1;
//		//그냥 반복
//		for(int i=2; i<k-1;i++) {
//			int next = -1;
//			//정점사이의 거리 최소값구하기
//			for(int j=2; j<k;j++) {
//				int dist = cost+edges[minV][j]+edges[j][minV];
//				if(dist != cost&&dist<distance[j]) {
//					distance[j] = dist;
//					distance_one[j] = edges[minV][j]+edges[j][minV];
//				}
//			}
//			int minD = Integer.MAX_VALUE;
//			for(int j=2; j<k;j++) {
//				System.out.println("cost" +cost + "j" +j + "minV" +minV);
//				if(visited[j] == 0&& distance[j]<minD) {
//					minD = distance[j];
//					next = j;
//				}
//			}
//			if(next ==-1) {
//				cost = -1;
//				break;
//			}
//			minV = next;
//			visited[next] = 1;
//			cost += distance_one[next];
//			System.out.println(Arrays.toString(distance));
//			System.out.println(Arrays.toString(visited));
//		}
		System.out.println(cost);
	}// main
		// 섬찾기

	static int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static void search(int i, int j, int k) {
		// 여기 확인했음!
		map[i][j] = k;
		for (int[] di : directions) {
			int new_i = i + di[0];
			int new_j = j + di[1];
			if (new_i >= 0 && new_i < N && new_j >= 0 && new_j < M) {
				if (map[new_i][new_j] == 1)
					search(new_i, new_j, k);
			}
		}
	}

	// 간선찾기
	static void search2() {
		// 가로 간선
		for (int i = 0; i < N; i++) {
			int start = 1; // 간선 시작점
			int end = 1; // 간선 끝점
			int length = 0; // 간선 길이
			for (int j = 0; j < M; j++) {
				if (length < 2) {
					if (map[i][j] != 0) {
						start = map[i][j];
						length = 0;
					} else {
						if (start != 1)
							length++;
					}
				} else {
					if (map[i][j] == 0) {
						length++;

					} else {
						end = map[i][j];
						if (edges[start][end] == 0)
							edges[start][end] = length;
						else if (edges[start][end] > length)
							edges[start][end] = length;
						length = 0;
					}
				}
			}
		}
		// 세로 간선
		for (int j = 0; j < M; j++) {
			int start = 1; // 간선 시작점
			int end = 1; // 간선 끝점
			int length = 0; // 간선 길이
			for (int i = 0; i < N; i++) {
				if (length < 2) {
					if (map[i][j] != 0) {
						start = map[i][j];
						length = 0;
					} else {
						if (start != 1)
							length++;
					}
				} else {
					if (map[i][j] == 0) {
						length++;

					} else {
						end = map[i][j];
						if (edges[start][end] == 0)
							edges[start][end] = length;
						else if (edges[start][end] > length)
							edges[start][end] = length;
						length = 0;
					}
				}
			}
		}
	}// search2
}
