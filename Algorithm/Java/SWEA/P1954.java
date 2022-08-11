package SWEA;

import java.util.Scanner;
import java.io.FileInputStream;

public class P1954 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 달팽이 크기
			int[][] boxes = new int[N][N]; // N*N 달팽이 생성
			// 달팽이 할당
			int i =0;
			int j =0;
			boxes[i][j] = 1;
			int n = 2; //박스에 2부터 넣기
			while(n<=N*N) {
				//오른쪽이 비면 오른쪽으로 가기
				while(j+1<N && boxes[i][j+1] == 0 ){
					boxes[i][++j] = n++;
				}
				//아래쪽이 비면 아래쪽으로 가기
				while(i+1<N && boxes[i+1][j] == 0){
					boxes[++i][j] = n++;
				}
				//왼쪽이 비면 왼쪽으로 가기
				while(j-1>=0 && boxes[i][j-1] == 0){
					boxes[i][--j] = n++;
				}
				//윗쪽이 비면 윗쪽으로 가기
				while(i-1>=0 && boxes[i-1][j] == 0){
					boxes[--i][j] = n++;
				}
			}
			System.out.println("#"+test_case);
			for(int p=0;p<N;p++) {
				for(int k=0;k<N;k++) {
					System.out.print(boxes[p][k]+" ");
				}
				System.out.println();
			}
		}
	}
}