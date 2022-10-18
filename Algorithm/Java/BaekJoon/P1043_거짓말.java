package BaekJoon;

import java.util.ArrayList;
import java.util.Scanner;

public class P1043_������ {

	static int N;
	static int M;
	static int K;
	static int[] Ks;
	static int[] parent;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // ����� ��
		M = sc.nextInt(); // ��Ƽ�� ��
		
		K = sc.nextInt(); // ������ �ƴ� ����� ��
		Ks = new int[N+1]; //������ �ƴ� ������� ��ȣ
		parent = new int[N+1]; //������ �ƴ� ������� ��ȣ
		
		
		//makeSet
		for(int n = 0; n<N+1; n++) {
			parent[n] = n;
		}
		
		//Ks�� �ش� ��ȣ�� ������ �˸� 1
		for (int k = 0; k < K; k++) {
			Ks[sc.nextInt()] = 1;
		}
		
		//�� ��Ƽ����
		int cnt = 0;
		
		ArrayList<Integer>[] Ps = new ArrayList[M]; //��Ƽ���� ���� ����� ����
		for (int m = 0; m < M; m++) {
			Ps[m] = new ArrayList<>();
			int p = sc.nextInt();//�ش� ��Ƽ�� ���� ����� ��

			int x = sc.nextInt(); //��Ƽ�� ÷ �� ���
			Ps[m].add(x);
			for (int i = 1; i < p; i++) {
				int y = sc.nextInt(); //���� �� ��� ��ȣ
				Ps[m].add(y);
				union(x,y);
			}
		}
		
		//��Ƽ���� �˻�
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
			parent[findSet(y)] = findSet(x); //y�� ���� ��ǥ���� ��ǥ�ڷ� x�� ���� ��ǥ�ڸ� �ֱ�
		}else
			parent[findSet(x)] = findSet(y); //x�� ���� ��ǥ���� ��ǥ�ڷ� y�� ���� ��ǥ�ڸ� �ֱ�
	}
}
