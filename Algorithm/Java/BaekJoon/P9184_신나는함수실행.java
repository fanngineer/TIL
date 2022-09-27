package BJ;

import java.util.Scanner;

public class P9184_신나는함수실행 {
	public static void main(String[] args) {
		int a = 0;
		int b = 0;
		int c = 0;
		Scanner sc = new Scanner(System.in);
		memory = new int[21][21][21];
		visited = new boolean[21][21][21];
		while (true) {
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			if(a == -1 && b == -1 && c == -1)
				break;
			System.out.printf("w(%d, %d, %d) = %d",a,b,c,w(a,b,c));
			System.out.println();
		}
	}
	static int[][][] memory;
	static boolean[][][] visited;
	static int w(int a, int b, int c) {
		if(a<=0||b<=0||c<=0) {
			return 1;
		}
		if(a>20||b>20||c>20){
			return w(20,20,20);
		}
		if(visited[a][b][c]==true ) {
			return memory[a][b][c];
		}
		if(a<b&& b<c) {
			int result = w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c);
			visited[a][b][c] = true;
			memory[a][b][c] = result;
			return result;
		}else {
			int result = w(a-1,b,c)+w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1);
			visited[a][b][c] = true;
			memory[a][b][c] = result;
			return result;
		}
	}
}
