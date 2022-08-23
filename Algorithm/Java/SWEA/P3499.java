package SWEA;
import java.util.Scanner;
public class P3499 {
	public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            sc.nextLine();
            String[] cards = new String[N];
            String[] newCards = new String[N]; //섞을카드
            int half = N/2+N%2; //앞쪽카드의 맨뒷장
//카드를 입력받자
            for(int i = 0; i<N; i++) {
            	cards[i] = sc.next();
            }
            //카드 나눠서 섞기
            for(int i = 0; i<half; i++) {
            	newCards[2*i] = cards[i];
            }
            for(int i = half; i<N; i++) {
            	newCards[2*(i-half)+1] = cards[i];
            }
            //출력
            System.out.print("#" + test_case);
            for(int i = 0; i<N; i++) {
            	System.out.print(" " + newCards[i]);
            }
            System.out.println();
        }//for
    }//main
}//class
