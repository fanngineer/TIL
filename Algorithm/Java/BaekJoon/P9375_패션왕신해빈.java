package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P9375_패션왕신해빈 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			HashMap<String, Integer> items = new HashMap<>();
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				StringTokenizer st = new StringTokenizer(line);
				String item = st.nextToken();
				String type = st.nextToken();
				if(items.containsKey(type)) {
					items.put(type, items.get(type)+1);
				}else
					items.put(type, 1);
			}
			int cnt = 1;
			
			for(String key : items.keySet()) {
				cnt *= (items.get(key)+1);
			}
			cnt -= 1;
			System.out.println(cnt);
		} // testcase

	}
}
