package BJ;

import java.util.Scanner;

public class P17069_파이프옮기기2 {
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //집의 크기
		int[][] house = new int[N+1][N+1];
		
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				house[r][c] = sc.nextInt();
			}
		}

		
		//DP시작!
		
		long[][][] memory = new long[N+1][N+1][3];
		//저장 [][][0] 최종 가로   // [][][1] 최종세로   // [][][2] 최종 대각선
		
		//초기조건
		memory[1][2][0] = 1;
		
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				//[r][c]에 가로로 도착하는 경우
				if(house[r][c]==0)
					memory[r][c][0] += memory[r][c-1][0]+memory[r][c-1][2];
				//[r][c]에 세로로 도착하는 경우
				if(house[r][c]==0)
					memory[r][c][1] += memory[r-1][c][1]+memory[r-1][c][2];
				//[r][c]에 대각선으로 도착하는 경우
				if(house[r][c]==0&&house[r-1][c]==0&&house[r][c-1]==0)
					memory[r][c][2] += memory[r-1][c-1][0]+memory[r-1][c-1][1]+memory[r-1][c-1][2];
			}
		}
		
		
		
		System.out.println(memory[N][N][0]+memory[N][N][1]+memory[N][N][2]);
	}
}
