package SWEA;

import java.util.Scanner;
import java.util.Stack;

public class P1218 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();// 길이
			String s = sc.next();// 괄호문자열
			int flag = 1; // 유효성
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < N; i++) {
				char c = s.charAt(i);
				char top;
				if (c == '(' || c == '[' || c == '{' || c == '<')
					stack.add(s.charAt(i));
				if (c == ')' || c == ']' || c == '}' || c == '>') {
					top = stack.pop();
					if ((c == ')' && top == '(') || (c == ']' && top == '[') || (c == '}' && top == '{')
							|| (c == '>' && top == '<'))
						continue;
					else {
						flag = 0;
						break;
					}
				}
			}
			// 출력
			System.out.println("#" + test_case + " " + flag);
		}
	}
}
