package SWEA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P5650_�ɺ����� {

	static int N; // ������ ũ��
	static int[][] map; // ������
	static int MAX; // ���� - �ִ밪
	static int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };// �����¿�
	static ArrayList<int[]>[] warmHoles;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			// �Է�
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
					// ��Ȧ ��ġ ����
					if (now >= 6) {
						warmHoles[now - 6].add(new int[] { i, j });
					}
				}
			}

			// ����
			MAX = 0; // �ʱ�ȭ
			// ��� ��ǥ�� ��ȸ
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
			} // ��ȸ ��

			// ���
			System.out.println("#" + test_case + " " + MAX);

		} // test_case
	}// main
		// x, y, ���� ���޹޾Ƽ� ���� ��ȯ�ϴ� �Լ�

	static int now_i;
	static int now_j;
	
	static int move(int i, int j, int[] di) {
		int point = 0;
		
		now_i = i; // ���� ��ġ
		now_j = j;
		int[] now_di = new int[2];
		now_di[0] = di[0];
		now_di[1] = di[1];
		//���� �ڸ��̰ų� ��Ȧ ������ ������ �ݺ�
		while(true) {
			//����ĭ�� ����
			now_i = now_i+now_di[0];
			now_j = now_j+now_di[1];
			//����ĭ�� ���� ���̸�
			if(now_i<0||now_i>=N||now_j<0||now_j>=N){
				now_di = meet(5,now_di);
				point++;
				continue;
			}
			int next = map[now_i][now_j];
			//�Ű�µ� ���� ��ġ�̰ų�, ��Ȧ�̸� ��
			if(now_i==i&&now_j==j) {
				break;
			}
			//�ƹ��͵� ������ �׳� �ű��
			if(next==0) {
				continue;
			}
			//��Ȧ�� ��������
			else if(next == -1) {
				break;
			}
			//����� ������
			else if(next<=5) {
				now_di = meet(next, now_di);
				point++;
			}
			//��Ȧ ������
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

	//����� ������ ������ �ٲ��ִ� �Լ�
	static int[] meet(int block, int[] di) {
		int[] new_di = new int[2];

		// ��� 1���� ������
		if (block == 1) {
			// ���� ����
			if (di[0] == -1 & di[1] == 0) {
				new_di[0] = 1;
				new_di[1] = 0;
			}
			// �Ʒ��� ����
			else if (di[0] == 1 & di[1] == 0) {
				new_di[0] = 0;
				new_di[1] = 1;
			}
			// �������� ����
			else if (di[0] == 0 & di[1] == -1) {
				new_di[0] = -1;
				new_di[1] = 0;
			}
			// ���������� ����
			else if (di[0] == 0 & di[1] == 1) {
				new_di[0] = 0;
				new_di[1] = -1;
			}
		}
		// ��� 2���� ������
		if (block == 2) {
			// ���� ����
			if (di[0] == -1 & di[1] == 0) {
				new_di[0] = 0;
				new_di[1] = 1;
			}
			// �Ʒ��� ����
			else if (di[0] == 1 & di[1] == 0) {
				new_di[0] = -1;
				new_di[1] = 0;
			}
			// �������� ����
			else if (di[0] == 0 & di[1] == -1) {
				new_di[0] = 1;
				new_di[1] = 0;
			}
			// ���������� ����
			else if (di[0] == 0 & di[1] == 1) {
				new_di[0] = 0;
				new_di[1] = -1;
			}
		}
		// ��� 3���� ������
		if (block == 3) {
			// ���� ����
			if (di[0] == -1 & di[1] == 0) {
				new_di[0] = 0;
				new_di[1] = -1;
			}
			// �Ʒ��� ����
			else if (di[0] == 1 & di[1] == 0) {
				new_di[0] = -1;
				new_di[1] = 0;
			}
			// �������� ����
			else if (di[0] == 0 & di[1] == -1) {
				new_di[0] = 0;
				new_di[1] = 1;
			}
			// ���������� ����
			else if (di[0] == 0 & di[1] == 1) {
				new_di[0] = 1;
				new_di[1] = 0;
			}
		}
		// ��� 4���� ������
		if (block == 4) {
			// ���� ����
			if (di[0] == -1 & di[1] == 0) {
				new_di[0] = 1;
				new_di[1] = 0;
			}
			// �Ʒ��� ����
			else if (di[0] == 1 & di[1] == 0) {
				new_di[0] = 0;
				new_di[1] = -1;
			}
			// �������� ����
			else if (di[0] == 0 & di[1] == -1) {
				new_di[0] = 0;
				new_di[1] = 1;
			}
			// ���������� ����
			else if (di[0] == 0 & di[1] == 1) {
				new_di[0] = -1;
				new_di[1] = 0;
			}
		}
		// ��� 5���� ������
		if (block == 5) {
			new_di[0] = -di[0];
			new_di[1] = -di[1];
		}

		return new_di;
	}
}// class
