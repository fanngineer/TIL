package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class P1288_새로운_불면증_치료법 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			//입력
			int N = Integer.parseInt(br.readLine());
			int std = (1<<10)-1;
			int check = 0;
			//동작
			int cnt = 0;
			while(true) {
				cnt++;
				int now = N*cnt;
				while(now>0) {
					check = check|(1<<(now%10));
					now /= 10;
				}
				if(check==std) break;
				
			}
			//출력
			System.out.println("#"+t+" "+N*cnt);
		}
	}
}
