package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.StringTokenizer;

public class P3304_최장공통부분수열 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int t = 1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str1 = st.nextToken();
			String str2 = st.nextToken();
			int N1 = str1.length();
			int N2 = str2.length();
			int[][] memory = new int[N1+1][N2+1];
			for(int i = 1; i<=N1; i++) {
				char char1 = str1.charAt(i-1);
				for(int j=1; j<=N2; j++) {
					char char2 = str2.charAt(j-1);
					if(char1==char2) memory[i][j] = memory[i-1][j-1]+1;
					else memory[i][j] = Math.max(memory[i-1][j], memory[i][j-1]);
				}
			}
			bw.write("#"+t+" "+memory[N1][N2]);
			bw.newLine();
		}//TC
		bw.close();
	}
}
