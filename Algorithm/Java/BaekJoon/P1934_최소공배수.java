package BJ;

import java.util.Scanner;

public class P1934_최소공배수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int answer;
			int A = sc.nextInt();
			int B = sc.nextInt();

			// A에 더 작은 수 넣기
			if (A > B) {
				int temp = A;
				A = B;
				B = temp;
			}
			int max = gcd(B, A); // 최대공약수

			
			answer = A * B / max;

			// 출력
			System.out.println(answer);
		}
	}// main

	static int gcd(int a, int b) {
		while (b != 0) {
			int new_a = b;
			b = a % b;
			a = new_a;
		}
		return a;
	}
}
