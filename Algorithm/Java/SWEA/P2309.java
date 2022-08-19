package Baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P2309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 난쟁이 키 담을 배열
		int[] heights = new int[9];
		int sum = 0; // 난쟁이 키합
		// 난쟁이 입력받기
		for (int i = 0; i < 9; i++) {
			heights[i] = sc.nextInt();
			sum += heights[i]; // 9난쟁이의 키합
		}
		// 일곱난쟁이 아닌친구 찾기
//		ArrayList<Integer> real = new ArrayList<>();// 진짜 난쟁이를 담아줄곳
		int[] real = new int[7];
		for (int i = 0; i < 8; i++) {
			int flag = 1;
			for (int j = i + 1; j < 9; j++) {
				int check = sum - heights[i] - heights[j]; // 난쟁이 두명을 빼버림
				// 난쟁이 찾으면
				if (check == 100) {
					// 두명빼고 출력하고
					int x = 0;
					for (int k = 0; k < 9; k++) {
						if ((k != i) && (k != j))
//							real.add(heights[k]);
						{
								real[x++] = heights[k];
						}
					}
					// 끝내기
					flag = 0;
					break;
				} // if - check
			} // 두번째 조합for문
			if (flag == 0)
				break;
		} // 난쟁이찾기 for문
			// 정렬!
//		for (int i = 0; i < real.size() - 2; i++) {
//			for (int j = 0; j < real.size() - 1-i; j++) {
//				if (real.get(j) > real.get(j + 1)) {
//					int tmp = real.get(j);
//					real.set(j, real.get(j + 1));
//					real.set(j + 1, tmp);
//				}
//			}
//		}
		Arrays.sort(real);
		// 출력!
		for (int i = 0; i < 7; i++)
			System.out.println(real[i]);

	}// main
}
