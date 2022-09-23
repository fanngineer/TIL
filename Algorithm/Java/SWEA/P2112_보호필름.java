package SWEA;

import java.util.Scanner;

public class P2112_보호필름 {
	static int D;
	static int W;
	static int K;
	static int[] rows;
	static int r;
	static int[][] film;
	static int[][] new_film;
	static int flag;
	static int[] A_layer;
	static int[] B_layer;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			// 입력
			D = sc.nextInt(); // 두께
			W = sc.nextInt(); // 가로
			K = sc.nextInt(); // 합격기준
			film = new int[D][W];

			for (int i = 0; i < D; i++) {
				for (int j = 0; j < W; j++) {
					film[i][j] = sc.nextInt();
				}
			}
			
			// 구동
					
			new_film = new int[D][W];
			for (int i = 0; i < D; i++) {
				System.arraycopy(film[i], 0, new_film[i], 0, W);
			}
			
			
			A_layer = new int[W];
			B_layer = new int[W];
			for (int i = 0; i < W; i++) {
				A_layer[i] = 0;
				B_layer[i] = 1;
			}
			
			flag = 0;
			
			r = 0;
			
			if(isOkay(new_film)==true) {
				flag =1;
			}
			
			while(flag == 0) {
				r++;
				rows = new int[r];
				comb(0,0);
			}
			
			// 출력
			System.out.println("#" + t + " " + r);

		} // for_testCase
	}//main
	
	//D개 중에 R개를 찾아내는 조합
	static void comb(int sidx, int idx) {
		if(sidx>=r) {
			//r개를 뽑았을때 경우의 수
			for(int i=0; i<(1<<r);i++) {
				for(int j=0;j<r;j++) {
					if(((1<<j)&i)>0)
						new_film = change_B(rows[j]);
					else
						new_film = change_A(rows[j]);
				}
				if(isOkay(new_film) == true) {
					flag = 1;
					return;
				}
				//new_film 초기화
				for (int k : rows) {
					System.arraycopy(film[k], 0, new_film[k], 0, W);
				}
			}
			return;
		}
		else {
			//idx가 포함?
			for(int i=idx;i<=D-r+sidx;i++) {
				rows[sidx] = i;
				comb(sidx+1,i+1);
			}
		}
	}
	
	//n번째 행에 0~D-1 약품att를 투입하는 함수
	static int[][] change_A(int n){
		System.arraycopy(A_layer, 0, new_film[n], 0, W);
		return new_film;
	}
	static int[][] change_B(int n){
		System.arraycopy(B_layer, 0, new_film[n], 0, W);
		return new_film;
	}
	//성능검사
	static boolean isOkay(int[][] film) {
		boolean okay = true;
		for (int j = 0; j < W; j++) {
			boolean pass = false;
			int cnt=1;
			for (int i = 1; i < D; i++) {
				if(film[i-1][j]==film[i][j])
					cnt++;
				else
					cnt = 1;
				if(cnt == K) {
					pass = true;
					break;
				}
			}
			if(pass==false) {
				okay = false;
				break;
			}
		}
		return okay;
	}//isOkay
}
