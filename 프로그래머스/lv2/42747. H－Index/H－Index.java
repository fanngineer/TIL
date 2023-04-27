class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int[] cnt = new int[10001];
        for(int ci : citations){
            cnt[ci]++;
        }
        int sum = 0;
        for(int i=10000; i>=0; i--){
            sum +=cnt[i];
            if(sum>=i){
                answer = i;
                break;
            }
        }
        return answer;
    }
}