package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P4012_요리사 {
	static int N;
	static int[][] table;
	static int[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int result;
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			table = new int[N][N];
			data = new int[N];
			// 식재료 입력받기
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				StringTokenizer st = new StringTokenizer(line);
				for (int j = 0; j < N; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
					data[j] = j;
				}
			}
			A = new int[N / 2];
			B = new int[N / 2];
			
			comb(0, 0); // A에 들어갈 음식 선정
		} // testCase
	}// main

	static ArrayList<int[]> A_cases = new ArrayList<>();
	
	static int[] A;
	static int[] B;
	static int taste_A;
	static int taste_B;
	// 일단 반반 나누고

	public static void comb(int idx, int sidx) {
		
		if (sidx == N / 2) {
			A_cases.add(A);
			for(int i =0; i<N; i++) {
				if(data)
			}
		} else if (idx >= N)
			return;
		else {
			A[sidx] = data[idx];
			comb(idx + 1, sidx + 1);
			comb(idx + 1, sidx);
		}
	}
}
