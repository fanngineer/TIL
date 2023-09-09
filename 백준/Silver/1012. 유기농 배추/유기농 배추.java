
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int warms;
	static int N;
	static int M;
	static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int i = 0; i<tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			int K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			for(int k = 0; k<K; k++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				map[Y][X] = 1;
			}
			warms = 0;
			//로직
			for(int y = 0; y<N; y++) {
				for(int x = 0; x<M; x++) {
					if(visited[y][x]==false && map[y][x] == 1) {
						warms++;
						dfs(y,x);
					}
				}
			}
			System.out.println(warms);
		}
	}
	static int[][] di = {{1,0},{-1,0},{0,1},{0,-1}};
	static void dfs(int y, int x) {
		visited[y][x] = true;
		for(int[] d : di) {
			int newY = y+d[0];
			int newX = x+d[1];
			if(newY>=N || newY<0) continue;
			if(newX>=M || newX<0) continue;
			if(visited[newY][newX]==false && map[newY][newX]>0) {
				dfs(newY,newX);
			}
		}
	}
}
