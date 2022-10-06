package BJ;

import java.util.Scanner;

public class P1003_피보나치함수 {
	static int N; // 계단의수
	static int[][] memory; // i번째 계단을 밟는 경우 중 최대값을 저장

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력
		int T = sc.nextInt(); // 계단의 수 입력받기 <=300
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			memory = new int[41][2];

			memory[0][0] = 1;
			memory[0][1] = 0;
			memory[1][0] = 0;
			memory[1][1] = 1;
			
			for(int i=2; i<=N;i++) {
				memory[i][0] = memory[i-1][0]+memory[i-2][0];
				memory[i][1] = memory[i-1][1]+memory[i-2][1];
				
			}

			System.out.println(memory[N][0] + " " + memory[N][1]);
		}
	}// main
}
