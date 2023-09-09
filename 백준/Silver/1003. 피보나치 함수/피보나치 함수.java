
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int zero;
	static int one;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int i = 0; i<tc; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) {
				System.out.println(1 + " " +0);
				continue;
			}
			int[] zeroCnt = new int[n+1];
			int[] oneCnt = new int[n+1];
			zeroCnt[0] = 1;
			zeroCnt[1] = 0;
			oneCnt[0] = 0;
			oneCnt[1] = 1;
			for(int j = 2; j<=n; j++) {
				zeroCnt[j] = zeroCnt[j-1]+zeroCnt[j-2];
				oneCnt[j] = oneCnt[j-1]+oneCnt[j-2];
			}
			System.out.println(zeroCnt[n] + " " + oneCnt[n]);
		}
	}
	static int fibo(int n) {
		if(n==0) {
			zero++;
			return 0;
		}else if(n==1) {
			one++;
			return 1;
		}else {
			return fibo(n-1) + fibo(n-2);
		}
	}
}
