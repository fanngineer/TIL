package Baekjoon;

import java.util.Scanner;

public class P2567 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 색종이 수
		int[][] canvas = new int[102][102]; // 도화지
		// 색종이 입력받기
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt(); // 좌하단x좌표 (좌표위치는 신경안써도 괜찮다!)
			int y = sc.nextInt(); // 좌하단y좌표
			// 색종이 덮기
			for (int j = 1; j <= 10; j++) {
				for (int k = 1; k <= 10; k++) {
					canvas[y + j][x + k] = 1;
				}
			}
		}
		// 경계 세아리기
		int cnt = 0;
		// 세로 선 탐색
		for (int j = 0; j < 101; j++) {
			for (int k = 0; k < 101; k++) {
				cnt += Math.abs(canvas[j][k] - canvas[j][k + 1]);
			}
		}
		// 가로 선 탐색
		for (int j = 0; j < 101; j++) {
			for (int k = 0; k < 101; k++) {
				cnt += Math.abs(canvas[k][j] - canvas[k + 1][j]);
			}
		}
		System.out.println(cnt);
	}
}
