package BJ;

import java.util.Scanner;

public class P11726_2xn타일링2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] memory = new int[1001];
		
		memory[0]=1;
		memory[1] = 1;
		for(int i = 2; i<=n;i++) {
			memory[i] = (memory[i-1]+memory[i-2]*2)%10007;
		}
		System.out.println(memory[n]);
	}
}
