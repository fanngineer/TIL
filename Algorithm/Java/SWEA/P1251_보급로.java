package SWEA;

import java.util.Scanner;

public class P1251_보급로 {
	static int[][] map;
	static int[][] dist;
	static int[][] visited;
	static int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
        T = Integer.parseInt(sc.nextLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(sc.nextLine()); // 지도의 크기
            map = new int[N][N]; //지도 저장 행렬
            visited = new int[N][N];
            dist = new int[N][N];
            for(int i = 0; i<N; i++){
            	String line = sc.nextLine();
            	for(int j = 0; j<N; j++) {
            		map[i][j] = line.charAt(j) - '0';
            	}
            }//지도 입력
            
            //다잌스트라 알고리즘을 써보자
            
            for(int i = 0; i<N; i++){
            	for(int j = 0; j<N; j++) {
            		dist[i][j] = Integer.MAX_VALUE;
            	}
            }//거리를 무한으로 초기화
            
            //0,0에서 시작
            dist[0][0] = 0;
            //지금 위치
            int now_i = 0;
            int now_j = 0;
            
            for(int k=0; k<N*N; k++) {
            	visited[now_i][now_j] = 1;
            	for(int[] di : directions) {
            		//갈수있는 위치
            		int find_i = now_i + di[0];
            		int find_j = now_j + di[1];
            		if(0<=find_i&&find_i<N&&0<=find_j&&find_j<N) {
            			//최솟값으로 초기화
            			dist[find_i][find_j] = Math.min(dist[find_i][find_j], dist[now_i][now_j]+map[find_i][find_j]);
            			            			
            		}
            	}
            	//최솟값을 찾기
            	int min = Integer.MAX_VALUE;
            	for(int i = 0; i<N; i++){
                	for(int j = 0; j<N; j++) {
                		if(visited[i][j]==0 && min>dist[i][j]) {
                			min = dist[i][j];
                			now_i = i;
                			now_j = j;
                		}
                	}
                }//거리 행렬의 최솟값찾기
            	if(now_i==N-1&&now_j==N-1)
            		break;
            }
            
 
            System.out.println("#"+test_case+" "+dist[N-1][N-1]);
		}//TestCase
	}//main
}//class
