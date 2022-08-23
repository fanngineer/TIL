package Baekjoon;

import java.util.Scanner;

public class P10870_피보나치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(F(n));
	}
	public static int F(int n) {
		if(n<=1)
			return n;
		return F(n-1)+F(n-2);
	}
}
