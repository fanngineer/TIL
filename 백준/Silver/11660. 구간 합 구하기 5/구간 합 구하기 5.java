import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] table;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		table = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				int input = Integer.parseInt(st.nextToken());
				table[i][j] = table[i][j-1]+table[i-1][j]-table[i-1][j-1]+input;
			}
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int answer = 0;
			answer += table[x2][y2];
			answer -= table[x1-1][y2];
			answer -= table[x2][y1-1];
			answer += table[x1-1][y1-1];
			System.out.println(answer);
		}
		
	}
}
