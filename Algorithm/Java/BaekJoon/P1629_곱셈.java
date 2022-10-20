package BaekJoon;

import java.util.Scanner;

public class P1629_°ö¼À {
	static int A;
	static int B;
	static int C;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();

		System.out.println(multiple(B));
	}

	static long multiple(int b) {
		long answer;
		// ±âÀú Á¶°Ç
		if (b == 1)
			return A;
		if (b == 0)
			return 1;
		if (b % 2 == 0) {
			long newB = multiple(b/2);
			answer = newB*newB%C;
		}else {
			long newB = multiple(b/2);
			answer = A*newB*newB%C;
		}
		return answer;
	}
}
