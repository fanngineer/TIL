package Self;

import java.util.Stack;

public class kakao2019intern_크레인인형뽑기게임 {
	public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        int n = board.length;
        //주어진 횟수만큼 반복
        for(int i=0; i<moves.length; i++){
            int nowRow = moves[i]-1; //지금 크레인이 멈춘 열의 인덱스        
            //주어진 열에서 세로로 내려가기
            int nowPick = -1; //지금 뽑은 인형. 없으면 -1
            for(int j = 0; j<n;j++){
                int nowSell = board[j][nowRow]; //지금칸에 들어있는것
                //지금칸에 인형이 있으면
                if(nowSell!=0){
                    nowPick = nowSell; //뽑은 인형 저장
                    board[j][nowRow] = 0; //뽑은 칸은 0으로
                    break;
                }
            }//for_세로
            //인형을 뽑았을때
            if(nowPick>0){
                //바구니가 안비어있을때 바구니 제일 위에 있는 인형이랑 뽑은게 같으면
                if(!stack.isEmpty()&&stack.peek()==nowPick){
                    stack.pop();//인형 없애기
                    answer +=2;
                }
                
                //바구니가 비었거나 제일 위에 있는 인형이랑 다르면
                else{
                    stack.add(nowPick);
                }
            }
        }//for_move
        return answer;
    }
}
