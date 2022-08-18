package SWEA;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class P1222 {
	// 스택 생성
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt(); // 문자열 길이
			sc.nextLine();
			String s = sc.nextLine(); // 문자열 입력
			String[] str = s.split(""); // 문자열을 잘라서 배열로 변환
			String post = inToPo(str); // 후위연산으로 변경
			System.out.println(post);
			int result = calPo(post); // 후위연산을 계산
			System.out.println("#" + test_case + " " + result);
		} // for1
	}// main
		// 중위 표기식을 후위 표기식으로 변경하는 함수

	static String inToPo(String[] str) {
		String post = "";
		// 스택생성
		Stack<String> stack = new Stack<>();
		int n = str.length;// 문자열 길이
		// 문자열을 탐색
		for (int i = 0; i < n; i++) {
			//여는 괄호면 무조건 스택에 집어넣기
			if (str[i].equals("(")) {
				stack.push(str[i]);
				continue;
			}
			// 만약 닫는 괄호면
			if (str[i].equals(")")) {
				// 여는 괄호가 아니면 모두 꺼내기
				while (!stack.peek().equals("(")) {
					post += stack.pop();
				} // while
				stack.pop(); // 여는괄호 없애버리기
				continue;
			} // if
			// 숫자면 출력
			if (order(str[i]) < 0)
				post += str[i];
			// 숫자가 아닌경우
			else {
				//괄호 아니면
					// 스택이 비어있을때 어떻게하지...?
				if (stack.isEmpty()) {
					stack.push(str[i]);
				} else {
					// top이 우선순위가 높거나 같으면 출력
					while (order(stack.peek()) >= order(str[i])) {
						post += stack.pop();
						if (stack.isEmpty())
							break;
					}
					// top의 우선순위가 낮으면 push
					stack.push(str[i]);
				}
			} // else
		} // for
			// 스택에 남은 요소들 꺼내기
		while (!stack.isEmpty())
			post += stack.pop();
		return post;
	}

	// 연산자 우선순위
	static int order(String c) {
		if (c.equals("+") || c.equals("-"))
			return 1;
		else if (c.equals("*") || c.equals("/"))
			return 2;
		else // 숫자일경우
			return -1;
	}

	// 후위표기식을 계산하는 함수
	static int calPo(String post) {
		int result = 0;
		String[] post2 = post.split(""); // 문자열 자르기
		// 스택생성
		Stack<Integer> stack = new Stack<>();
		int n = post2.length;// 문자열 길이
		// 문자열을 탐색
		for (int i = 0; i < n; i++) {
			// 숫자면 스택에 쌓기
			if (order(post2[i]) < 0)
				stack.push(Integer.valueOf(post2[i]));
			// 연산자인 경우 숫자 두개를 꺼내서 연산
			else {
				int b = stack.pop(); //
				int a = stack.pop(); //
				switch (post2[i]) {
				case ("+"):
					stack.push(a + b);
					break;
				case ("-"):
					stack.push(a - b);
					break;
				case ("*"):
					stack.push(a * b);
					break;
				case ("/"):
					stack.push(a / b);
					break;
				}// switch
			} // else
		} // for
			// 전부 탐색한 후
		result = stack.pop();
		return result;
	}// calPo
}// class
