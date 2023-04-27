import java.util.ArrayList;
import java.util.Collections;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        ArrayList<Integer> al;
        int idx = 0;
        for(int[] cmd : commands){
            al = new ArrayList<>();
            for(int i = cmd[0]-1; i<=cmd[1]-1; i++){
                al.add(array[i]);
            }
            Collections.sort(al);
            answer[idx] = al.get(cmd[2]-1);
            idx++;
        }
        return answer;
    }
}