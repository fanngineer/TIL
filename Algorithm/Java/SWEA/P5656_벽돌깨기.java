package SWEA;

import java.util.HashSet;
import java.util.Scanner;

public class P5656_벽돌깨기 {

	static int N;
	static int H;
	static int W;
	static int answer;
	static int[][] bricks;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			// 입력
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			// 열 생성
			bricks = new int[H][W];
			int origin = 0;// 처음 벽돌수
			for (int h = 0; h < H; h++) {
				for (int w = 0; w < W; w++) {
					int brick = sc.nextInt();
					bricks[h][w] = brick;
					if (brick > 0) {
						origin++;
					}
				}
			}

			// 구동
			max = 0;
			targets = new int[N];
			perm(0);
			answer = origin - max;
			// 출력
			System.out.println("#" + t + " " + answer);

		} // testCase
	}// main
		// w는 열의 번호 0~W-1

	static int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static void find(int h, int w) {
		// 해당 친구의 번호를 읽어서
		int range = bricks_test[h][w];
		if (range == 0) {
			return;
		}
		bricks_test[h][w] = 0;
		temp++;
		if (range == 1) {
			return;
		}
		// 1이 아니면 상하좌우 해당 범위를 toDel에 넣기
		for (int[] di : directions) {
			for (int r = 1; r < range; r++) {
				int new_h = h + r*di[0];
				int new_w = w + r*di[1];
				if (0 <= new_h && new_h < H && 0 <= new_w && new_w < W) {
					if (bricks_test[new_h][new_w] > 0) {
						// 범위에 함수 실행
						find(new_h, new_w);
					}
				}
			}
		} // for_range
	}// find

	static int max;
	static int temp;

	// 제거대상 찾아서 지우는 함수
	static void del(int w) {
		int h = 0;
		for (int i = 0; i < H; i++) {
			if (bricks_test[i][w] > 0) {
				h = i;
				break;
			}
		}
		find(h, w);// w열의 젤 윗부분 부터 시작해서 제거대상 찾기
		// toDel에 저장된 좌표들 읽으면서 하나씩 제거하고 열의 젤 위에 0추가
		for (int j = 0; j < W; j++) {
			int[] newRow = new int[H];
			int idx = H - 1;
			for (int i = H - 1; i >= 0; i--) {
				if (bricks_test[i][j] > 0) {
					newRow[idx--] = bricks_test[i][j];
				}
			}
			for (int i = 0; i < H; i++) {
				bricks_test[i][j] = newRow[i];
			}
		}
	}// del
		// 구슬 떨어뜨릴 위치를 N번 정하기

	static int[] targets;
	static int[][] bricks_test;

	static void perm(int idx) {
		if (idx == N) {
			temp = 0;// 부서진 벽돌 갯수 초기화
			// 부술 벽돌 초기화
			bricks_test = new int[H][W];
			for (int h = 0; h < H; h++) {
				System.arraycopy(bricks[h], 0, bricks_test[h], 0, W);
			}
			for (int n = 0; n < N; n++) {
				int w = targets[n];
				del(w);
			}
			if (temp > max)
				max = temp;
			return;
		}
		for (int w = 0; w < W; w++) {
			targets[idx] = w;
			perm(idx + 1);
		}
	}

	static int cnt = 0;
}
