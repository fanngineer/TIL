package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class P1231_중위순회 {
	static String word;
	public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
        	//배열 만들기
        	int N = sc.nextInt();
        	sc.nextLine();
        	String[] keys = new String[N+1];
        	int[][] tree = new int[N+1][2];
        	//입력받기
        	for(int i=1;i<=N;i++) {
        		String input = sc.nextLine();
        		String[] info = new String[4];
        		String[] inputs = input.split(" ");
        		for(int j=0; j<inputs.length;j++) {
        			info[j] = inputs[j];
        		}
        		int node = Integer.parseInt(info[0]);
        		String key = info[1];
        		keys[node] = key;
        		
        		if(info[2]==null) {
        			tree[node][0] = 0;
        			tree[node][1] = 0;
        		}else if(info[3]==null){
        			tree[node][0] = Integer.parseInt(info[2]);
        			tree[node][1] = 0;
        		}else {
        			tree[node][0] = Integer.parseInt(info[2]);
        			tree[node][1] = Integer.parseInt(info[3].replaceAll("\n", ""));
        		}
            }
        	//순회
        	word = ""; //반환할 단어
        	inOrder(1 ,keys, tree);
            //출력
            System.out.println("#" + test_case+" "+word);
        }//for
    }//main
	public static void inOrder(int root, String[] keys, int[][] tree) {
		if(tree[root][0] != 0) {
			inOrder(tree[root][0], keys, tree);
		}
		word += keys[root];//읽는 과정
		if(tree[root][1] != 0) {
			inOrder(tree[root][1], keys, tree);
		}
	}
}
