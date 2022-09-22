package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14889_스타트와링크 {

	static int N;
	static int min;
	static int[][] table;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		// 능력치 표 입력받기
		table = new int[N][N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line);
			for (int j = 0; j < N; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[] selected = new boolean[N];
		min = Integer.MAX_VALUE;
		comb(0, 0, selected);

		// 출력
		System.out.println(min);
	}

	static void comb(int sel_idx, int start_idx, boolean[] selected) {
		// 기저조건
		if (sel_idx >= N / 2) {
			int start = 0;
			int link = 0;
			int[] s_members = new int[N / 2];
			int[] l_members = new int[N / 2];
			for (int i = 0; i < N; i++) {
				if (selected[i] == true)
					s_members[start++] = i;
				if (selected[i] == false)
					l_members[link++] = i;
			}
			start = 0;
			link = 0;
			for (int i : s_members) {
				for (int j : s_members) {
					start += table[i][j];
				}
			}
			for (int i : l_members) {
				for (int j : l_members) {
					link += table[i][j];
				}
			}
			

			int diff = Math.abs(start - link);
			if (min > diff) {
				min = diff;
			}
		} else {
			for (int i = start_idx; i <= N-N/2+sel_idx; i++) {
				// i번째를 뽑은 경우
				selected[i] = true;
				comb(sel_idx+1, i+1, selected);
				// i번재를 안뽑은 경우 >> 원상복구
				selected[i] = false;
			}
		} // else
	}// comb
}