package SWEA;

import java.util.Scanner;
import java.io.FileInputStream;

public class P1209 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;
		int[] arr_views = new int[T];
		int views;
		for (int test_case = 1; test_case <= T; test_case++) {
//Length of Test_case
			int L = sc.nextInt();
//Array of buildings
			int[] buildings = new int[L];
//assign inputs in buildings
			for (int i = 0; i < L; i++) {
				buildings[i] = sc.nextInt();
			}
			views = 0;
			for (int i = 2; i < L - 2; i++) {
				int view = buildings[i];
				int near[] = { -2, -1, 1, 2 };
				for (int j : near) {
					if (view > buildings[i] - buildings[i + j]) {
						view = buildings[i] - buildings[i + j]; // assign minimum
					}
				}
				if (view > 0) {
					views += view;
				}
			}
			arr_views[test_case - 1] = views;
		}
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.println("#" + test_case + " " + arr_views[test_case - 1]);
		}
	}
}