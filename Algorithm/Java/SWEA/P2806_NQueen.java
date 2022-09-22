package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2806_NQueen {
	static int N;
	static int[][] queens;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			queens = new int[N][2];
			answer = 0;
			// 출력
			put(0);
			System.out.println("#" + t + " " + answer);
		} // testCase
	}// main
		// n번째 퀸을 놓는 함수

	static void put(int n) {
		if (n == N) {
			answer++;
			return;
		}
		for(int j = 0; j<N; j++) {
			int flag = 1;
			for (int k = 0; k < n; k++) {
				if (queens[k][1] == j) {
					flag = 0;
					break;
				}
				if (Math.abs(queens[k][0] - n) == Math.abs(queens[k][1] - j)) {
					flag = 0;
					break;
				}
			}
			if (flag == 1) {
				queens[n][0] = n;
				queens[n][1] = j;
				put(n + 1);
			}
		}
	}
}// class
