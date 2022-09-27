package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class P7733_치즈도둑 {
	static int[][] cheese;
	static int N;
	static int piece;
	static int[][] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			//입력
			N = sc.nextInt();
			cheese = new int[N+2][N+2];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					cheese[i][j] = sc.nextInt();
				}
			}
			int max=0;
			for(int day = 0; day<=100; day++) {
				visited = new int[N+2][N+2];
				piece = 0; //치즈 조각
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						if(cheese[i][j] >day&&visited[i][j]==0) {
							check(i,j,day);
							piece++;
						}
					}
				}
				if(piece > max) {
					max = piece;
				}
			}//for_day
			System.out.println("#"+t+" "+max);
		}//testCase
	}//main
	static int[][] direction = {{-1,0},{0,1},{1,0},{0,-1}};
	static void check(int i, int j, int day) {
		visited[i][j]=1;
		for(int[] di : direction) {
			int x = i+di[0];
			int y = j+di[1];
			if(cheese[x][y] >day&&visited[x][y]==0) {
				check(x,y,day);
			}
		}
	}
}
