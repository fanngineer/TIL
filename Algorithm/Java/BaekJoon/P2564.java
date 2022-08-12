//����
package Baekjoon;

import java.util.Scanner;

public class P2564 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int stores = sc.nextInt();
		int[][] location = new int[stores + 1][2];// ������ ��ġ �迭
		// ���� ��ġ �Է�
		for (int i = 0; i < stores; i++) {
			location[i][0] = sc.nextInt();
			location[i][1] = sc.nextInt();
		}
		// ������ ��ġ
		location[stores][0] = sc.nextInt();
		location[stores][1] = sc.nextInt();
		// �迭�� �� �캸��
		int[] lotost = new int[stores + 1];
		for (int i = 0; i <= stores; i++) {
			if (location[i][0] == 1)
				lotost[i] = location[i][1];
			if (location[i][0] == 4)
				lotost[i] = m + location[i][1];
			if (location[i][0] == 2)
				lotost[i] = m + n + m - location[i][1];
			if (location[i][0] == 3)
				lotost[i] = m + n + m + n - location[i][1];
		}
		// ���� �ϳ��ϳ� �Ÿ�ã��
		int sum = 0;
		for (int i = 0; i < stores; i++) {
			int diff = Math.abs(lotost[stores] - lotost[i]);
			if (diff > m+n) {
				diff = 2*(m+n) - diff;
			}
			sum += diff;
		}
		System.out.println(sum);
	}
}
