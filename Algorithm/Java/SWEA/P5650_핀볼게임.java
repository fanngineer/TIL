package SWEA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P5650_핀볼게임 {

	static int N; // 게임판 크기
	static int[][] map; // 게임판
	static int MAX; // 정답 - 최대값
	static int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };// 상하좌우
	static ArrayList<int[]>[] warmHoles;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			N = sc.nextInt();
			map = new int[N][N];
			warmHoles = new ArrayList[5];
			for (int i = 0; i < 5; i++) {
				warmHoles[i] = new ArrayList<int[]>();
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int now = sc.nextInt();
					map[i][j] = now;
					// 웜홀 위치 저장
					if (now >= 6) {
						warmHoles[now - 6].add(new int[] { i, j });
					}
				}
			}

			// 구동
			MAX = 0; // 초기화
			// 모든 좌표를 순회
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0) {
						for (int[] di : directions) {
							int ans = 0;
							ans = move(i, j, di);
							if (ans > MAX)
								MAX = ans;
						}
					}
				}
			} // 순회 끝

			// 출력
			System.out.println("#" + test_case + " " + MAX);

		} // test_case
	}// main
		// x, y, 방향 전달받아서 점수 반환하는 함수

	static int now_i;
	static int now_j;
	
	static int move(int i, int j, int[] di) {
		int point = 0;
		
		now_i = i; // 지금 위치
		now_j = j;
		int[] now_di = new int[2];
		now_di[0] = di[0];
		now_di[1] = di[1];
		//원래 자리이거나 블랙홀 만나는 경우까지 반복
		while(true) {
			//다음칸을 보자
			now_i = now_i+now_di[0];
			now_j = now_j+now_di[1];
			//다음칸이 범위 밖이면
			if(now_i<0||now_i>=N||now_j<0||now_j>=N){
				now_di = meet(5,now_di);
				point++;
				continue;
			}
			int next = map[now_i][now_j];
			//옮겼는데 원래 위치이거나, 블랙홀이면 끝
			if(now_i==i&&now_j==j) {
				break;
			}
			//아무것도 없으면 그냥 옮기기
			if(next==0) {
				continue;
			}
			//블랙홀을 만났을때
			else if(next == -1) {
				break;
			}
			//블록을 만나면
			else if(next<=5) {
				now_di = meet(next, now_di);
				point++;
			}
			//웜홀 만날때
			else {
				for(int w =0; w<2; w++) {
					if(now_i != warmHoles[next-6].get(w)[0] || now_j != warmHoles[next-6].get(w)[1]) {
						now_i = warmHoles[next-6].get(w)[0];
						now_j = warmHoles[next-6].get(w)[1];
						break;
					}
				}
			}
		}
		return point;
	}// move

	//블록을 만나면 방향을 바꿔주는 함수
	static int[] meet(int block, int[] di) {
		int[] new_di = new int[2];

		// 블록 1번을 만날때
		if (block == 1) {
			// 위로 갈때
			if (di[0] == -1 & di[1] == 0) {
				new_di[0] = 1;
				new_di[1] = 0;
			}
			// 아래로 갈때
			else if (di[0] == 1 & di[1] == 0) {
				new_di[0] = 0;
				new_di[1] = 1;
			}
			// 왼쪽으로 갈때
			else if (di[0] == 0 & di[1] == -1) {
				new_di[0] = -1;
				new_di[1] = 0;
			}
			// 오른쪽으로 갈때
			else if (di[0] == 0 & di[1] == 1) {
				new_di[0] = 0;
				new_di[1] = -1;
			}
		}
		// 블록 2번을 만날때
		if (block == 2) {
			// 위로 갈때
			if (di[0] == -1 & di[1] == 0) {
				new_di[0] = 0;
				new_di[1] = 1;
			}
			// 아래로 갈때
			else if (di[0] == 1 & di[1] == 0) {
				new_di[0] = -1;
				new_di[1] = 0;
			}
			// 왼쪽으로 갈때
			else if (di[0] == 0 & di[1] == -1) {
				new_di[0] = 1;
				new_di[1] = 0;
			}
			// 오른쪽으로 갈때
			else if (di[0] == 0 & di[1] == 1) {
				new_di[0] = 0;
				new_di[1] = -1;
			}
		}
		// 블록 3번을 만날때
		if (block == 3) {
			// 위로 갈때
			if (di[0] == -1 & di[1] == 0) {
				new_di[0] = 0;
				new_di[1] = -1;
			}
			// 아래로 갈때
			else if (di[0] == 1 & di[1] == 0) {
				new_di[0] = -1;
				new_di[1] = 0;
			}
			// 왼쪽으로 갈때
			else if (di[0] == 0 & di[1] == -1) {
				new_di[0] = 0;
				new_di[1] = 1;
			}
			// 오른쪽으로 갈때
			else if (di[0] == 0 & di[1] == 1) {
				new_di[0] = 1;
				new_di[1] = 0;
			}
		}
		// 블록 4번을 만날때
		if (block == 4) {
			// 위로 갈때
			if (di[0] == -1 & di[1] == 0) {
				new_di[0] = 1;
				new_di[1] = 0;
			}
			// 아래로 갈때
			else if (di[0] == 1 & di[1] == 0) {
				new_di[0] = 0;
				new_di[1] = -1;
			}
			// 왼쪽으로 갈때
			else if (di[0] == 0 & di[1] == -1) {
				new_di[0] = 0;
				new_di[1] = 1;
			}
			// 오른쪽으로 갈때
			else if (di[0] == 0 & di[1] == 1) {
				new_di[0] = -1;
				new_di[1] = 0;
			}
		}
		// 블록 5번을 만날때
		if (block == 5) {
			new_di[0] = -di[0];
			new_di[1] = -di[1];
		}

		return new_di;
	}
}// class
