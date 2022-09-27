package SWEA;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class P2105_디저트카페 {
	static int N;
	static int[][] cafes;
	static int answer;
	static int[][] direc = { { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };
	static HashSet<Integer> deserts;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			// 입력
			N = sc.nextInt();
			cafes = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cafes[i][j] = sc.nextInt();
				}
			}

			// 구동
			answer = -1;
			for (int i = 0; i < N - 2; i++) {
				for (int j = 1; j < N - 1; j++) {
					cafe(i, j);
				}
			}

			// 출력
			System.out.println("#" + t + " " + answer);
		} // testCase
	}// main
		// 직사각형의 변의 길이 조합 구하기

	static void cafe(int i, int j) {
		// int left; //1부터 i까지 가능
		// int right; //N-1-j-left까지 가능
		for (int left = 1; left <= j; left++) {
			int right_max = Math.min(N - 1 - i - left, N-1-j);
			for (int right = 1; right <= right_max; right++) {
				// right*left 직사각형으로 순회하기
				deserts = new HashSet<>();
				find(i, j, right, left);
				if (deserts.size() == right * 2 + left * 2) {
					if (deserts.size() > answer)
						answer = deserts.size();
				}
			}
		}
	}// cafe
		// i,j에서 직사각형으로 순회하는 함수

	static void find(int i, int j, int right, int left) {
		int x = i;
		int y = j;
		for (int dx = 1; dx <= right; dx++) {
			x += direc[0][0];
			y += direc[0][1];
			deserts.add(cafes[x][y]);
		}
		for (int dx = 1; dx <= left; dx++) {
			x += direc[1][0];
			y += direc[1][1];
			deserts.add(cafes[x][y]);
		}
		for (int dx = 1; dx <= right; dx++) {
			x += direc[2][0];
			y += direc[2][1];
			deserts.add(cafes[x][y]);
		}
		for (int dx = 1; dx <= left; dx++) {
			x += direc[3][0];
			y += direc[3][1];
			deserts.add(cafes[x][y]);
		}
	}// find
}
