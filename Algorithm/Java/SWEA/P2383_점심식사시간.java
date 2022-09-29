package SWEA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2383_점심식사시간 {
	static int N;
	static int[][] map;
	static ArrayList<int[]> people;
	static ArrayList<int[]> stairs;
	static int[] stair1;
	static int[] stair2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			// 입력
			N = sc.nextInt();
			int answer = Integer.MAX_VALUE;
			map = new int[N][N];
			int now;

			people = new ArrayList<>();
			stairs = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					now = sc.nextInt();
					if (now == 1)
						people.add(new int[] { i, j });
					if (now > 1) {
						stairs.add(new int[] { i, j, now });

					}
				}
			}

			Queue<Integer>[] st = new Queue[2];

			// 구동
			// 계단 2개에 사람 나누기, 0이면 1번 계단, 1이면 2번 계단
			for (int i = 0; i < (1 << people.size()); i++) {
				// i번째 케이스에서
				int time = 0; // 걸린시간
				int[][] stair = new int[2][20];
				// j번째 사람이 어디로 갔을까
				for (int j = 0; j < people.size(); j++) {
					// j번째 사람이 1번계단으로 갔넹
					if (((1 << j) & i) == 0) {
						stair[0][Math.abs(stairs.get(0)[0] - people.get(j)[0])
								+ Math.abs(stairs.get(0)[1] - people.get(j)[1])]++;
					}
					// j번째 사람이 2번계단으로 갔넹
					else {
						stair[1][Math.abs(stairs.get(1)[0] - people.get(j)[0])
								+ Math.abs(stairs.get(1)[1] - people.get(j)[1])]++;
					}
				} // for_j
				int[] wait = new int[2];// 대기인원
				int[] onStair = new int[2]; // 계단위의 사람수
				int P = 0; // 탈출한 사람 수

				st[0] = new LinkedList<>();
				st[1] = new LinkedList<>();

				for (int s = 0; s < stairs.get(0)[2]; s++) {
					st[0].add(0);
				}
				for (int s = 0; s < stairs.get(1)[2]; s++) {
					st[1].add(0);
				}

				while (true) {
					time++; // 시간이 흐른당
					// 계단 두개 동시에 체크
					int[] outNow = new int[2];
					for (int s = 0; s < 2; s++) {
						// 일단 계단에 있는 사람들 한칸씩 내려보내기
						outNow[s] = st[s].poll();
						P += outNow[s]; // 나간사람 더해주기
						onStair[s] -= outNow[s];

						// 계단에 자리있으면 넣어주깅
						if (onStair[s] < 3) {
							int put;
							if (wait[s] > 3 - onStair[s]) {
								put = 3 - onStair[s];
								wait[s] -= put;
								onStair[s] += put;
								st[s].add(put);
							} else {
								put = wait[s];
								wait[s] = 0;
								onStair[s] += put;
								st[s].add(put);
							}
						} else {
							st[s].add(0); //대기하는 사람 없을때
						}
						// 해당 시간에 계단에 도착한 사람 대기열에 보내기
						if (time < 20)
							wait[s] += stair[s][time];
					}
					// 종료조건
					if (P == people.size()) {
						break;
					}
				}

				if (answer > time) {
					answer = time;
				}

			} // for_i

			// 출력
			System.out.println("#" + t + " " + answer);

		} // testCase
	}// main

}
