package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15652_N과M {
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		function(0,"",1);
	}
	static void function(int idx,String temp,int end) {
		//기저 조건
		if(idx==M) {
			temp = temp.substring(0, temp.length()-1);
			System.out.println(temp);
			return;
		}
		//종료 부분
		for(int i = end; i<=N; i++) {
			function(idx+1,temp+Integer.toString(i)+" ", i);
		}
	}
}
