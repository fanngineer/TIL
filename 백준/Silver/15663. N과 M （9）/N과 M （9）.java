import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class Main {
	static int N;
	static int M;
	static boolean[] visited;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		visited = new boolean[N];
		arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		queue = new LinkedList<>();
		res = new int[M];
		hs = new HashSet<>();
		comb(0);
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}
	static StringBuilder sb;
	static Queue<String> queue;
	static HashSet<String> hs;
	static int[] res;
	static void comb(int cnt) {
		if(cnt==M) {
			sb = new StringBuilder();
			for(int t : res) {
				sb.append(t).append(" ");
			}
			if(!hs.contains(sb.toString())) {
				hs.add(sb.toString());
				queue.add(sb.toString());
			}
			return;
		}
		for(int i = 0; i<N; i++) {
			if(visited[i]==false) {
				visited[i] = true;
				res[cnt] = arr[i];
				comb(cnt+1);
				visited[i] = false;
			}
		}
	}
}
