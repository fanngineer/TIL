package BJ;

import java.util.Scanner;

public class P9663_NQueen {
	static int N;
	static int[] Queens;
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// n번재 퀸은 행이 n이고 열을 리스트에 저장
		Queens = new int[N];
		put(0);
		System.out.println(cnt);
	}

	// n번째 퀸을 놓는 함수 >> 0부터 시작
	static void put(int n) {
		// 기저조건
		if (n >= N) {
			cnt++;
			return;
		} else {
			// 행은 n으로 고정, j열에 들어갈수있는지 확인
			for (int j = 0; j < N; j++) {
				int flag = 1;
				// n번째 이전의 퀸들과 검사
				for (int k = 0; k < n; k++) {
					// 이전 친구랑 열을 비교
					if (Queens[k] == j) {
						flag = 0;
						break;
					}
					// 이전 친구랑 대각선 비교
					if (Math.abs(n - k) == Math.abs(Queens[k] - j)) {
						flag = 0;
						break;
					}
				}
				// 겹치는거 없으면 n행에 j열 넣고 다음으로
				if(flag==1) {
					Queens[n] = j;
					put(n+1);
				}
			}
		}
	}
}
