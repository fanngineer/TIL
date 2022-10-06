package BJ;

import java.util.Scanner;

public class P9095_123더하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {

			int n = sc.nextInt();

			int[] memory = new int[12];

			memory[0] = 1;
			memory[1] = 1;
			memory[2] = 2;
			for (int i = 3; i <= n; i++) {
				memory[i] = memory[i - 1] + memory[i - 2] + memory[i-3];
			}
			System.out.println(memory[n]);
		}
	}
}
