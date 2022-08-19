package Baekjoon;

import java.util.ArrayList;
import java.util.Arrays;

public class P4673 {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 1; i <= 10000; i++) {
			arr.add(i);
		}
		for (int i = 1; i <= 10000; i++) {
			int n=i;
			while(d(n)<=10000) {
				if(arr.contains(d(n)))
					arr.						
				n = d(n);
			}
		}
	}
	//d(n)함수
	static int d(int n) {
		int a=n/1000; //1000의 자리수
		int b=(n-(a*1000))/100; //100의 자리수
		int c= (n-a*1000-b*100)/10;//10의 자리수
		int d= (n-a*1000-b*100-c*10);//1의 자리수
		return n+a+b+c+d;
	}
}
