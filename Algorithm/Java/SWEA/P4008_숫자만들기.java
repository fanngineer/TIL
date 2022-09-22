package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P4008_숫자만들기 {
	static int max;
	static int min;
	static int answer;
	static int N;
	static int[] nums;
	static int[] opers = new int[4];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트 케이스 입력
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			N = Integer.parseInt(br.readLine());
			
			//연산자 입력
			String line_op = br.readLine();
			StringTokenizer st_op = new StringTokenizer(line_op);
			for (int i = 0; i < 4; i++) {
				opers[i] = Integer.parseInt(st_op.nextToken());
			}
			
			//숫자 셋 입력
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line);
			nums = new int[N];
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			//값 초기화
			max = -1000000000;
			min = 1000000000;
			answer = 0;
			int result = nums[0]; //연산결과
			
			//함수 실행
			put(1,result);
			
			// 출력
			answer = max-min;
			System.out.println("#" + t + " " + answer);
		} // testCase
		
	}// main

	//n번째 연산자를 넣는 함수
	static void put(int n, int result) {
		if(n>=N) {
			if(result<min)
				min = result;
			if(result>max)
				max = result;
			return;
		}else {
			for(int i=0; i<4; i++) {
				//해당 연산자가 있을때
				if(opers[i]>0) {
					//연산자를 넣는경우
					opers[i]--;
					int new_result = cal(i,result,nums[n]);
					put(n+1,new_result);
					//연산자를 안넣는경우 >> 다시 원상복구
					opers[i]++;
				}
			}
		}
	}
	
	
	
	//숫자에 따라 연산자 계산하는 함수
	 static int cal(int oper, int n, int m) {
		 if(oper==0)
			 return n+m;
		 else if(oper==1)
			 return n-m;
		 else if(oper==2)
			 return n*m;
		 else
			 return n/m;
	 }
}
