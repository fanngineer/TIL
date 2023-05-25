
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] dp = new int[N+1];
		dp[1] = 0;
		Stack<Integer> memo = new Stack<>();
		memo.add(1);
		int before;
		int min;
		for(int i = 2; i<=N; i++) {
			min = dp[i-1];
			before = i-1;
			if(i%3==0) {
				if(min>dp[i/3]) {
					min = dp[i/3];
					before = i/3;
				}
			}
			if(i%2==0) {
				if(min>dp[i/2]) {
					min = dp[i/2];
					before = i/2;
				}
			}
			dp[i] = min+1;
		}
		while(N!=1) {
			sb.append(N).append(" ");
			min = dp[N-1];
			before = N-1;
			if(N%3==0) {
				if(min>dp[N/3]) {
					min = dp[N/3];
					before = N/3;
				}
			}
			if(N%2==0) {
				if(min>dp[N/2]) {
					min = dp[N/2];
					before = N/2;
				}
			}
			N = before;
		}
		sb.append(1);
		System.out.println(dp[dp.length-1]);
		System.out.println(sb.toString());
	}
}
