package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17070_파이프옮기기 {
	static int cnt = 0;
	static int N;
	static int[][] house;

	public static void main(String[] args) throws IOException {
		// 처음 파이프의 상태 {끝점행, 끝점열, 방향}
		int[] pipe = { 1, 2, 0 };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// 집에다가 입력값 넣기
		house = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line);
			for (int j = 1; j <= N; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		doit(pipe[0],pipe[1],pipe[2]);
		System.out.println(cnt);
	}

	public static void doit(int r, int c, int o) {
		if(r==N&&c==N) {
			cnt++;
			return;
		}
		//옮기기
		//가로일때
		if (o == 0)
			{
			//옮기기1번
			if(c<N&& house[r][c+1] != 1)
			doit(r,c+1,0);
			//옮기기 2번
			if(c<N&&r<N&&house[r][c+1]!=1&&house[r+1][c]!=1&&house[r+1][c+1]!=1)
			doit(r+1,c+1,2);
			}//if(o==0)
		//세로일때
		else if(o==1)
		{
			//옮기기1번
			if(r<N&& house[r+1][c] != 1)
				doit(r+1,c,1);
			//옮기기 2번
			if(c<N&&r<N&&house[r][c+1]!=1&&house[r+1][c]!=1&&house[r+1][c+1]!=1)
				doit(r+1,c+1,2);
		}//if(o==1)
		//대각선일때
		else {
			//옮기기1번
			if(c<N&& house[r][c+1] != 1)
				doit(r,c+1,0);
			//옮기기 2번
			if(r<N&& house[r+1][c] != 1)
				doit(r+1,c,1);
			//옮기기 3번
			if(c<N&&r<N&&house[r][c+1]!=1&&house[r+1][c]!=1&&house[r+1][c+1]!=1)
				doit(r+1,c+1,2);
		}//else
	}
}
