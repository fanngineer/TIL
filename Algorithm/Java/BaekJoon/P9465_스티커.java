package BaekJoon;

import java.util.Scanner;

public class P9465_스티커 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int[][] stickers = new int[2][n];
			int[][] memory = new int[2][n];

			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < n; j++) {
					stickers[i][j] = sc.nextInt();
				}
			}//입력
			
			memory[0][0] = stickers[0][0];
			memory[1][0] = stickers[1][0];
			if(n>1) {
				memory[0][1] = memory[1][0]+stickers[0][1];
				memory[1][1] = memory[0][0]+stickers[1][1];
			}
			for (int j = 2; j <n ; j++) {
				memory[0][j] = Math.max(memory[1][j-1], memory[1][j-2])+stickers[0][j];
				memory[1][j] = Math.max(memory[0][j-1], memory[0][j-2])+stickers[1][j];
			}
			
			System.out.println(Math.max(memory[0][n-1], memory[1][n-1]));
			

		}//testCase
	}
}
