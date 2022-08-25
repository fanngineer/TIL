package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11720 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input =br.readLine();
		int N = Integer.parseInt(input);
		String nums =br.readLine();
		int result = 0;
		for(int i=0;i<N;i++) {
			int num = nums.charAt(i)-'0';
			result += num;
		}
			
		System.out.println(result);
	}
}
