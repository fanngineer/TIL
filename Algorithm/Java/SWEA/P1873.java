package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class P1873 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			char[][] map = new char[H][W];
			// 배열에 맵 할당
			for (int i = 0; i < H; i++) {
				String input = sc.next();
				char[] inputArr = input.toCharArray();
				for (int j = 0; j < W; j++) {
					map[i][j] = inputArr[j];
				}
			}
			// 전차 찾기
			int[] location = find(map);
			int N = sc.nextInt();
			String order = sc.next(); // 길이가 N인 문자열
			// 명령을 읽자
//Pass
			for (int i = 0; i < N; i++) {
				char read = order.charAt(i);
				// 명령 수행
				move(map, read, location);
			}
			//출력
			System.out.print("#"+test_case+" ");
			for(int i=0; i<H;i++) {
				System.out.println(String.valueOf((map[i])));
			}
		} // for_testCase
	}// main
		// 전차 찾기

	public static int[] find(char[][] map) {
		// 전차 찾기
		int H = map.length;
		int W = map[0].length;
		int[] location = new int[3]; // 전차 행,열,상하좌우1234
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				switch (map[i][j]) {
				case ('^'):
					location[0] = i;
					location[1] = j;
					location[2] = 1;
					break;
				case ('v'):
					location[0] = i;
					location[1] = j;
					location[2] = 2;
					break;
				case ('<'):
					location[0] = i;
					location[1] = j;
					location[2] = 3;
					break;
				case ('>'):
					location[0] = i;
					location[1] = j;
					location[2] = 4;
					break;
				}
			}
		}
		return location;
	}

//명령어 수행
	public static void move(char[][] map, char read, int[] location) {
		int H = map.length;
		int W = map[0].length;
		switch (read) {
		case ('U'):
			map[location[0]][location[1]] = '^';
			if (location[0] > 0 && map[location[0] - 1][location[1]] == '.') {
				map[location[0]][location[1]] = '.';
				location[0] -= 1;
				map[location[0]][location[1]] = '^';
			}
			location[2] = 1;
			break;
		case ('D'):
			map[location[0]][location[1]] = 'v';
			if (location[0] + 1 < H && map[location[0] + 1][location[1]] == '.') {
				map[location[0]][location[1]] = '.';
				location[0] += 1;
				map[location[0]][location[1]] = 'v';
			}
			location[2] = 2;
			break;
		case ('L'):
			map[location[0]][location[1]] = '<';
			if (location[1] > 0 && map[location[0]][location[1] - 1] == '.') {
				map[location[0]][location[1]] = '.';
				location[1] -= 1;
				map[location[0]][location[1]] = '<';
			}
			location[2] = 3;
			break;
		case ('R'):
			map[location[0]][location[1]] = '>';
			if (location[1] + 1 < W && map[location[0]][location[1] + 1] == '.') {
				map[location[0]][location[1]] = '.';
				location[1] += 1;
				map[location[0]][location[1]] = '>';
			}
			location[2] = 4;
			break;
		case ('S'):
			if (location[2] == 1) {
				int i = 1;
				while (location[0] - i >= 0 && map[location[0] - i][location[1]] != '#') {
					if (map[location[0] - i][location[1]] == '*') {
						map[location[0] - i][location[1]] = '.';
						i++;
						break;
					}
					i++;
				} // while
			} // if
			else if (location[2] == 2) {
				int i = 1;
				while (location[0] +i < H && map[location[0] + i][location[1]] != '#') {
					if (map[location[0] + i][location[1]] == '*') {
						map[location[0] + i][location[1]] = '.';
						break;
					}
					i++;
				} // while
			} // if
			else if (location[2] == 3) {
				int i = 1;
				while (location[1] - i >= 0 && map[location[0]][location[1]-i] != '#') {
					if (map[location[0]][location[1]-i] == '*') {
						map[location[0]][location[1]-i] = '.';
						break;
					}
					i++;
				} // while
			} // if
			else if (location[2] == 4) {
				int i = 1;
				while (location[1] + i <W  && map[location[0]][location[1]+i] != '#') {
					if (map[location[0]][location[1]+i] == '*') {
						map[location[0]][location[1]+i] = '.';
						break;
					}
					i++;
				} // while
			} // if
		}
		return;
	}//move
}//class
