package Baekjoon;

//단어공부
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1157 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String upper = input.toUpperCase();// 대문자로 바꾸기
		int[] counting = new int[26];
		// 카운팅하기
		for (int i = 0; i < upper.length(); i++) {
			counting[upper.charAt(i) - 'A']++;
		}
		int max = 0;
		int idxOfMax = -1;
		// 가장 큰 놈의 횟수
		for (int i = 0; i < counting.length; i++) {
			if (counting[i] > max) {
				max = counting[i];
				idxOfMax = i;
			}
		}
		int flag = 0;
		for (int i = 0; i < counting.length; i++) {
			if (i != idxOfMax && counting[i] == max) {
				System.out.println("?");
				flag = 1;
				break;
			}
		}
		if (flag == 0)
			System.out.println((char)(idxOfMax + 'A'));
	}// main
}
