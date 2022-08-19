package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class P1158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		Queue<Integer> people = new LinkedList<>();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		// 사람 할당
		for (int i = 1; i <= N; i++) {
			people.add(i);
		}
		// 삭제하면서 출력
		System.out.print("<");
		//아무도 없을때까지 지울거야
		while (!people.isEmpty()) {
			for(int i =0; i<K-1;i++) {
				people.add(people.poll());
			}
			System.out.print(people.poll()); //K번째 사람 지우면서 출력
			if(!people.isEmpty()) {
				System.out.print(", ");
			}
		} // while
		System.out.print(">");
	}// main
}
