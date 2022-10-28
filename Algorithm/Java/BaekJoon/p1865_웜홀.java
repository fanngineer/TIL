package BaekJoon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class p1865_��Ȧ {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();
		for (int t = 0; t < TC; t++) {
			// �Է�
			int N = sc.nextInt(); // ������ ��
			int M = sc.nextInt(); // �����Ǽ�
			int W = sc.nextInt(); // ��Ȧ�� ��

			int[] distance = new int[N]; //�Ÿ� �迭
			int[] p = new int[N]; //�θ� �迭

			
			for (int i = 0; i < N; i++) {
				distance[i] = 100000; //��� ������ �Ÿ� �������� �ʱ�ȭ
				p[i] = i; //�θ�迭�� �ڱ��ڽ� �ֱ�
			}

			//���� �Է� �ޱ�
			int[][] times = new int[N][N];
			HashSet<int[]> edges = new HashSet<>();
			for (int i = 0; i < M; i++) {
				int st = sc.nextInt() - 1; //��������
				int ed = sc.nextInt() - 1; //������
				int time = sc.nextInt(); //�ҿ�ð�
				
				if(times[st][ed]==0) {
					times[st][ed] = time;
					times[ed][st] = time;
				}else {
					if(times[st][ed]>time) {
						times[st][ed] = time;
						times[ed][st] = time;
					}
				}
				edges.add(new int[] {st, ed});
				edges.add(new int[] {ed, st});
			} // ���� �Է�

			for (int i = 0; i < W; i++) {
				int st = sc.nextInt() - 1; //��������
				int ed = sc.nextInt() - 1; //������
				int time = -sc.nextInt(); //�ҿ�ð�

				times[st][ed] = time;
				edges.add(new int[] {st, ed});
			} // ��Ȧ �Է�

			//���� ���� - N�� ����
			distance[0] = 0; //������
			
			int flag = 1; //�����ϸ� 0, �Ұ����ϸ� 1
			for(int i =0; i<N;i++) {
				flag = 1;
				for(int[] edge : edges) {
					int st = edge[0]; //���� ������ ������
					int ed = edge[1]; //���� ������ ����
					//������ ����� �Ÿ� �ּҰ����� ������Ʈ
					if(distance[ed]>distance[st]+times[st][ed]) {
						//������Ʈ �ؾ��ϸ�
						distance[ed] = distance[st]+times[st][ed];
						flag = 0;
					}
				}
			}
				
			
			if (flag == 0)
				System.out.println("YES");
			else
				System.out.println("NO");

		} // testcase
	}// main
}
