package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.StringTokenizer;

public class P3282_knapsack {
	static int N;
	static int K;
	static int[] V;
	static int[] C;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			V = new int[N];
			C = new int[N];
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				V[i] = Integer.parseInt(st.nextToken());
				C[i] = Integer.parseInt(st.nextToken());
			}//입력
			
			//구동
			int[][] memory = new int[N+1][K+1];
			
			for(int i = 1; i<=N; i++) {
				int v = V[i-1];
				int c = C[i-1];
				for(int j = 1; j<=K; j++) {
					if(v>j) memory[i][j] = memory[i-1][j];
					else {
						memory[i][j] = Math.max(memory[i-1][j], memory[i-1][j-v]+c);
					}
				}
			}
			//출력
			bw.write("#" + t + " " + memory[N][K]);
			bw.newLine();
		}//testCase
		bw.close();
	}//main	
}
