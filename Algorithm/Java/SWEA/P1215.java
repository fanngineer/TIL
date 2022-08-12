package SWEA;

import java.util.Scanner;

public class P1215 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			// �ܾ� �Է�
			int n = sc.nextInt(); // ȸ������
			char[][] boxes = new char[8][8]; // �˻����
			// �����Է�
			for (int i = 0; i < 8; i++) {
				String sentence = sc.next(); // ���ڿ��Է�
				for (int j = 0; j < 8; j++) {
					boxes[i][j] = sentence.charAt(j);
				}
			}
			// ȸ�� �˻�
			int cnt = 0;
			// ������
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
			//������
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
