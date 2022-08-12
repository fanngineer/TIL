// ÆÑÅä¸®¾ó
package Baekjoon;

import java.util.Scanner;

public class P10872 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(fact(N));
	}

	private static int fact(int n) {
		if(n==0||n==1) {
			return 1;
		}
		return n*fact(n-1);
	}
}
