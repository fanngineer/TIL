package BaekJoon;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P1753_최단경로 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); //정점의 개수
		int E = sc.nextInt(); //간선의 개수
		ArrayList<int[]>[] edges = new ArrayList[V];
		for(int i =0; i<V; i++) {
			edges[i] = new ArrayList<>();
		}
		int start = sc.nextInt(); //시작정점
		for(int i =0; i<E;i++) {
			int st = sc.nextInt()-1;
			int ed = sc.nextInt()-1;
			int w = sc.nextInt();
			
			edges[st].add(new int[] {ed,w});
		}//입력
		//다잌스트라
		boolean[] visited = new boolean[V];
		int[] distance = new int[V];
		
		
		distance[start-1] = 0; //시작정점 거리는 0
		//다잌스트라
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((s1,s2)->s1[1]-s2[1]); //연결된 배열을 넣기 위해서
		
		int nowV = start-1; //시작정점
		
		int sum = 0; //진행된 거리
		
		for(int i =0; i<V; i++) {
			visited[nowV] = true;//지금 정점 방문처리
			for(int j=0; j<edges[nowV].size();j++) {
				int[] nowEdge = edges[nowV].get(j);
				int nowEd = nowEdge[0];
				int nowW = nowEdge[1]+distance[nowV];
				
				pq.add(new int[] {nowEd, nowW}); //새로운 정점에서 갈 수 있는 곳 추가
			}
			while(!pq.isEmpty()) {
				int[] nowEdge = pq.poll();
				int nowEd = nowEdge[0];
				int nowW = nowEdge[1];
				//연결된 간선들 중에서 끝점이 방문한 적 없으면 선택
				if(visited[nowEd]==false) {
					nowV = nowEd;
					distance[nowV] = nowW;
					break;
				}
			}
		}//정점 순회
		
		for(int i =0; i<V; i++) {
			if(i==start-1) {
				System.out.println(0);
				continue;
			}
			if(distance[i]==0) {
				System.out.println("INF");
				continue;
			}
			System.out.println(distance[i]);
				
		}
		
	}//main
}
