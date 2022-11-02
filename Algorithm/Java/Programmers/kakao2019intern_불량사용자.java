package Programmers;

import java.util.ArrayList;
import java.util.HashSet;

class Solution2 {
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        //�ĺ���
        avail = new ArrayList[banned_id.length];
        //�湮ó��
        boolean[] visited= new boolean[user_id.length];
        
        for(int b=0; b<banned_id.length;b++){
            //ban�ϳ� �̰�
            String ban = banned_id[b];
            avail[b] = new ArrayList<>();
            //user�ϳ��� ��
            for(int u=0;u<user_id.length;u++){
                String user = user_id[u];
                //���̰� ����
                if(ban.length()==user.length()){
                    int flag = 1; //�����ϸ�1, �ٸ���0
                    for(int i=0;i<user.length();i++){
                        if(ban.charAt(i)=='*')
                            continue;
                        else if(ban.charAt(i)!=user.charAt(i)){
                            flag = 0;
                            break;
                        }
                    }
                    //���� ������� ���� �� ������
                    if(flag == 1 ){
                        avail[b].add(u); //�ĺ��� �迭�� userIdx����
                    }
                }                        
            }//for_user
        }//for_ban - �ĺ��� ã��
        //�ĺ��� �ȿ��� ���� ã��
        hs = new HashSet<>(); 
        banNums = banned_id.length;
        comb(0,0);
        answer = hs.size();
        return answer;
    }//solution
    static int banNums;
    static HashSet<Integer> hs;
    static ArrayList<Integer>[] avail;
    static void comb(int pick, int picked){
        //��������
        if(pick==banNums){
            hs.add(picked);
            return;
        }
        for(int i=0;i<avail[pick].size();i++){
            int u = avail[pick].get(i);
            if((picked&(1<<u))==0){
                //�̴°��
                comb(pick+1,picked|(1<<u));
            }
        }
    }//comb
}