package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P14425_문자열집합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String NM = br.readLine();
		StringTokenizer st = new StringTokenizer(NM);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		int result = 0; //결과저장
		for (int i = 0; i < M; i++) {
			if(set.contains(br.readLine()))
				result++;
		}
		System.out.println(result);
	}
}
