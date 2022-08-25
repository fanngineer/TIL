package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5622_다이얼 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String grandma = br.readLine();
		int sec = 0;
		for (int i = 0; i < grandma.length(); i++) {
			char c = grandma.charAt(i);
			if (c <= 'O') {
				sec += (c - 'A') / 3 + 3;
			} else if (c <= 'S') {
				sec += 8;
			} else if (c <= 'V') {
				sec += 9;
			} else {
				sec += 10;
			}
		} // for_Grandma
		System.out.println(sec);
	}// main
}
