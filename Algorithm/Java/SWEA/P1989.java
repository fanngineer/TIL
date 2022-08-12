package SWEA;
import java.util.Scanner;
public class P1989 {
	public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            // 단어 입력
            String word = sc.next();
            char[] word_arr = word.toCharArray();
            int len = word.length();
            int flag = 1;
            for (int i = 0; i < word.length(); i++) {
                if (word_arr[i] != word_arr[len - i - 1]) {
                    flag = 0;
                    break;
                }
            }
            System.out.println("#" + test_case + " " + flag);
        }
    }
}
