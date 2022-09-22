package BJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class P2981_검문 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] nums = new int[N];
		for(int i =0; i<N;i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);
		int min = 1000000000;
		int diff;
		for(int i =0; i<N-1;i++) {
			diff = nums[i+1]-nums[i];
			if(diff<min) {
				min = diff;
			}
		}
		ArrayList<Integer> Y = find(min);
		for(int y : Y) {
			int flag = 1;
			int r = nums[0]%y;
			for(int i =1; i<N;i++) {
				if(nums[i]%y!=r) {
					flag=0;
					break;
				}
			}
			if(flag==1) {
				System.out.print(y+" ");
			}
		}
	}
	//n의 약수집합(1제외)
	static ArrayList<Integer> find(int n) {
		ArrayList<Integer> y = new ArrayList<>();
		for(int i=2; i<=n ;i++) {
			if(n%i==0)
				y.add(i);
		}
		return y;
	}
}
