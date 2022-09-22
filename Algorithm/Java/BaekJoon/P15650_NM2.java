package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15650_NM2 {
	static int[] nums;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[M+1];
		comb(1,1);
	}
	
	//n번째 숫자를 뽑는 경우, 1부터 시작
	static void comb(int n, int start) {
		if(n>M) {
			StringBuilder sb = new StringBuilder();
			for(int i = 1; i<=M;i++) {
				sb.append(nums[i]+" ");
			}
			System.out.println(sb.toString());
			return;
		}
		for(int i = start; i<=N; i++) {
			//i번째 숫자를 뽑는다
			nums[n] = i;
			//그다음은 n+1번째 뽑을건데
			comb(n+1,i+1);
			
		}
	}
}
