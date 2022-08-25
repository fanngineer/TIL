package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1316_그룹단어체커 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt =N; //그룹단어 갯수
		//단어를 입력받자
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			//단어가 그룹 단어인지 확인
			for(int j=1;j<word.length();j++) {
				int flag = 0;
				String check = word.substring(0,j);
				//문자가 바꼈을때
				if(word.charAt(j)!=word.charAt(j-1)) {
					//앞에 문자들이랑 비교해서 같은게 있으면 
					for(int k=0;k<j;k++) {
						if(word.charAt(k)==word.charAt(j)) {
							cnt--;
							flag = 1;
							break;
						}
					}
					if(flag ==1)
						break;
				}//if_문자 바뀜
			}//for_check
		} // for_단어입력
		System.out.println(cnt);
	}// main
}
