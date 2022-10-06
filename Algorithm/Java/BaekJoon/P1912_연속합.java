package BJ;

import java.util.Scanner;

public class P1912_연속합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for(int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		int[] memory = new int[n];
		memory[0] = nums[0];
		int max = nums[0];
		for(int i=1; i<n; i++) {
			if(memory[i-1]>=0) {
				memory[i] = memory[i-1] + nums[i];
			}
			else
				memory[i] = nums[i];
			if(memory[i]>max)
				max = memory[i];
		}
		System.out.println(max);
	}
}
