package SWEA;

import java.util.Scanner;

public class P14510_나무높이 {

	static int N;
	static int[] TREES;
	static int TALLEST;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			TREES = new int[N];
			TALLEST = 0;

			for (int i = 0; i < N; i++) {
				int tree = sc.nextInt();
				TREES[i] = tree;
				if (tree > TALLEST)
					TALLEST = tree;
			} // 입력끝!
				// 차이로 만드러주기
			int cnt = 0; // 완성된 나무 갯수
			for (int i = 0; i < N; i++) {
				if (TREES[i] == TALLEST)
					cnt++;
				TREES[i] = TALLEST - TREES[i];
			}

			int day = 0;

			while (cnt < N) {
				day++;
				int grow;// 나무 자라는 키
				// 홀수날이면 1, 짝수날이면 2
				if (day % 2 == 0)
					grow = 2;
				else
					grow = 1;

				int flag = 1;
				int flag2 = 1;
				for (int i = 0; i < N; i++) {
					// 무지성 빼기
					if (TREES[i] == grow) {
						TREES[i] -= grow;
						cnt++;
						flag = 0;
						flag2 = 0;
						break;
					}
				} // for
				if(flag2==1) {
					for (int i = 0; i < N; i++) {
						if (TREES[i] >= 3) {
							TREES[i] -= grow;
							flag = 0;
							break;
						}
					}
				}
				if (flag == 1) {
					if (grow == 2) {
						continue;
					}
					// 무조건 grow는 1이고, 남은 친구들은 2인 상황
					int num2 = 0;
					for (int i = 0; i < N; i++) {
						if (TREES[i] == 2)
							num2++;
					}
					if (num2 * 2 % 3 == 2)
						continue;
					for (int i = 0; i < N; i++) {
						if (TREES[i] > 0) {
							TREES[i]--;
							break;
						}
					}

				}

			} // while
			System.out.println("#" + t + " " + day);
		} // testCase
	}// main
}// class
