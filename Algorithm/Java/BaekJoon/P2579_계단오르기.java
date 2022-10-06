package BJ;

import java.util.Scanner;

public class P2579_계단오르기 {
	static int N; // 계단의수
	static int[] stairs;// 계단
	static int[] memory; //i번째 계단을 밟는 경우 중 최대값을 저장
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//입력
		N = sc.nextInt(); // 계단의 수 입력받기 <=300
		stairs = new int[301];
		memory = new int[301];
		//계단 N개 입력받기
		for (int i = 1; i <= N; i++) {
			stairs[i] = sc.nextInt(); // 10,000이하
		}
		
		
		//구동
		
		memory[0] = 0; //시작점
		memory[1] = stairs[1]; // 1번 계단은 밟는 경우가 하나
		memory[2] = stairs[1]+stairs[2]; //2번 계단 최대는 1번밟고 2번
		for(int i=3; i<=N; i++) {
			memory[i] = Math.max(memory[i-3]+stairs[i-1], memory[i-2])+stairs[i];
		}
		//출력
		System.out.println(memory[N]);
	}//main
}
