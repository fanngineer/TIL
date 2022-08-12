package SWEA;

import java.util.Scanner;

public class P1215 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			// 단어 입력
			int n = sc.nextInt(); // 회문길이
			char[][] boxes = new char[8][8]; // 검색대상
			// 문자입력
			for (int i = 0; i < 8; i++) {
				String sentence = sc.next(); // 문자열입력
				for (int j = 0; j < 8; j++) {
					boxes[i][j] = sentence.charAt(j);
				}
			}
			// 회문 검사
			int cnt = 0;
			// 가로줄
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8-n+1; j++) {
					int flag = 1;
					for (int k = 0; k < n; k++) {
						if (boxes[i][j + k] != boxes[i][j + n - 1 - k]) {
							flag = 0;
							break;
						}
					}
					cnt += flag;
				}
			}
			//세로줄
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8-n+1; j++) {
					int flag = 1;
					for (int k = 0; k < n; k++) {
						if (boxes[j + k][i] != boxes[j + n - 1 - k][i]) {
							flag = 0;
							break;
						}
					}
					cnt += flag;
				}
			}
			System.out.println("#" + test_case + " " + cnt);
		}
	}
}
