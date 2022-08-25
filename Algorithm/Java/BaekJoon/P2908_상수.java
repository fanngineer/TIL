package Baekjoon;

import java.io.IOException;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class P2908_상수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nums = br.readLine();
		StringTokenizer st = new StringTokenizer(nums);
		String num1 = st.nextToken();
		String num2 = st.nextToken();
		String num1_ss = "";
		String num2_ss = "";
		for (int i = 2; i >= 0; i--) {
			num1_ss += Character.toString(num1.charAt(i));
			num2_ss += Character.toString(num2.charAt(i));
		}
		if (Integer.parseInt(num1_ss) > Integer.parseInt(num2_ss))
			System.out.println(num1_ss);
		else
			System.out.println(num2_ss);
		br.close();
	}// main
}
