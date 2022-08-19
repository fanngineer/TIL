package Baekjoon;

import java.util.Scanner;

public class P2304 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 기둥의 개수
		int[][] paper = new int[1001][1001];//L값,H값
		int L;
		int H;
		int HMAX = 0;
		int LforHMAX = 0;
		int LMAX = 0;//마지막 지점
		for (int i = 0; i < N; i++) {
			L = sc.nextInt();
			H = sc.nextInt();
			if(H>HMAX) {
				HMAX = H; //높이 최대값 구하기
				LforHMAX = L; // 최대값일때 L값
			} 
			if(L>LMAX) LMAX = L; //기둥 마지막 위치 구하기
			paper[L][H] = 1; //기둥의 가장 높은점 표시하기
		}
		//탐색하기
		int area = 0;
		int curr = 0;
		//최고점까지 탐색
		for (int i =1; i<=LforHMAX;i++) {
			//올라가면서 끝점 찾기
			for(int j =1; j<=HMAX;j++) {
				//기둥끝점을 찾을때
				if(paper[i][j] == 1) {
					//기둥이 현재 최고점보다 높으면
					if(j>curr)
						curr = j; //현재의 최고점 표시
					break; //그만 올라가
				}
			}
			area += curr;
		}
		//끝점부터 최고점까지 탐색
		curr = 0;
		for (int i = LMAX; i>LforHMAX;i--) {
			//올라가면서 끝점 찾기
			for(int j =1; j<=HMAX;j++) {
				//기둥끝점을 찾을때
				if(paper[i][j] == 1) {
					//기둥이 현재 최고점보다 높으면
					if(j>curr)
						curr = j; //현재의 최고점 표시
					break; //그만 올라가
				}
			}
			area += curr;
		}
		System.out.println(area);
	}
}
