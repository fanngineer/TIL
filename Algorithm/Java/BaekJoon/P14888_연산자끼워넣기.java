package BJ;

import java.io.IOException;
import java.util.Scanner;

public class P14888_연산자끼워넣기 {
	static int N;
	static int R;
	static int[] nums;
	static int[] opers = new int[4]; // + - * /
	
	static int max;
	static int min;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		nums = new int[N];
		
		for(int i = 0; i<N; i++) {
			nums[i] = sc.nextInt();
		}

		for(int i = 0; i<4; i++) {
			opers[i] = sc.nextInt();
		}
		
		max = -1000000000;
		min = 1000000000;
		result = nums[0];
		
		insert(1,result);

		System.out.println(max);
		System.out.println(min);
	}
	//n= 1 부터 N-1까지 삽입하는 함수
	static int result;
	public static void insert(int n,int result){
		if(n>=N) {
			if(result>max)
				max = result;
			if(result<min)
				min = result;
			return;
		}
		else {
			//연산자 중에 하나 고르기
			for(int i=0; i<4;i++) {
				//연산자가 존재하면
				if(opers[i]>0) {
					//고르는 경우
					int new_result = cal(i,result,nums[n]);
					opers[i]--;
					insert(n+1, new_result);
					//안고르는 경우
					opers[i]++;
				}
			}
		}
		
	}
	static int cal(int oper, int n, int m) {
		if(oper == 0)
			return n+m;
		else if(oper == 1)
			return n-m;
		else if(oper == 2)
			return n*m;
		else
			return n/m;
	}
}
