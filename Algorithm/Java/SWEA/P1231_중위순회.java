package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import java.util.StringTokenizer;

public class P1231_중위순회 {
	
	static StringBuilder sb;
	static int[][] biTree;
	static String[] datas;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		sb = new StringBuilder();
		for(int t=1; t<=10;t++) {
			int N = Integer.parseInt(br.readLine());
			biTree = new int[N+1][2];
			datas = new String[N+1];
			int idx;
			int leftRight;
			for(int n=1; n<=N;n++) {
				st = new StringTokenizer(br.readLine());
				idx = Integer.parseInt(st.nextToken());
				datas[idx] = st.nextToken();
				leftRight = 0;
				while(st.hasMoreTokens()) {
					biTree[idx][leftRight] = Integer.parseInt(st.nextToken());
					leftRight++;
				}
			}//for_N 입력
			//읽기
			sb.append("#").append(t).append(" ");
			inOrder(1);
			bw.write(sb.toString());
			bw.newLine();
			sb.setLength(0);
		}//for_testCase
		bw.close();
	}//main
	static void inOrder(int idx) {
		int left = biTree[idx][0];
		int right = biTree[idx][1];
		if(left != 0) {
			inOrder(left);
		}
		sb.append(datas[idx]);
		if(right !=0) {
			inOrder(right);
		}
	}
}
