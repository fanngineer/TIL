package SWEA;

import java.util.LinkedList;
import java.util.Scanner;

import com.sun.org.apache.bcel.internal.classfile.Code;

public class P1230 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();// 원본 암호문의 길이
			LinkedList<Integer> codes = new LinkedList<>(); // 암호문을 받을 List생성
			LinkedList<Integer> orders = new LinkedList<>(); // 명령문을 받을 List생성
//원본암호문을 입력받자
			for (int i = 0; i < N; i++) {
				int code = sc.nextInt();
				codes.add(code);
			}
			int Or = sc.nextInt();// 명령어의 갯수 입력
//명령어를 입력받자
			for (int i = 0; i < Or; i++) {
				String type = sc.next(); // 명령문자
				// 덧붙일 숫자
				if (type.equals("I")) {
					int x = sc.nextInt();
					int y = sc.nextInt();
					for (int j = 0; j < y; j++) {
						int order = sc.nextInt();
						codes.add(x + j, order);
					} // for
				} // if
				else if (type.equals("D")) {
					int x = sc.nextInt();
					int y = sc.nextInt();
					for (int j = 0; j < y; j++) {
						codes.remove(x + j);
					} // for
				} // else if
				else if (type.equals("A")) {
					int y = sc.nextInt();
					for (int j = 0; j < y; j++) {
						int order = sc.nextInt();
						codes.add(order);
					} // for
				} //else if
			}
			// 출력
			System.out.print("#" + test_case);
			for (int i = 0; i < 10; i++) {
				System.out.print(" " + codes.get(i));
			}
			System.out.println();
		} // for
	}// main
}// class
