package BaekJoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P11729_하노이탑  {
	static int move = 0;
	static Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 원판의 갯수
		hanoi(N,1,3);
		System.out.println(move);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(!queue.isEmpty()) {
			bw.write(queue.poll()+" "+queue.poll()+"\n");
		}
		bw.flush();
		bw.close();
	}

	public static void hanoi(int N, int start, int end) {
		// 종료조건
		if (N == 1) {
			queue.offer(start);
			queue.offer(end);
			move++;
		} else {
			hanoi(N-1, start, 6-start-end);
			queue.offer(start);
			queue.offer(end);
			move++;
			hanoi(N-1, 6-start-end, end);
		}
	}
}
