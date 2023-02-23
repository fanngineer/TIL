package SWEA;

import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class P3316_동아리실_관리하기 {
	static String str;
	static int N;
	static int cnt;
	static int[] memory;
	static int[] now;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			// 입력과 초기화
			str = br.readLine();
			N = str.length();
			memory = new int[1 << 4];
			now = new int[1 << 4];
			memory[1] = 1;
			cnt = 0;
			// 동작
			for (int day = 1; day <= N; day++) {
				int dutyTodayBi = 1 << (str.charAt(day - 1) - 'A'); // 0001, 0010, 0100, 1000
				for (int yesterday = 1; yesterday < (1 << 4); yesterday++) {
					int yes = memory[yesterday];
					if (yes == 0)
						continue;
					for (int i = 1; i < (1 << 4); i++) {
						// 16가지 경우의 수를 검사
						// 전날 참여한 사람 중 1명은 필수 참여
						// 당번은 무조건 참여
						if ((i & dutyTodayBi) > 0 && (i & yesterday) > 0) {
							// i번째는 가능한 경우
							int nw = now[i];
							nw += yes;
							if (nw > 1000000007)
								nw -= 1000000007;
							now[i] = nw;
						}
					} // for_15
				} // for_yesterday
					// 업데이트
				for (int j = 1; j < (1 << 4); j++) {
					memory[j] = now[j];
					now[j] = 0;
				}
			}
			for (int j = 1; j < (1 << 4); j++) {
				cnt += memory[j];
				if (cnt > 1000000007)
					cnt -= 1000000007;
			}
			// 출력
			sb.append("#").append(t).append(" ");
			sb.append(cnt);
			bw.write(sb.toString());
			bw.newLine();
			sb.setLength(0);
		}
		bw.close();
	}
}
