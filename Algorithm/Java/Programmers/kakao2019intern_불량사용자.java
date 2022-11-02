package Programmers;

import java.util.ArrayList;
import java.util.HashSet;

class Solution2 {
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        //후보군
        avail = new ArrayList[banned_id.length];
        //방문처리
        boolean[] visited= new boolean[user_id.length];
        
        for(int b=0; b<banned_id.length;b++){
            //ban하나 뽑고
            String ban = banned_id[b];
            avail[b] = new ArrayList<>();
            //user하나씩 비교
            for(int u=0;u<user_id.length;u++){
                String user = user_id[u];
                //길이가 같고
                if(ban.length()==user.length()){
                    int flag = 1; //동일하면1, 다르면0
                    for(int i=0;i<user.length();i++){
                        if(ban.charAt(i)=='*')
                            continue;
                        else if(ban.charAt(i)!=user.charAt(i)){
                            flag = 0;
                            break;
                        }
                    }
                    //제재 대상으로 넣을 수 있으면
                    if(flag == 1 ){
                        avail[b].add(u); //후보군 배열에 userIdx저장
                    }
                }                        
            }//for_user
        }//for_ban - 후보군 찾기
        //후보군 안에서 조합 찾기
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
        //기저조건
        if(pick==banNums){
            hs.add(picked);
            return;
        }
        for(int i=0;i<avail[pick].size();i++){
            int u = avail[pick].get(i);
            if((picked&(1<<u))==0){
                //뽑는경우
                comb(pick+1,picked|(1<<u));
            }
        }
    }//comb
}