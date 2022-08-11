package SWEA;

import java.util.Scanner;
import java.io.FileInputStream;

public class P1961 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 배열
			int[][] boxes = new int[N][N]; // N*N 행렬 생성
			int[][] boxes_90 = new int[N][N]; // 90회전 행렬 생성
			int[][] boxes_180 = new int[N][N]; //180 회전 행렬 생성
			int[][] boxes_270 = new int[N][N]; //270회전 행렬 생성
			// 배열 할당
			for(int i =0; i<N;i++){
				for(int j =0; j<N;j++){
					boxes[i][j] = sc.nextInt();
				}
			}
			// 행렬 회전시키기
			// 90도
			for(int i =0; i<N;i++){
				for(int j =0; j<N;j++){
					boxes_90[j][N-1-i] = boxes[i][j];
				}
			}
			// 180도
			for(int i =0; i<N;i++){
				for(int j =0; j<N;j++){
					boxes_180[N-1-i][N-1-j] = boxes[i][j];
				}
			}
			// 270도
			for(int i =0; i<N;i++){
				for(int j =0; j<N;j++){
					boxes_270[N-1-j][N-1-i] = boxes[i][j];
				}
			}
			//출력
			System.out.println("#"+test_case);
			for(int p=0;p<N;p++) {
				for(int k=0;k<N;k++) {
					System.out.print(boxes_90[p][k]);
				}
				System.out.print(" ");
				for(int k=0;k<N;k++) {
					System.out.print(boxes_180[p][k]);
				}
				System.out.print(" ");
				for(int k=0;k<N;k++) {
					System.out.print(boxes_270[p][k]);
				}
				System.out.println();
			}
		}
	}
}