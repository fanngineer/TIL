package SWEA;
import java.util.Scanner;
import java.util.StringTokenizer;
public class P5432 {
	public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
        	String bars = sc.next();//input!
        	int result=0;//결과
        	String newBars = bars.replace("()", "|");
        	String[] arr = newBars.split("");
            int cnt=0;
        	for(String s : arr) {
            	if(s.equals("(")) {
            		cnt++;
            	}
            	else if(s.equals("|")) {
            		result += cnt;
            	}
            	else {
            		cnt--;
            		result++;
            	}
            }
            //출력
            System.out.print("#" + test_case+" "+result);
        }//for
    }//main
}//class
