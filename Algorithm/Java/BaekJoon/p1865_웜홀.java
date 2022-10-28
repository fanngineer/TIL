package BaekJoon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class p1865_웜홀 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();
		for (int t = 0; t < TC; t++) {
			// 입력
			int N = sc.nextInt(); // 지점의 수
			int M = sc.nextInt(); // 도로의수
			int W = sc.nextInt(); // 웜홀의 수

			int[] distance = new int[N]; //거리 배열
			int[] p = new int[N]; //부모 배열

			
			for (int i = 0; i < N; i++) {
				distance[i] = 100000; //모든 정점의 거리 무한으로 초기화
				p[i] = i; //부모배열에 자기자신 넣기
			}

			//도로 입력 받기
			int[][] times = new int[N][N];
			HashSet<int[]> edges = new HashSet<>();
			for (int i = 0; i < M; i++) {
				int st = sc.nextInt() - 1; //시작정점
				int ed = sc.nextInt() - 1; //끝정점
				int time = sc.nextInt(); //소요시간
				
				if(times[st][ed]==0) {
					times[st][ed] = time;
					times[ed][st] = time;
				}else {
					if(times[st][ed]>time) {
						times[st][ed] = time;
						times[ed][st] = time;
					}
				}
				edges.add(new int[] {st, ed});
				edges.add(new int[] {ed, st});
			} // 도로 입력

			for (int i = 0; i < W; i++) {
				int st = sc.nextInt() - 1; //시작정점
				int ed = sc.nextInt() - 1; //끝정점
				int time = -sc.nextInt(); //소요시간

				times[st][ed] = time;
				edges.add(new int[] {st, ed});
			} // 웜홀 입력

			//벨만 포드 - N번 실행
			distance[0] = 0; //시작점
			
			int flag = 1; //가능하면 0, 불가능하면 1
			for(int i =0; i<N;i++) {
				flag = 1;
				for(int[] edge : edges) {
					int st = edge[0]; //지금 간선의 시작점
					int ed = edge[1]; //지금 간선의 끝점
					//끝점에 저장된 거리 최소값으로 업데이트
					if(distance[ed]>distance[st]+times[st][ed]) {
						//업데이트 해야하면
						distance[ed] = distance[st]+times[st][ed];
						flag = 0;
					}
				}
			}
				
			
			if (flag == 0)
				System.out.println("YES");
			else
				System.out.println("NO");

		} // testcase
	}// main
}
