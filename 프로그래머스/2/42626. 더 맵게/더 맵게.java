import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville){
            pq.add(s);
        }
        while(pq.peek()<K && pq.size()>=2){
            int tmp = pq.poll()+pq.poll()*2;
            pq.add(tmp);
            answer++;
        }
        if(pq.peek()<K) return -1;
        return answer;
    }
}