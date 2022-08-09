package first;

import java.util.Scanner;

public class BJ_P1244 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] sw = new int[n];// 스위치 배열
		// 스위치 인풋 입력
		for (int i = 0; i < n; i++) {
			sw[i] = sc.nextInt();
		}
		int ns = sc.nextInt(); // 학생수입력
		for (int i = 0; i < ns; i++) {
			// 남학생 or 여학생 값 입력 (1 or 2)
			int gen = sc.nextInt();
			int number = sc.nextInt(); // 입력 위치
			// 남학생인 경우
			if (gen == 1) {
				int j = 1;
				while (number * j <= n) {
					if (sw[number * j - 1] == 0) {
						sw[number * j - 1] = 1;
					} else {
						sw[number * j - 1] = 0;
					}
					j++;
				}
			}
			// 여학생인 경우
			else {
				sw[number- 1] = Math.abs(sw[number- 1] - 1);
				int k = 1;
				while ((number - k) > 0 && (number + k) <= n) {
					if (sw[number - k - 1] == sw[number + k - 1]) {
						sw[number - k - 1] = Math.abs(sw[number - k - 1] - 1);
						sw[number + k - 1] = Math.abs(sw[number + k - 1] - 1);
						k++;
					}
					else {
						break;
					}
				}
			}
		}
		for(int i = 0; i < n; i++) {
			System.out.print(sw[i]+" ");
			if((i+1)%20==0) {
				System.out.println();
			}
		}
	}
}
