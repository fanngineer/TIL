package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11725_트리의_부모찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n  = Integer.parseInt(br.readLine());
		int[] height = new int[n+1];
		int[] parent = new int[n+1];
		ArrayList<Integer>[] connected = new ArrayList[n+1];
		
		boolean[] visited = new boolean[n+1];
		
		for(int h =0; h<n+1; h++) {
			connected[h] = new ArrayList<>();
		}
		for(int h =0; h<n-1; h++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			connected[num1].add(num2);
			connected[num2].add(num1);
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(1);
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int next : connected[now]) {
				if(visited[next]==false) {
					parent[next] = now;
					visited[next] = true;
					queue.add(next);
				}
			}
		}
		for(int i = 2; i<= n; i++) {
			System.out.println(parent[i]);
		}
		
		
		
	}
}
