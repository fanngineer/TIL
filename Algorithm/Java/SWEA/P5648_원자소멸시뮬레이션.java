package SWEA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class P5648_원자소멸시뮬레이션 {
	static int sum_energy;// 정답 - 에너지 총합
	static int N; // 원자의 수
	static int[][] di = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } }; // 상하좌우
	static int[][] atoms;
	static int[] mins; // 최솟값 저장

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			N = sc.nextInt();

			atoms = new int[N][4]; // x, y, 방향, 에너지

			for (int i = 0; i < N; i++) {

				atoms[i][0] = sc.nextInt(); // x좌표
				atoms[i][1] = sc.nextInt(); // y좌표
				atoms[i][2] = sc.nextInt(); // 방향
				atoms[i][3] = sc.nextInt(); // 에너지
			}

			int[] visited = new int[N];
			ArrayList<int[]>[] timeline = new ArrayList[4002];
			for(int i =0; i<4002; i++) {
				timeline[i] = new ArrayList<>();
			}
			
			// 1번째 원자
			for (int i = 0; i < N - 1; i++) {
				// 2번째 원자
				for (int j = i + 1; j < N; j++) {
					int time = find(atoms[i], atoms[j]);
					timeline[time].add(new int[] {i,j});
				}
			}

			sum_energy = 0;
			for (int i = 1; i < 4001; i++) {
				HashSet<Integer> set =  new HashSet<>();
				for(int j = 0; j<timeline[i].size(); j++) {
					int atom1 = timeline[i].get(j)[0];
					int atom2 = timeline[i].get(j)[1];
					if(visited[atom1]==0 && visited[atom2]==0) {
						set.add(atom1);
						set.add(atom2);
					}
				}
				for(int el : set) {
					sum_energy += atoms[el][3];
					visited[el] = 1;
				}
			}

			// 출력
			System.out.println("#" + test_case + " " + sum_energy);

		} // test_case
	}// main


	static int find(int[] atom1, int[] atom2) {
		int time = 4001;
		int[] atom12 = { atom2[0] - atom1[0], atom2[1] - atom1[1] }; // atom1 > atom2 벡터
		int[] atom21 = { atom1[0] - atom2[0], atom1[1] - atom2[1] }; // atom2 > atom1 벡터

		// x좌표나 y좌표가 같은 경우
		if (atom1[0] - atom2[0] == 0 || atom1[1] - atom2[1] == 0) {
			if (atom12[0] * di[atom1[2]][0] + atom12[1] * di[atom1[2]][1] > 0)
				if (atom21[0] * di[atom2[2]][0] + atom21[1] * di[atom2[2]][1] > 0)
					time = Math.abs(atom1[0] - atom2[0] + atom1[1] - atom2[1]);
		}
		// 대각선에 위치한 경우
		else {
			// 먼저 대각선에 위치해있고,
			if (Math.abs(atom1[0] - atom2[0]) == Math.abs(atom1[1] - atom2[1]))
				// 둘이 방향 벡터가 수직이고
				if (di[atom1[2]][0] * di[atom2[2]][0] + di[atom1[2]][1] * di[atom2[2]][1] == 0)
					if (atom12[0] * di[atom1[2]][0] + atom12[1] * di[atom1[2]][1] > 0)
						if (atom21[0] * di[atom2[2]][0] + atom21[1] * di[atom2[2]][1] > 0)
							time = Math.abs(atom1[0] - atom2[0])*2;
		}

		return time;
	}
}
