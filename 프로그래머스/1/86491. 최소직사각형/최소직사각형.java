import java.util.PriorityQueue;
class Solution {
    public int solution(int[][] sizes) {
        int length = 0;
        int height = 0;
        for(int[] size : sizes){
            length = Math.max(length, Math.max(size[1],size[0]));
            height = Math.max(height, Math.min(size[1],size[0]));
        }
        return length * height;
    }
}