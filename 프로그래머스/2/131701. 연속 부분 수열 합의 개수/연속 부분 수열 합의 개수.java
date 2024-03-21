import java.util.HashSet;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 1; i<= elements.length; i++){
            //i는 부분 수열의 길이
            for(int j = 0; j<elements.length; j++){
                //j는 부분수열 시작점
                int sum = 0;
                for(int k = 0; k<i; k++){
                    //i갯수 만큼 더하기
                    int idx = (j+k)%elements.length;
                    sum += elements[idx];
                }
                hs.add(sum);
            }
        }    
        answer = hs.size();
        
        return answer;
    }
}