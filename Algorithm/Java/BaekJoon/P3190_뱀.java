package BaekJoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P3190_뱀 {

	static int N;
	static int K;
	static int[][] map;
	static int L;
	// 머리의 좌표
	static int hr;
	static int hc;
	// 방향
	static int d;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 }; // ^ > v < 방향정보 0123

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		map = new int[N + 2][N + 2];

		for (int k = 0; k < K; k++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x][y] = 2; // 사과아아
		}

		L = sc.nextInt(); // 방향 변환 횟수

		Queue<String> queueC = new LinkedList<>();
		Queue<Integer> queueX = new LinkedList<>();
		for (int k = 0; k < L; k++) {
			int X = sc.nextInt();
			String C = sc.next();
			queueX.add(X);
			queueC.add(C);
		}
		
		Queue<Integer> qsr = new LinkedList<>();
		Queue<Integer> qsc = new LinkedList<>();

		for (int i = 0; i < N + 2; i++) {
			map[0][i] = 1;
			map[i][0] = 1;
			map[N + 1][i] = 1;
			map[i][N + 1] = 1;
		} // 경계조건

		// 초기조건
		int time = 0;
		hr = 1;
		hc = 1;
		qsr.add(hr);
		qsc.add(hc);

		map[hr][hc] = 1;
		d = 1;

		int nowX = queueX.poll();
		String nowC = queueC.poll();

		
		// 시간이 흐른당
		while (true) {
			time++;

			// 먼저 뱀은 몸길이를 늘려 머리를 다음칸에
			hr = hr + dr[d];
			hc = hc + dc[d];

			// 벽이거나 몸이면 끝!
			if (map[hr][hc] == 1)
				break;

			qsr.add(hr);
			qsc.add(hc);
			// 사과가 아닌경우
			if (map[hr][hc] == 0) {
				map[hr][hc] = 1;
				int tr = qsr.poll();
				int tc = qsc.poll();
				map[tr][tc] = 0; // 꼬리 줄이기
			}

			//사과라면
			if (map[hr][hc] == 2) {
				map[hr][hc] = 1;
			}
			// 머리바꿀 시간이 되면
			if (time == nowX) {
				if (nowC.equals("L"))
					d = (d + 3) % 4;
				if (nowC.equals("D"))
					d = (d + 1) % 4;
				if (!queueX.isEmpty()) {
					nowX = queueX.poll();
					nowC = queueC.poll();
				}
			}

		}
		System.out.println(time);
	}// main
}
