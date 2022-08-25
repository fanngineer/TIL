package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10809 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word =br.readLine();
		for(int i=0;i<26;i++) {
			char alpha = (char)((int)'a'+i);
				System.out.print(word.indexOf(alpha));
				System.out.print(" ");
		}
			
	}
}
