package BJ;

import java.util.Scanner;

public class P11048_이동하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] rooms = new int[N + 1][M + 1];
		int[][] memory = new int[N + 1][M + 1]; //저장할거야
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				rooms[i][j] = sc.nextInt();
			}
		}
		
		
		int[][] before = {{-1,0},{0,-1},{-1,-1}};
		for(int n=1; n<=N;n++) {
			for(int m=1; m<=M;m++) {
				int max = 0;
				for(int[] be : before) {
					int new_n = n+be[0];
					int new_m = m+be[1];
					if(memory[new_n][new_m]>max)
						max = memory[new_n][new_m];
				}

				memory[n][m] = rooms[n][m] + max;
			}
		}
		
		System.out.println(memory[N][M]);
	}
}
