package BaekJoon;

import java.util.Scanner;

public class P2108_통계학 {
	static int N;
	static int m; //평균
	static int mid; //중앙값
	static int most; //최빈값
	static int range; //최댓값과 최솟값 차이
	static int[] count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		count = new int[8001];
		for(int i =0; i<N; i++) {
			count[sc.nextInt()+4000] += 1;
		}//수 입력
		
		int cnt=0;
		int fre = 0; //최대빈도
		int sum = 0;
		for(int i =0; i<8001; i++) {
			//평균 구하기
			sum += count[i]*(i-4000);
			//최대 빈도 수 찾기
			if(fre<count[i])
				fre = count[i];
		}
		double temp = (double)sum/N;
		m = (int)Math.round(temp);
		for(int i =0; i<8001; i++) {
			//중앙값 구하기
			cnt += count[i];
			if(cnt > N/2) {
				mid = i-4000;
				break;
			}
		}
		
		int flag = 0; //두번째로 작은 최빈값 찾기
		for(int i =0; i<8001; i++) {
			if(count[i]==fre) {
				most = i-4000;
				flag++;
			}
			//두번째면 멈춰
			if(flag == 2) {
				break;
			}
		}
		//범위찾기
		int min = 8000; //최소값
		int max = 0; //최대값
		for(int i =0; i<8001; i++) {
			if(count[i]!=0) {
				min = i-4000;
				break;
			}
		}
		for(int i= 8000; i>=0;i--) {
			if(count[i]!=0) {
				max = i-4000;
				break;
			}
		}
		range = max- min;
		System.out.println(m);
		System.out.println(mid);
		System.out.println(most);
		System.out.println(range);
	}
}
