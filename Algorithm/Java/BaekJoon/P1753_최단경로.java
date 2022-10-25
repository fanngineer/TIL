package BaekJoon;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P1753_�ִܰ�� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); //������ ����
		int E = sc.nextInt(); //������ ����
		ArrayList<int[]>[] edges = new ArrayList[V];
		for(int i =0; i<V; i++) {
			edges[i] = new ArrayList<>();
		}
		int start = sc.nextInt(); //��������
		for(int i =0; i<E;i++) {
			int st = sc.nextInt()-1;
			int ed = sc.nextInt()-1;
			int w = sc.nextInt();
			
			edges[st].add(new int[] {ed,w});
		}//�Է�
		//�ٟ彺Ʈ��
		boolean[] visited = new boolean[V];
		int[] distance = new int[V];
		
		
		distance[start-1] = 0; //�������� �Ÿ��� 0
		//�ٟ彺Ʈ��
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((s1,s2)->s1[1]-s2[1]); //����� �迭�� �ֱ� ���ؼ�
		
		int nowV = start-1; //��������
		
		int sum = 0; //����� �Ÿ�
		
		for(int i =0; i<V; i++) {
			visited[nowV] = true;//���� ���� �湮ó��
			for(int j=0; j<edges[nowV].size();j++) {
				int[] nowEdge = edges[nowV].get(j);
				int nowEd = nowEdge[0];
				int nowW = nowEdge[1]+distance[nowV];
				
				pq.add(new int[] {nowEd, nowW}); //���ο� �������� �� �� �ִ� �� �߰�
			}
			while(!pq.isEmpty()) {
				int[] nowEdge = pq.poll();
				int nowEd = nowEdge[0];
				int nowW = nowEdge[1];
				//����� ������ �߿��� ������ �湮�� �� ������ ����
				if(visited[nowEd]==false) {
					nowV = nowEd;
					distance[nowV] = nowW;
					break;
				}
			}
		}//���� ��ȸ
		
		for(int i =0; i<V; i++) {
			if(i==start-1) {
				System.out.println(0);
				continue;
			}
			if(distance[i]==0) {
				System.out.println("INF");
				continue;
			}
			System.out.println(distance[i]);
				
		}
		
	}//main
}
