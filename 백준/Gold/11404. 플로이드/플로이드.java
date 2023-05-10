import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //도시의수 100
		int m = Integer.parseInt(br.readLine()); //버스의수 100000
		ArrayList<int[]>[] edges = new ArrayList[n];
		for(int i = 0; i<n; i++) { edges[i] = new ArrayList<>();}
		
		for(int i = 0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1; //시작도시
			int b =  Integer.parseInt(st.nextToken())-1; //도착도시
			int c =  Integer.parseInt(st.nextToken()); //비용
			edges[a].add(new int[] {b,c});
		}//입력
		int[][] costs = new int[n][n];
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(i==j) continue;
				costs[i][j] = Integer.MAX_VALUE;
			}
		}
		for(int i = 0; i<n; i++) {
			//출발점이 i
			boolean[] visited = new boolean[n];
			int cnt = 0;
			int point = i;

			while(cnt != n) {
				visited[point] = true;
				cnt++;
				
				for(int[] edge : edges[point]) {
					int end = edge[0];
					int cost = edge[1];
					if(visited[end]== true) continue;
					if( costs[i][end]>costs[i][point]+cost) {
						costs[i][end] = costs[i][point]+cost;
					}
				}
				int min = Integer.MAX_VALUE;
				int next = point;
				for(int j = 0; j<n; j++) {
					if(visited[j]== true) continue;
					if(costs[i][j]<min) {
						min = costs[i][j];
						next = j;
					}
				}
				point = next;
			}
		}//for
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(costs[i][j]==Integer.MAX_VALUE) costs[i][j] = 0;
				System.out.print(costs[i][j]+" ");
			}
			System.out.println();
		}//출력
	}
}
