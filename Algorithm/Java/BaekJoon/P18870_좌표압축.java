package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class P18870_좌표압축 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> hm = new HashMap<>();
		int[] origin = new int[N];
		int[] sorted = new int[N];
		
		for (int i = 0; i < N; i++) {
			origin[i] = sorted[i] = Integer.parseInt(st.nextToken());
		}
		//하나씩 뽑으면 최솟값이 나오겠징..?
		//나보다 작은건없엉
		Arrays.sort(sorted);
		int i = 0;
		for (int min : sorted) {
			if(!hm.containsKey(min)) {
				hm.put(min,i);
				i++;
			}
			
		}
		//출력
		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < N; k++) {
			sb.append(hm.get(origin[k])).append(' ');
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
