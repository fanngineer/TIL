package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(String s) {
        int nums = -1; //Ʃ�� ������ ���� ã��
        for(int n =0; n<s.length(); n++){
            if(s.charAt(n)=='{')
                nums++;
        }//nums�� Ʃ�� ������ ����
        int[] answer = new int[nums];
        //�κ������� �迭
        ArrayList<Integer>[] inputs = new ArrayList[nums];
        //String�����ϱ�
        int i = -1;
        int startIdx = 0; //������ �����ε���
        int endIdx = 0; //������ ���ε���
        
        for(int n =1; n<s.length()-1; n++){
            char now = s.charAt(n);
            //���ο� �κ������� ������
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
        //Ʃ�� ����� - ���� ������ŭ �ݺ�
        for(int n=0; n<nums; n++){
            int found=0;
            //�κ����� �迭 ��ȸ�ϱ�
            for(int k=0; k<nums; k++){
                 //n��° ���Ҹ� ã�� ���� - ������� �ʰ�, ũ�Ⱑ 1
                 if(!inputs[k].isEmpty()&&inputs[k].size()==1){
                     found = inputs[k].get(0);
                     break;      
                 }
             }
             answer[n] = found; //�ش� ���� �̰� ������ �迭���� ��� �����
             for(int m=0; m<nums; m++){
                 for(int v=0; v<inputs[m].size(); v++)
                     if(inputs[m].get(v)==found)
                         inputs[m].remove(v);
             }
        }
        return answer;
    }
}