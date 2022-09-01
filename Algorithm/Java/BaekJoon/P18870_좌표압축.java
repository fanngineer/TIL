package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P18870_좌표압축 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] input = new int[N];
		int[] sorted = new int[N];
		int[] output = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			sorted[i] = input[i];
		}
		Arrays.sort(sorted);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < sorted.length; j++) {
				if(input[i]==sorted[j]) {
					output[i] = j;
					break;
				}
			}
		}
		for (int j = 0; j < sorted.length; j++) {
			bw.write(output[j]+" ");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
