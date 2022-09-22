package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15649_NM1 {
	static int[] nums;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[M+1];
		boolean[] visited = new boolean[N+1];
		comb(1,visited);
	}

	static void comb(int n, boolean[] visited) {
		if(n>M) {
			StringBuilder sb = new StringBuilder();
			for(int i = 1; i<=M;i++) {
				sb.append(nums[i]+" ");
			}
			System.out.println(sb.toString());
			return;
		}
		for(int i=1; i<=N; i++) {
			if(visited[i] == false) {
				nums[n] = i;
				visited[i] = true;
				comb(n+1,visited);
				visited[i] = false;
			}
		}
	}
}
