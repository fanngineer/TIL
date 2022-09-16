package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P10815_숫자카드 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		int M = Integer.parseInt(br.readLine());
		String input2 = br.readLine();
		StringTokenizer st2 = new StringTokenizer(input2);
		for (int i = 0; i < M; i++) {
			if (set.contains(Integer.parseInt(st2.nextToken()))) {
				System.out.print("1 ");
			} else
				System.out.print("0 ");
		}
	}
}
