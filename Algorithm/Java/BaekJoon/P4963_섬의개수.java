package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class P4963_섬의개수 {
	static int w;
	static int h;
	static int[][] map;
	static int island;
	static LinkedList<int[]> lands;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			// 입력
			w = sc.nextInt();
			h = sc.nextInt();
			if (w == 0 && h == 0)
				break;
			map = new int[h + 2][w + 2];
			lands = new LinkedList<>();
			for (int i = 1; i <= h; i++) {
				for (int j = 1; j <= w; j++) {
					map[i][j] = sc.nextInt();
				}
			} // for_map

			// 구동
			island = 0;
			for (int i = 1; i <= h; i++) {
				for (int j = 1; j <= w; j++) {
					if (map[i][j] == 1) {
						island++;
						cnt(i, j);
					}
				}
			} // for_map
				// 출력
			System.out.println(island);
		}
	}// main

	static void cnt(int x, int y) {
		map[x][y] = 0;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				x += i;
				y += j;
				if (map[x][y] == 1) {
					cnt(x, y);
				}
				x -= i;
				y -= j;
			}
		} // 8방향
	}
}
