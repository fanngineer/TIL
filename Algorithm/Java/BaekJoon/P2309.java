//�ϰ�������
package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class P2309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] heights = new int[9];
		//Ű �Է¹ޱ�
		for(int i=0;i<9;i++) heights[i] = sc.nextInt();
		//�ϰ� ������
		int n = 7; //�����̼�
		int[] dwarfs = new int[n];
		boolean[] selected = new boolean[heights.length];
		//������ ã�� �Լ�...
		find(heights, dwarfs,selected, n, 0);
		//���
		Arrays.sort(dwarfs);
		for(int i=0;i<n;i++) {
			System.out.println(dwarfs[i]);
		}
	}
	public static void find(int[] heights, int[] dwarfs,boolean[] selected, int n, int depth) {
		if(depth==n) {
			return;
		}
		for(int i=0; i<=heights.length-n; i++) {
			if(!selected[i]) {
				selected[i] = true;
				find(heights, dwarfs, selected, n, depth++);
			}
		}
	}
}
