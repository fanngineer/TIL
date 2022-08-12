package SWEA;

import java.util.Scanner;

public class P1213 {
	public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            // 단어 입력
            sc.nextLine(); // 테스트케이스 번호
            String word = sc.nextLine(); // 검색할 문자열
            String sentence = sc.nextLine(); // 전체문자열
            int cnt = 0;
            for (int i = 0; i < sentence.length()-word.length()+1; i++) {
                for (int j = 0; j < word.length(); j++) {
                    if (sentence.charAt(i+j) != word.charAt(j)) {
                        break;
                    }
                    if (j == word.length() - 1) {
                        cnt++;
                    }
                }
            }
            System.out.println("#" + test_case + " " + cnt);
        }
    }
}
