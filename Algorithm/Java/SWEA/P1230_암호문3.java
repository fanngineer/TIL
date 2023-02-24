package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import java.util.LinkedList;
import java.util.StringTokenizer;

public class P1230_암호문3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCase = 10;
		for(int t=1; t<=testCase; t++) {
			//암호문의 길이
			int N = Integer.parseInt(br.readLine());
			LinkedList<Integer> list = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}//원본 배열 입력
			int commandNum = Integer.parseInt(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int i=0; i<commandNum; i++) {
				String command = st2.nextToken();
				switch(command) {
				case "I" :
					int x = Integer.parseInt(st2.nextToken());
					int y = Integer.parseInt(st2.nextToken());
					for(int j=0; j<y; j++) {
						list.add(x++, Integer.parseInt(st2.nextToken()));
					}
					break;
				case "D" :
					int x_D = Integer.parseInt(st2.nextToken());
					int y_D = Integer.parseInt(st2.nextToken());
					for(int j=0; j<y_D; j++) {
						list.remove(x_D);
					}
					break;
				case "A" :
					int y_A = Integer.parseInt(st2.nextToken());
					for(int j=0; j<y_A; j++) {
						list.add(Integer.parseInt(st2.nextToken()));
					}
					break;
				}//switch
			}//명령문 읽기
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			for(int i = 0; i<10;i++) {
				sb.append(list.get(i)).append(" ");
			}
			bw.write(sb.toString());
			bw.newLine();
		}//for_testCase
		bw.close();
	}
}
