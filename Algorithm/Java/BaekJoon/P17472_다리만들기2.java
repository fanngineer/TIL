package BJ;

import java.util.ArrayList;
import java.util.Scanner;

public class P17472_다리만들기2 {
	static class Island {
		ArrayList<int[]> land;

		public Island() {
		}

	}

	static int N;
	static int M;
	static int[][] map;
	static ArrayList<Island> islands;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		} // 입력

		islands = new ArrayList<>();

		// 섬찾기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					Island now = new Island();
					search(i, j);
				}
			}
		}//섬찾기
		
		//가능한 다리 찾기
		visited = new int[islands.size()];
		
		
		
		

	}// main
	static Island now;
	static int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int[] visited;
	
	static void search(int i, int j) {
		// 여기 확인했음!
		now.land.add(new int[] {i,j});
		map[i][j] = 0;
		int k = 1;
		for (int[] di : directions) {
			int new_i = i + di[0];
			int new_j = j + di[1];
			if (new_i >= 0 && new_i < N && new_j >= 0 && new_j < M) {
				if (map[new_i][new_j] == 1)
					search(new_i, new_j);
			}
		}
	}
}
