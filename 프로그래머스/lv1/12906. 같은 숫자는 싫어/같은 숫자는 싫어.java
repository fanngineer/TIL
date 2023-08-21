import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int cnt = 0;
        int last = arr[0];
        ArrayList<Integer> copyArr = new ArrayList<>();
        copyArr.add(arr[0]);
        for(int i = 1; i<arr.length ; i++){
            if(arr[i] != last){
                copyArr.add(arr[i]);
                last = arr[i];
            }
        }
        
        
        int[] answer = new int[copyArr.size()];
        
        for(int i = 0; i<copyArr.size() ; i++){
            answer[i] = copyArr.get(i);
        }
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}