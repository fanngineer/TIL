package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2447_별찍기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N;
		N = Integer.parseInt(br.readLine());
		
		char[][] stars = new char[N][N]; 
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<N;j++) {
				stars[i][j] = '*';
			}
		}
		star(0,0,N,stars);
		for(int i = 0;i<N;i++) {
			StringBuilder sb = new StringBuilder();
			for(int j = 0;j<N;j++) {
				sb.append(stars[i][j]);
			}
			System.out.println(sb.toString());
		}
		br.close();
	}//main
	public static void star(int start_x,int start_y,int N,char[][] stars) {
		//종료조건
		if(N==1) {
			return;
		}
		//반복구간
		for(int i = start_x+N/3;i<start_x+2*N/3;i++) {
			for(int j = start_y+N/3;j<start_y+2*N/3;j++) {
				stars[i][j] = ' ';
			}
		}
		for(int i =0;i<3; i++) {
			for(int j =0;j<3;j++) {
				star(start_x+i*N/3,start_y+j*N/3,N/3,stars);
			}
		}
	}
}
