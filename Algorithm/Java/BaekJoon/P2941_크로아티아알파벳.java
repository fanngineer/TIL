package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2941_크로아티아알파벳 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] croa = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
		int cnt = 0;
		// 문자열의 알파벳 하나하나 탐색
		for (int i = 0; i < line.length(); i++) {
			// 크로아티아 알파벳 하나씩 같은지 확인
			int flag = 1;
			for (String c : croa) {
				if (i+c.length()-1<line.length()&&line.substring(i, i + c.length()).equals(c)) {
					flag = c.length();// 알파벳 포함
					break;
				}
			}
			cnt++;
			i += flag - 1;
		}

		System.out.println(cnt);
		br.close();
	}// main
}
