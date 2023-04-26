import java.util.HashSet;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int N = nums.length;
        if(set.size()>=N/2) answer = N/2;
        else answer = set.size();
        return answer;
    }
}