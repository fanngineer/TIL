package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class P1932_Á¤¼ö_»ï°¢Çü {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n  = Integer.parseInt(br.readLine());
		int[][] triangle = new int[n][n];
		int[][] dp = new int[n][n];
		for(int h =0; h<n; h++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int w = 0; w<=h; w++) {
				triangle[h][w] = Integer.parseInt(st.nextToken());
				if(h==0) {
					dp[0][0] = triangle[0][0];
					continue;
				}
				if (w == 0) {
					dp[h][w] = dp[h - 1][w] + triangle[h][w];
				} else if (w == h) {
					dp[h][w] = dp[h - 1][w - 1] + triangle[h][w];
				} else {
					dp[h][w] = Math.max(dp[h - 1][w], dp[h - 1][w - 1]) + triangle[h][w];
				}
			}
		}
		
		int answer = 0;
		for (int i = 0; i < n; i++) {
			if (dp[n - 1][i] > answer)
				answer = dp[n - 1][i];
		}
		System.out.println(answer);
	}
}
