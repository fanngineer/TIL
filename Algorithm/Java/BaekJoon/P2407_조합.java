package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.math.BigInteger;
public class P2407_조합 {
	static int n;
	static int m;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		BigInteger n1 = new BigInteger("1");
		BigInteger n2 = new BigInteger("1");
		for(int i=0; i<m; i++) {
			n1 = n1.multiply(new BigInteger(Integer.toString(n-i)));
			n2 = n2.multiply(new BigInteger(Integer.toString(i+1)));
		}
		BigInteger answer = n1.divide(n2);
		System.out.println(answer);
	}
}
