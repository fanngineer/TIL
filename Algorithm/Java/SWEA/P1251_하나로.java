package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1251_하나로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine()); // 섬의 개수
			String line_x = br.readLine();
			String line_y = br.readLine();
			int[] x = new int[N];
			int[] y = new int[N];

			StringTokenizer stx = new StringTokenizer(line_x);
			StringTokenizer sty = new StringTokenizer(line_y);

			for (int i = 0; i < N; i++) {
				x[i] = Integer.parseInt(stx.nextToken());// i번째 섬의 x좌표
				y[i] = Integer.parseInt(sty.nextToken());// i번째 섬의 y좌표
			}

			double E = Double.parseDouble(br.readLine()); // 세율

			double cost = 0; // 총 비용

			// prim알고리즘
			ArrayList<Integer> selected = new ArrayList<>();

			PriorityQueue<Edge> inTree = new PriorityQueue<>();
			
			Edge edge1 = new Edge(0,0);
			inTree.add(edge1); // i번째부터 시작
			
			while(!inTree.isEmpty()) {
				Edge now = inTree.poll();
				if(selected.contains(now.st)){
					continue;
				}else {
					selected.add(now.st);
					cost += now.cost;
					for(int w = 0; w < N; w++) {
						if(!selected.contains(w)) {
							double dist = Math.pow(x[now.st] - x[w], 2) + Math.pow(y[now.st] - y[w], 2);
							double cost_now = dist*E;
							Edge new_edge = new Edge(w,cost_now);
							inTree.add(new_edge);
						}
					}
				}
			}
			
			

			// 출력
			System.out.println("#" + t + " " + (long)Math.round(cost));
		} // testCase
	}// main
	static class Edge implements Comparable<Edge>{
		int st;
		double cost;
		Edge(int st, double cost) {
			this.st = st;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge o) {
			if(this.cost - o.cost>0)
				return 1;
			return -1;
		}
	}
}//class
