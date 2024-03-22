import java.util.PriorityQueue;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>((a,b)->(b-a));
        PriorityQueue<Integer> pq2 = new PriorityQueue<>((a,b)->(b-a));
        for(int[] size : sizes){
            if(size[1]>size[0]){
                pq1.add(size[1]);
                pq2.add(size[0]);
            }else{
                pq1.add(size[0]);
                pq2.add(size[1]);
            }
        }
        answer = pq1.poll() * pq2.poll();
        return answer;
    }
}