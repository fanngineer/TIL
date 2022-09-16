package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class P1620_포켓몬다솜 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String NM = br.readLine();
		StringTokenizer st = new StringTokenizer(NM);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//포켓몬 도감 공부하기
		HashMap<String, String> monsters = new HashMap<>();
		HashMap<String, String> monsters2 = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			String monster = br.readLine();
			monsters.put(Integer.toString(i), monster);
			monsters2.put(monster, Integer.toString(i));
		}
		//문제맞추기
		Set<String> keyset = monsters.keySet();
		for (int i = 1; i <= M; i++) {
			String q = br.readLine();
			//숫자 key가 들어온 경우
			if(monsters.containsKey(q)) {
				System.out.println(monsters.get(q));
			}
			//이름이 들어온 경우
			else
				System.out.println(monsters2.get(q));
		}
	}
}
