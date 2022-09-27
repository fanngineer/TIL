package BJ;

import java.util.Scanner;

public class P1904_01타일 {
	static int cnt;
	static int origin;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cnt = 0;
		//00이 0개 1개 ...N/2개
		origin = (int) (Math.pow(2, N)-1);
		count(0);
		System.out.println();
	}
	static void count(int n) {
		if(n==N/2)
		for(int n=0; n<=N/2;n++) {
			
			
			
			
		}//for
	}//count
}
