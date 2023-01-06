package BJ;

import java.util.Arrays;
import java.util.Scanner;


public class P15654_N과M {
	static int N;
	static int M;
	static int[] Ns;
	static int[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		Ns = new int[N];
		visited = new int[N];
		
		for(int n=0;n<N;n++) {
			Ns[n] = sc.nextInt();
		}
		Arrays.sort(Ns);
		perm(0, "");
	}
	
	//재귀함수
	static void perm(int idx, String st) {
		//기저조건
		if(idx==M) {
			System.out.println(st);
			return;
		}
		//반복문
		for(int i =0; i<N; i++) {
			if(visited[i]==0) {
				int now = Ns[i];
				visited[i] = 1;
				perm(idx+1, st + Integer.toString(now) + " ");
				visited[i] = 0;
			}
		}
	}//perm
}
