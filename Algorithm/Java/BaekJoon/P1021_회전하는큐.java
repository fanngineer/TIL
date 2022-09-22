package BJ;

import java.util.Scanner;

public class P1021_회전하는큐 {
	static int N;
	static int M;
	static int[] Queue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[] idxs = new int[M];
		for (int i = 0; i < M; i++) {
			idxs[i] = sc.nextInt();
		}
	}
}
