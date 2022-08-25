package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1289_원재의메모리복구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String origin = br.readLine();//주어진 원래 상태
			int cnt = 0; //고칠 횟수
			//원래 메모리의 첨부터 읽어서 고치기
			char now = '0';
			for(int i=0;i<origin.length();i++) {
				if(origin.charAt(i)!=now) {
					cnt++;
					now = origin.charAt(i);
				}
			}
			System.out.println("#"+t+" "+cnt);
		} // testCase
	}// main
}
