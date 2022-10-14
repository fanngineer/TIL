package SWEA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class P5648_���ڼҸ�ùķ��̼� {
	static int sum_energy;// ���� - ������ ����
	static int N; // ������ ��
	static int[][] di = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } }; // �����¿�
	static int[][] atoms;
	static int[] mins; // �ּڰ� ����

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			// �Է�
			N = sc.nextInt();

			atoms = new int[N][4]; // x, y, ����, ������

			for (int i = 0; i < N; i++) {

				atoms[i][0] = sc.nextInt(); // x��ǥ
				atoms[i][1] = sc.nextInt(); // y��ǥ
				atoms[i][2] = sc.nextInt(); // ����
				atoms[i][3] = sc.nextInt(); // ������
			}

			int[] visited = new int[N];
			ArrayList<int[]>[] timeline = new ArrayList[4002];
			for(int i =0; i<4002; i++) {
				timeline[i] = new ArrayList<>();
			}
			
			// 1��° ����
			for (int i = 0; i < N - 1; i++) {
				// 2��° ����
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

			// ���
			System.out.println("#" + test_case + " " + sum_energy);

		} // test_case
	}// main


	static int find(int[] atom1, int[] atom2) {
		int time = 4001;
		int[] atom12 = { atom2[0] - atom1[0], atom2[1] - atom1[1] }; // atom1 > atom2 ����
		int[] atom21 = { atom1[0] - atom2[0], atom1[1] - atom2[1] }; // atom2 > atom1 ����

		// x��ǥ�� y��ǥ�� ���� ���
		if (atom1[0] - atom2[0] == 0 || atom1[1] - atom2[1] == 0) {
			if (atom12[0] * di[atom1[2]][0] + atom12[1] * di[atom1[2]][1] > 0)
				if (atom21[0] * di[atom2[2]][0] + atom21[1] * di[atom2[2]][1] > 0)
					time = Math.abs(atom1[0] - atom2[0] + atom1[1] - atom2[1]);
		}
		// �밢���� ��ġ�� ���
		else {
			// ���� �밢���� ��ġ���ְ�,
			if (Math.abs(atom1[0] - atom2[0]) == Math.abs(atom1[1] - atom2[1]))
				// ���� ���� ���Ͱ� �����̰�
				if (di[atom1[2]][0] * di[atom2[2]][0] + di[atom1[2]][1] * di[atom2[2]][1] == 0)
					if (atom12[0] * di[atom1[2]][0] + atom12[1] * di[atom1[2]][1] > 0)
						if (atom21[0] * di[atom2[2]][0] + atom21[1] * di[atom2[2]][1] > 0)
							time = Math.abs(atom1[0] - atom2[0])*2;
		}

		return time;
	}
}
