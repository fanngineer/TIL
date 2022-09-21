package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P4012_요리사 {
	static int N;
	static int[][] table;
	static int[] selected;
	static int R;
	static int min;
	static int A = 0;
	static int B = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int result;
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			R = N / 2;
			min = Integer.MAX_VALUE;
			table = new int[N][N];
			selected = new int[N];
			// tabled에 식재료 시너지 입력받기
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				StringTokenizer st = new StringTokenizer(line);
				for (int j = 0; j < N; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			comb(0, 0); // A에 들어갈 음식 선정
			System.out.println("#" + t + " " + min);
		} // testCase
	}// main

	// 일단 반반 나누고

	public static void comb(int idx, int sidx) {

		if (sidx == N / 2) {
			A = 0;
			B = 0;
			for (int i = 0; i < N; i++) {
				// B의 시너지
				for (int j = 0; j < N; j++) {
					if (selected[i] == 0 && selected[j] == 0) {
						B += table[i][j];
					} else if(selected[i] == 1 && selected[j] == 1) {
						A += table[i][j];
					}
				}//for
			}
			if (min > Math.abs(A - B))
				min = Math.abs(A - B);
			return;
		} else if (idx >= N)
			return;
		else {
			selected[idx] = 1;
			comb(idx + 1, sidx + 1);
			selected[idx] = 0;
			comb(idx + 1, sidx);
			return;
		}
	}
}
