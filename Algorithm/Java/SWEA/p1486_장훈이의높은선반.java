package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1486_장훈이의높은선반 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line);
			int N = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			String line2 = br.readLine();
			StringTokenizer st2 = new StringTokenizer(line2);
			int[] members = new int[N];
			int answer=0;
			for (int i = 0; i < N; i++) {
				members[i] = Integer.parseInt(st2.nextToken());
				answer += members[i];
			}
			//bitMasking으로 점원들의 키 조합 구하기
			for(int i =0; i<(1<<N); i++) {
				int sum=0;
				for(int j =0; j<N; j++) {
					if(((1<<j)&i)>0) {
						sum +=members[j];
					}
				}
				if((sum>=B)&&(sum<answer))
					answer = sum;
			}
			answer -=B;
			//출력
			System.out.println("#"+t+" "+answer);
		} // testCase
	}// main

}
