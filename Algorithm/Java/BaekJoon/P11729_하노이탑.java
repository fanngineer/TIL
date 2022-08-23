package Baekjoon;

import java.util.Scanner;

public class P11729_하노이탑 {
	static int move = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 원판의 갯수
		hanoi(N,1,3);
	}

	public static void hanoi(int N, int start, int end) {
		// 종료조건
		if (N == 1) {
			move++;
			
			System.out.println(move);
			System.out.println(start+" "+end);
			
		} else {
			hanoi(N-1, start, 6-start-end);
			System.out.println(start+" "+end);//마지막 원판 옮기기
			move++;
			hanoi(N-1, 6-start-end, end);
		}
	}
}
