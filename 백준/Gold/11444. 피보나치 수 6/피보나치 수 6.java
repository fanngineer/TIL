import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
	static long N;
	static int p = 1000000007;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Long.parseLong(br.readLine());
		
		unit = new long[2][2];
		unit[0][0] = 1;
		unit[0][1] = 1;
		unit[1][0] = 1;
		
		long[][] res = divide(N);
		
		System.out.println(res[1][0]);
	}
	static long[][] unit;
	static long[][] divide(long N){
		if(N==1) return unit;
		long[][] temp = divide(N/2);
		long[][] twice = multiply(temp, temp);
		if(N%2==0) return twice;
		else return multiply(twice, unit);
	}
	
	
	static long[][] multiply(long[][] a, long[][] b){
		long[][] res = new long[2][2];
		res[0][0] = (a[0][0] * b[0][0]+a[0][1]*b[1][0])%p;
		res[0][1] = (a[0][0] * b[1][0]+a[0][1]*b[1][1])%p;
		res[1][0] = (a[1][0] * b[0][0]+a[1][1]*b[1][0])%p;
		res[1][1] = (a[1][0] * b[1][0]+a[1][1]*b[1][1])%p;
		return res;
	}
}
