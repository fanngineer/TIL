import java.util.ArrayList;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int len = progresses.length; //기능의 숫자
        int[] days = new int[len];
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i<len; i++){
            if((100-progresses[i])%speeds[i] ==0){
                days[i] = (100-progresses[i])/speeds[i];
            }
            else{
                days[i] = (100-progresses[i])/speeds[i] + 1;
            }
            // days[i] = (int) Math.ceil((100-progresses[i])/speeds[i]);
        }
        int today = days[0]; //오늘
        int cnt = 0; //배포할 기능 수
        for(int day : days){
            if(day<=today){
                cnt++;
            }else{
                arr.add(cnt);
                cnt = 1;
                today = day;
            }
        }
        if(cnt == 0){
            return new int[] {};
        }
        arr.add(cnt);
        answer = new int[arr.size()];
        for(int i = 0; i<arr.size(); i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }
}