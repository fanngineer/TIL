package SWEA;

import java.util.Scanner;
import java.io.FileInputStream;

public class P1210 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;
		int start= 0; // 출발점
		for (int test_case = 1; test_case <= T; test_case++) {
			int t = sc.nextInt(); // 테스트케이스 번호
			int N = 100; // 2차원 배열 크기
			int[][] boxes = new int[N][N]; // 2차원 배열 생성
			// 사다리 할당
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					boxes[i][j] = sc.nextInt();
				}
			}
			// 끝점 찾기
			for (int j = 0; j < N; j++) {
				if(boxes[99][j]==2) {
					start = j;
				}
			}
			// 위로 올라가기
			int i = 99;
			while(i<0) {
				int flag =0;
				//왼쪽이 1일때 
				while(start>=1 && boxes[i][start-1]==1) {
					start--;
					flag = 1;
				}
				if(flag==1) {
					i--;
					continue;
				}
				//오른쪽이 1일때
				while((start<=N-2) && (boxes[i][start+1]==1)) {
					start++;
				}
				//위로 한칸
				i--;
			}
			// i = 0 이면 그만두고 시작점을 반환 
			System.out.println("#" + t + " " + start);
		}
	}
}