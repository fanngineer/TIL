package SWEA;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P2930_힙 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
			int N = sc.nextInt();// 수행할 연산의 수
			sc.nextLine();
			// 연산 입력받기
			System.out.print("#" + test_case);
			for (int i = 0; i < N; i++) {
				String order = sc.nextLine();
				if (order.equals("2")) {
					System.out.print(" ");
					// 일단 지운거 출력하고
					if(!heap.isEmpty()) {
						System.out.print(heap.poll());
					}else {
						System.out.print(-1);
					}
					// 다시 정렬해야해
				} else {
					StringTokenizer st = new StringTokenizer(order);
					st.nextToken();
					int number = Integer.parseInt(st.nextToken());
					heap.offer(number);
				}
			}
			// 출력
			System.out.println();
		} // for
	}// main
		// 연산1
}
