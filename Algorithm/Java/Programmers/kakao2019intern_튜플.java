package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(String s) {
        int nums = -1; //튜플 원소의 갯수 찾기
        for(int n =0; n<s.length(); n++){
            if(s.charAt(n)=='{')
                nums++;
        }//nums가 튜플 원소의 갯수
        int[] answer = new int[nums];
        //부분집합의 배열
        ArrayList<Integer>[] inputs = new ArrayList[nums];
        //String가공하기
        int i = -1;
        int startIdx = 0; //숫자의 시작인덱스
        int endIdx = 0; //숫자의 끝인덱스
        
        for(int n =1; n<s.length()-1; n++){
            char now = s.charAt(n);
            //새로운 부분집합의 시작점
            if(now=='{'){
                i++;
                inputs[i] = new ArrayList<>();
                startIdx = n+1;
                continue;
            }else if(now=='}'){
                endIdx = n;
                inputs[i].add(Integer.parseInt(s.substring(startIdx,endIdx)));
                n++;
                continue;
            }else if(now==','){
                endIdx = n;
                inputs[i].add(Integer.parseInt(s.substring(startIdx,endIdx)));
                startIdx = n+1;
                continue;
            }
        }
        //튜플 만들기 - 원소 갯수만큼 반복
        for(int n=0; n<nums; n++){
            int found=0;
            //부분집합 배열 순회하기
            for(int k=0; k<nums; k++){
                 //n번째 원소를 찾을 집합 - 비어있지 않고, 크기가 1
                 if(!inputs[k].isEmpty()&&inputs[k].size()==1){
                     found = inputs[k].get(0);
                     break;      
                 }
             }
             answer[n] = found; //해당 원소 뽑고 나머지 배열에서 모두 지우기
             for(int m=0; m<nums; m++){
                 for(int v=0; v<inputs[m].size(); v++)
                     if(inputs[m].get(v)==found)
                         inputs[m].remove(v);
             }
        }
        return answer;
    }
}