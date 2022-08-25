package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11315_오목판정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		// 테스트케이스
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine()); //문자열 수
			char[][] board = new char[N][N]; //오목판
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				//오목판에 돌 넣기
				for (int j = 0; j < N; j++) {
					board[i][j] = str.charAt(j);
				}
			}
			//오목인지 체크하기-가로줄
			int flag = 0; //오목이면 1
			for (int i = 0; i < N; i++) {
				int cnt = 0;
				for (int j = 0; j < N; j++) {
					if(board[i][j] == 'o') {
						cnt++;
						if(cnt==5) {
							flag = 1;
							break;
						}
					}else {
						cnt = 0;
					}
				}
				if(flag==1)
					break;
			}
			//오목인지 체크하기-세로줄
			for (int i = 0; i < N; i++) {
				int cnt = 0;
				for (int j = 0; j < N; j++) {
					if(board[j][i] == 'o') {
						cnt++;
						if(cnt==5) {
							flag = 1;
							break;
						}
					}else {
						cnt = 0;
					}
				}
				if(flag==1)
					break;
			}
			//오목인지 체크하기-대각선(우하단)
			//(N-1,0)>>(N-1,1)(N-2,0)>>(N-1,2)(N-2,1)(N-3,0)
			for (int i = 0; i < N; i++) {
				int cnt = 0;
				for (int j = 0; j <= i; j++) {
					if(board[N-1-j][i-j] == 'o') {
						cnt++;
						if(cnt==5) {
							flag = 1;
							break;
						}
					}else {
						cnt = 0;
					}
				}
				if(flag==1)
					break;
			}
			//오목인지 체크하기-대각선(좌상단)(N-1번 반복)\\방향
			for (int i = 1; i < N; i++) {
				int cnt = 0;
				for (int j = 0; j < i; j++) { //i번 반복
					if(board[j][N-i+j] == 'o') {
						cnt++;
						if(cnt==5) {
							flag = 1;
							break;
						}
					}else {
						cnt = 0;
					}
				}
				if(flag==1)
					break;
			}
			//오목인지 체크하기-대각선(우상단)//방향
			for (int i = 1; i <= N; i++) {
				int cnt = 0;
				for (int j = 0; j < i; j++) { //i번 반복
					if(board[j][i-j-1] == 'o') {
						cnt++;
						if(cnt==5) {
							flag = 1;
							break;
						}
					}else {
						cnt = 0;
					}
				}
				if(flag==1)
					break;
			}
			//오목인지 체크하기-대각선(좌하단)//방향
			for (int i = 1; i <= N-1; i++) {
				int cnt = 0;
				for (int j = 0; j < i; j++) { //i번 반복
					if(board[N-1-j][N-i+j] == 'o') {
						cnt++;
						if(cnt==5) {
							flag = 1;
							break;
						}
					}else {
						cnt = 0;
					}
				}
				if(flag==1)
					break;
			}
			if(flag==1)
			System.out.println("#" + t + " " + "YES");
			if(flag==0)
				System.out.println("#" + t + " " + "NO");
		} // testCase
	}// main
}
