class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        for(int i = 1; i<=r2; i++){
            //r2의 (i,y)좌표
            int y2 = (int) Math.floor(Math.pow((1.0*r2*r2-1.0*i*i),0.5));
            int y1 = 0;
            if(r1>=i){
                y1 = (int) Math.ceil(Math.pow((1.0*r1*r1-1.0*i*i),0.5));
            }
            
                answer += y2-y1+1;
            
            
        }
        answer *=4;
        return answer;
    }
}