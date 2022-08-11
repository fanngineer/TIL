package SWEA;

import java.util.Scanner;
import java.io.FileInputStream;

public class P1979 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int result=0;
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[][] boxes = new int[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    boxes[i][j] = sc.nextInt();
                }
            }
            //가로줄 탐색
            int cnt = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if (boxes[i][j] == 1 ){
                        cnt++;
                    }
                    //검은색을 만났을때 K칸이면 카운트
                    else{
                        if(cnt == K ){
                            result++;
                        }
                        cnt =0;
                    }
                }
                //마지막이 흰색으로 끝났을때 확인 후 초기화
                if(cnt == K ){
                    result++;
                }
                cnt = 0;
            }
            //세로줄 탐색
            for(int j=0;j<N;j++){
                cnt = 0; //초기화
                for(int i=0;i<N;i++){
                    if (boxes[i][j] == 1 ){
                        cnt++;
                    }
                    //검은색을 만났을때 K칸이면 카운트
                    else{
                        if(cnt == K ){
                            result++;
                        }
                        cnt = 0;
                    }
                }
                //마지막이 흰색으로 끝났을때 확인 후 초기화
                if(cnt == K ){
                    result++;
                    cnt = 0;
                }
            }
            System.out.println("#"+test_case+" "+result);
        }
    }
}