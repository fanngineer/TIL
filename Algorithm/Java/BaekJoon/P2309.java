//일곱난쟁이
package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class P2309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] heights = new int[9];
		//키 입력받기
		for(int i=0;i<9;i++) heights[i] = sc.nextInt();
		//일곱 난쟁이
		int n = 7; //난쟁이수
		int[] dwarfs = new int[n];
		boolean[] selected = new boolean[heights.length];
		//난쟁이 찾는 함수...
		find(heights, dwarfs,selected, n, 0);
		//출력
		Arrays.sort(dwarfs);
		for(int i=0;i<n;i++) {
			System.out.println(dwarfs[i]);
		}
	}
	public static void find(int[] heights, int[] dwarfs,boolean[] selected, int n, int depth) {
		if(depth==n) {
			return;
		}
		for(int i=0; i<=heights.length-n; i++) {
			if(!selected[i]) {
				selected[i] = true;
				find(heights, dwarfs, selected, n, depth++);
			}
		}
	}
}
