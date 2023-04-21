import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] parent;
	static int[][] childs;
	static StringBuilder pre;
	static StringBuilder in;
	static StringBuilder post;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		parent = new int[N];
		childs = new int[N][2];
		StringTokenizer st;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int now = st.nextToken().charAt(0)-'A';
			int left = st.nextToken().charAt(0)-'A';
			int right = st.nextToken().charAt(0)-'A';
			if(left != '.'-'A') {
				childs[now][0] = left;
				parent[left] = now;
			}
			if(right != '.'-'A') {
				childs[now][1] = right;
				parent[right] = now;
			}
		}
		pre = new StringBuilder();
		in = new StringBuilder();
		post = new StringBuilder();
		preOrder(0);
		inOrder(0);
		postOrder(0);
		System.out.println(pre.toString());
		System.out.println(in.toString());
		System.out.println(post.toString());
	}
	static void preOrder(int node) {
		pre.append((char)(node+'A'));
		if(childs[node][0]!=0) preOrder(childs[node][0]);
		if(childs[node][1]!=0) preOrder(childs[node][1]);
	}
	static void inOrder(int node) {
		if(childs[node][0]!=0) inOrder(childs[node][0]);
		in.append((char)(node+'A'));
		if(childs[node][1]!=0) inOrder(childs[node][1]);
	}
	static void postOrder(int node) {
		if(childs[node][0]!=0) postOrder(childs[node][0]);
		if(childs[node][1]!=0) postOrder(childs[node][1]);
		post.append((char)(node+'A'));
	}
}
