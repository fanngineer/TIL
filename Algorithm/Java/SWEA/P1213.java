package SWEA;

import java.util.Scanner;

public class P1213 {
	public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            // �ܾ� �Է�
            sc.nextLine(); // �׽�Ʈ���̽� ��ȣ
            String word = sc.nextLine(); // �˻��� ���ڿ�
            String sentence = sc.nextLine(); // ��ü���ڿ�
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
