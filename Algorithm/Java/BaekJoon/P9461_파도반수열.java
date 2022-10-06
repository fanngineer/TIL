package BJ;

import java.util.Scanner;

public class P9461_파도반수열 {
	static int N;
	static long[] memory;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			memory = new long[N+1];
			int[] start = {0,1,1,1,2,2,3,4,5,7,9};
			if(N<=5)
				System.out.println(start[N]);
			else {
				for(int i = 0; i<=5; i++)
					memory[i] = start[i];
				for(int i=6; i<=N; i++)
					memory[i]=memory[i-1]+memory[i-5];
				System.out.println(memory[N]);
			}
		}
	}//main
}
