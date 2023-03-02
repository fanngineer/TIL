package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1248_공통조상 {
	
   static int[][] tree;
   static boolean[] visited;
   static int size;
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringBuilder sb = new StringBuilder();
      
      int T = Integer.parseInt(br.readLine());      
      for (int t = 1; t <= T; t++) {
         StringTokenizer st = new StringTokenizer(br.readLine());
         int V = Integer.parseInt(st.nextToken());
         int E = Integer.parseInt(st.nextToken());
         
         tree = new int[V+1][3]; //부모, left, right
         visited = new boolean[V+1];
         flag = false;
         size = 0;
         
         int num1 = Integer.parseInt(st.nextToken());
         int num2 = Integer.parseInt(st.nextToken());
         
         st = new StringTokenizer(br.readLine());
         int parent;
         int child;
         for(int e=1; e<=E; e++) {
            parent = Integer.parseInt(st.nextToken());
            child = Integer.parseInt(st.nextToken());
            //간선 저장
            tree[child][0] = parent;
            if(tree[parent][1]==0) {
            	tree[parent][1] = child;
            }
            else {
            	tree[parent][2] = child;
            }
         }//간선 입력
         
         //공통 조상 찾기
         while(true) {
        	 preOrder(num1, num2);
        	 if(flag) break;
        	 num1 = tree[num1][0];
         }
         
         //출력
         sb.append("#").append(t).append(" ");
         sb.append(num1).append(" ").append(size);
         bw.write(sb.toString());
         bw.newLine();
         sb.setLength(0);
      } // test_case
      bw.close();
   }// main
   static boolean flag;
   static void preOrder(int num1, int num2) {
	   //num1을 상대로 전위 순회
	   if(num1 != 0 && visited[num1]==false){
		   if(num1==num2) flag=true;
		   size++;
		   visited[num1]=true;
		   preOrder(tree[num1][1], num2);
		   preOrder(tree[num1][2], num2);
	   }
   }
}