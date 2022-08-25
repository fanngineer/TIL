package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2675_문자열반복 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int R = Integer.parseInt(st.nextToken());//반복횟수
			String str = st.nextToken();
			String newStr = "";
			for(int i=0;i<str.length();i++) {
				for(int r=0;r<R;r++) {
					char al = str.charAt(i);
					newStr += Character.toString(al);
				}
			}
			System.out.println(newStr);
		}
	}
}
