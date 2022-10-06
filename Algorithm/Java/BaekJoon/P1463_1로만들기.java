package BJ;

import java.util.Scanner;

public class P1463_1로만들기 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //줄의 수;
		
		int[] memory = new int[N+1]; //i번째 줄의 j칸에 있을때 최대 점수
		
		memory[1] = 0;
		for(int i =2; i<N+1;i++) {
			memory[i] +=1 + memory[i-1];
			if(i%2==0)
				memory[i]=Math.min(memory[i], memory[i/2]+1);
			if(i%3==0)
				memory[i]=Math.min(memory[i], memory[i/3]+1);
		}
		
		System.out.println(memory[N]);
	}//main
}
