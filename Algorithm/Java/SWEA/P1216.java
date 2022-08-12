package SWEA;

import java.util.Scanner;

public class P1216 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			sc.nextInt(); // 테스트케이스 입력
			char[][] boxes = new char[100][100]; // 검색대상
			// 문자입력
			for (int i = 0; i < 100; i++) {
				String sentence = sc.next(); // 문자열입력
				for (int j = 0; j < 100; j++) {
					boxes[i][j] = sentence.charAt(j);
				}
			}
			// 회문 검사
			int max = 0;
			// 가로줄
			for (int n = 1; n <= 100; n++) {
				for (int i = 0; i < 100; i++) {
					int flag2 = 0;
					for (int j = 0; j < 100 - n + 1; j++) {
						int flag = 1;
						for (int k = 0; k < n; k++) {
							if (boxes[i][j + k] != boxes[i][j + n - 1 - k]) {
								flag = 0;
								break;
							}
						}
						if (flag == 1) {
							max = n;
							flag2=1;
							break;
						}
					}
					if (flag2 == 1) {
						break;
					}
				}
				for (int i = 0; i < 100; i++) {
					int flag2 = 0;
					for (int j = 0; j < 100 - n + 1; j++) {
						int flag = 1;
						for (int k = 0; k < n; k++) {
							if (boxes[j + k][i] != boxes[j + n - 1 - k][i]) {
								flag = 0;
								break;
							}
						}
						if (flag == 1) {
							max = n;
							flag2=1;
							break;
						}
					}
					if (flag2 == 1) {
						break;
					}
				}
			}

			System.out.println("#" + test_case + " " + max);
		}
	}
}
