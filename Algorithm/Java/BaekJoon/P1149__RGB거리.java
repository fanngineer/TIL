package BJ;

import java.util.Scanner;

public class P1149__RGB거리 {
	static int min_cost;
	static int[][] cost;
	static int N;
	static int[][] memory;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //집의 수;
		cost = new int[N+1][3]; //집을 칠할때 드는 비용
		for(int i =1; i<N+1;i++) {
			cost[i][0] = sc.nextInt();
			cost[i][1] = sc.nextInt();
			cost[i][2] = sc.nextInt();
		}
		
		memory = new int[1001][3]; //i번째 집을 j색으로 칠할때 최소 비용
		
		for(int i =1; i<N+1;i++) {
			memory[i][0] = cost[i][0] + Math.min(memory[i-1][1], memory[i-1][2]);
			memory[i][1] = cost[i][1] + Math.min(memory[i-1][0], memory[i-1][2]);
			memory[i][2] = cost[i][2] + Math.min(memory[i-1][0], memory[i-1][1]);
		}
		
		min_cost = 1000000;
		for(int j=0; j<3;j++) {
			if(memory[N][j]<min_cost)
				min_cost = memory[N][j];
		}
		
		System.out.println(min_cost);
	}//main
}
