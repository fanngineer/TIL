package SWEA;

import java.util.Scanner;
import java.io.FileInputStream;

public class P1208 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
        T=10;
		int[] result = new int[10];
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt(); // 제한 횟수 입력
            int[] boxes = new int[100]; //박스 배열 생성
            for(int i = 0; i<100; i++){
                boxes[i] = sc.nextInt(); //박스 input값 할당
            }
 
            int max_i=0;
            int min_i=0;
            //제한 횟수동안 반복
            for(int dump =0; dump<=n; dump++){
            int max = 0;
            int min = 100;                
                //최소값 찾기
                for(int i = 0; i<100; i++){
                    if(boxes[i]<min){
                        min = boxes[i]; //min에 가장 작은 box값 할당
                        min_i = i; //가장 작은 box 중 가장 왼쪽 줄 인덱스
                    }           
                }
                //최대값 찾기
                for(int i = 0; i<100; i++){
                    if(boxes[i]>max){
                        max = boxes[i]; //max에 가장 큰 box값 할당
                        max_i = i; //가장 큰 값 중 가장 왼쪽 줄 인덱스
                    }
                }
                result[test_case-1] = max-min; //i회 dump 실행 결과
                //최대-최소가 1이하인지 비교
                if((max-min)<=1){        
                    break;
                }
                //아닌경우 덤프 실행
                else{
                    boxes[max_i] -= 1;
                    boxes[min_i] += 1;
                }
            }
		}
		for(int test_case = 1; test_case <= T; test_case++){
            System.out.println("#"+test_case+" "+result[test_case-1]);
         
        }
	}
}