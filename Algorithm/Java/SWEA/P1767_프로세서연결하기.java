package SWEA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P1767_프로세서연결하기 {
	static int N;
	static int[][] Processor;
	static int answer;
	static int[][] direction = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int numCore;
	static ArrayList<int[]> cores;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			// 입력
			cores = new ArrayList<>();
			N = sc.nextInt();
			Processor = new int[N][N];
			numCore = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					Processor[i][j] = sc.nextInt();
					if (Processor[i][j] == 1) {
						if (i == 0 || j == 0 || i == N - 1 || j == N - 1) {
							Processor[i][j] = 2; // (연결된 코어는 2로 표시)
						} else {
							int[] co = { i, j };
							cores.add(co);
							numCore++;
						}
					}
				}
			}
			cnt_max = 0;
			answer = 150;
			// 코어를 순회
			doit(0, 0, 0);

			// 출력
			System.out.println("#" + t + " " + answer);

		} // for_testCase
	}// main

	static int cnt_max;

	// 재귀로 할래
	static void doit(int idx, int root, int cnt) {
		if (idx >= numCore) {
			if (cnt_max == cnt) {
				if (answer > root)
					answer = root;
			}
			if (cnt_max < cnt) {
				answer = root;
				cnt_max = cnt;
			}
			return;
		}

		// 코어마다
		int[] core = cores.get(idx);
		// 방향마다
		for (int di = 0; di < 4; di++) {
			if (isAvail(di, core)) {
				// 연결하는 경우
				int i = core[0] + direction[di][0];
				int j = core[1] + direction[di][1];
				int k = 0;
				while (i >= 0 && i < N && j >= 0 && j < N) {
					Processor[i][j] = 2;
					i += direction[di][0];
					j += direction[di][1];
					k++;
				}
				doit(idx + 1, root + k, cnt + 1);

				// 연결안하는경우
				i = core[0] + direction[di][0];
				j = core[1] + direction[di][1];

				while (i >= 0 && i < N && j >= 0 && j < N) {
					Processor[i][j] = 0;
					i += direction[di][0];
					j += direction[di][1];
				}
			}
		}

		doit(idx + 1, root, cnt);
	}

	// 연결가능한지 체크하는 함수
	static boolean isAvail(int di, int[] core) {
		int i = core[0] + direction[di][0];
		int j = core[1] + direction[di][1];
		while (i >= 0 && i < N && j >= 0 && j < N) {
			if (Processor[i][j] != 0) {
				return false;
			}
			i += direction[di][0];
			j += direction[di][1];
		}
		return true;
	}

}
