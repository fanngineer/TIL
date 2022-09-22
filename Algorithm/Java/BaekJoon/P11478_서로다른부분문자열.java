package BJ;

import java.util.HashSet;
import java.util.Scanner;

public class P11478_서로다른부분문자열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		HashSet<String> set = new HashSet<>();
		// substring의 길이
		for (int l = 1; l <= line.length(); l++) {
			// substring의 시작점
			for (int j = 0; j < line.length() - l + 1; j++) {
				String sub = line.substring(j, j + l);
				set.add(sub);
			}
		}
		//출력
		System.out.println(set.size());
	}
}
