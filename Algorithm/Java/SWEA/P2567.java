package Baekjoon;

import java.util.Scanner;

public class P2567 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // ������ ��
		int[][] canvas = new int[102][102]; // ��ȭ��
		// ������ �Է¹ޱ�
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt(); // ���ϴ�x��ǥ (��ǥ��ġ�� �Ű�Ƚᵵ ������!)
			int y = sc.nextInt(); // ���ϴ�y��ǥ
			// ������ ����
			for (int j = 1; j <= 10; j++) {
				for (int k = 1; k <= 10; k++) {
					canvas[y + j][x + k] = 1;
				}
			}
		}
		// ��� ���Ƹ���
		int cnt = 0;
		// ���� �� Ž��
		for (int j = 0; j < 101; j++) {
			for (int k = 0; k < 101; k++) {
				cnt += Math.abs(canvas[j][k] - canvas[j][k + 1]);
			}
		}
		// ���� �� Ž��
		for (int j = 0; j < 101; j++) {
			for (int k = 0; k < 101; k++) {
				cnt += Math.abs(canvas[k][j] - canvas[k + 1][j]);
			}
		}
		System.out.println(cnt);
	}
}
