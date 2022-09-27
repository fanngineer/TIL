package BJ;

import java.util.ArrayList;
import java.util.Scanner;

public class P24416_피보나치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		memory = new ArrayList<>();
		memory.add(0);
		cnt1 = 0;
		cnt2 = 0;
		fib(n);
		fibonacci(n);
		System.out.println(cnt1+" "+cnt2);
	}
	static int cnt1;
	static int cnt2;
	static int fib(int n) {
		if(n==1 || n==2) {
			cnt1++;
			return 1;
		}else {
			return fib(n-1)+fib(n-2);
		}
	}
	static ArrayList<Integer> memory;
	static int fibonacci(int n) {
		memory.add(1,1);
		memory.add(2,1);
		for(int i =3;i<=n; i++) {
			cnt2++;
			memory.add(i,memory.get(i-1)+memory.get(i-2));
		}
		return memory.get(n);
	}
}
