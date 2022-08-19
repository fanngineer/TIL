package Baekjoon;

import java.util.Scanner;

public class P2563 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //������ ��
		int[][] canvas = new int[1000][1000]; //��ȭ��
		//������ �Է¹ޱ�
		for(int i =0; i<n;i++) {
			int x = sc.nextInt(); //���ϴ�x��ǥ (��ǥ��ġ�� �Ű�Ƚᵵ ������!)
			int y = sc.nextInt(); //���ϴ�y��ǥ
			//������ ����
			for(int j=0;j<10;j++) {
				for(int k=0;k<10;k++) {
					canvas[y+j][x+k] = 1;
				}				
			}
		}
		//��ĥ�� ĭ �� ���Ƹ���
		int cnt=0;
		for(int j=0;j<1000;j++) {
			for(int k=0;k<1000;k++) {
				if (canvas[j][k] == 1) cnt++;
			}		
		}
		System.out.println(cnt);
	}
}
