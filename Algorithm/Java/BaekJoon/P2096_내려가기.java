package BJ;

import java.util.Scanner;

public class P2096_내려가기 {
	static int max_score;
	static int min_score;
	static int[][] scores;
	static int N;
	static int[][] memory_max;
	static int[][] memory_min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //줄의 수;
		scores = new int[N+1][3];
		for(int i =1; i<N+1;i++) {
			scores[i][0] = sc.nextInt();
			scores[i][1] = sc.nextInt();
			scores[i][2] = sc.nextInt();
		}
		
		memory_max = new int[N+1][3]; //i번째 줄의 j칸에 있을때 최대 점수
		memory_min = new int[N+1][3]; //i번째 집을 j칸에 있을때 최소 점수
		
		for(int i =1; i<N+1;i++) {
			memory_max[i][0] = scores[i][0] + Math.max(memory_max[i-1][1], memory_max[i-1][0]);
			memory_max[i][1] = scores[i][1] + Math.max(Math.max(memory_max[i-1][0], memory_max[i-1][1]),memory_max[i-1][2]);
			memory_max[i][2] = scores[i][2] + Math.max(memory_max[i-1][1], memory_max[i-1][2]);
			
			memory_min[i][0] = scores[i][0] + Math.min(memory_min[i-1][1], memory_min[i-1][0]);
			memory_min[i][1] = scores[i][1] + Math.min(Math.min(memory_min[i-1][0], memory_min[i-1][1]),memory_min[i-1][2]);
			memory_min[i][2] = scores[i][2] + Math.min(memory_min[i-1][1], memory_min[i-1][2]);
		}
		
		min_score = 1000000;
		max_score = 0;
		for(int j=0; j<3;j++) {
			if(memory_min[N][j]<min_score)
				min_score = memory_min[N][j];
			if(memory_max[N][j]>max_score)
				max_score = memory_max[N][j];
		}
		
		System.out.println(max_score + " " + min_score);
	}//main
}
