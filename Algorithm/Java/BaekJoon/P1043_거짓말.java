package BaekJoon;

import java.util.ArrayList;
import java.util.Scanner;

public class P1043_거짓말 {

	static int N;
	static int M;
	static int K;
	static int[] Ks;
	static int[] parent;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 사람의 수
		M = sc.nextInt(); // 파티의 수
		
		K = sc.nextInt(); // 진실을 아는 사람의 수
		Ks = new int[N+1]; //진실을 아는 사람들의 번호
		parent = new int[N+1]; //진실을 아는 사람들의 번호
		
		
		//makeSet
		for(int n = 0; n<N+1; n++) {
			parent[n] = n;
		}
		
		//Ks의 해당 번호가 진실을 알면 1
		for (int k = 0; k < K; k++) {
			Ks[sc.nextInt()] = 1;
		}
		
		//각 파티마다
		int cnt = 0;
		
		ArrayList<Integer>[] Ps = new ArrayList[M]; //파티마다 오는 사람들 저장
		for (int m = 0; m < M; m++) {
			Ps[m] = new ArrayList<>();
			int p = sc.nextInt();//해당 파티에 오는 사람의 수

			int x = sc.nextInt(); //파티에 첨 온 사람
			Ps[m].add(x);
			for (int i = 1; i < p; i++) {
				int y = sc.nextInt(); //지금 온 사람 번호
				Ps[m].add(y);
				union(x,y);
			}
		}
		
		//파티마다 검사
		for (int m = 0; m < M; m++) {
			int flag = 1;
			for (int i = 0; i < Ps[m].size(); i++) {
				if(Ks[findSet(Ps[m].get(i))]==1) {
					flag = 0;
					break;
				}
			}
			if(flag ==1)
				cnt++;
		}
		System.out.println(cnt);
	}//main
	
	
	static int findSet(int x) {
		if(x != parent[x])
			parent[x] = findSet(parent[x]);
		return parent[x];
	}
	static void union(int x, int y) {
		if(Ks[findSet(x)]==1) {
			parent[findSet(y)] = findSet(x); //y의 최종 대표자의 대표자로 x의 최종 대표자를 넣기
		}else
			parent[findSet(x)] = findSet(y); //x의 최종 대표자의 대표자로 y의 최종 대표자를 넣기
	}
}
