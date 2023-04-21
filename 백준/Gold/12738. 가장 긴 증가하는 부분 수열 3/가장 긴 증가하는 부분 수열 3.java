import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] nums;
	static int[] idx;
	static ArrayList<Integer> memo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		nums = new int[N];
		for(int i = 0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}//입력
		memo = new ArrayList<>();
		idx = new int[N];
		for(int i = 0; i<N; i++) {
			findIdx(i);
		}//입력
		System.out.println(memo.size());
	}
	static void findIdx(int i) {
		int num = nums[i];
		if(memo.isEmpty()) {
			memo.add(num);
			idx[i] = 0;
			return;
		}
		if(memo.get(memo.size()-1)<num) {
			memo.add(num);
			idx[i] = memo.size();
			return;
		}
		//binary search
		int start = 0;
		int end = memo.size()-1;
		if(memo.get(end)==num) {
			idx[i] = end;
			return;
		}
		if(memo.get(start)>=num) {
			memo.set(start, num);
			idx[i] = start;
			return;
		}
		int mid = (start+end)/2;
		while(mid != start) {
			int middle = memo.get(mid);
			if(middle==num) {
				idx[i] = mid;
				return;
			}
			if(middle<num) {
				start = mid;
			}else {
				end = mid;
			}
			mid = (start+end)/2;
		}//while
		if(memo.get(start)>=num) {
			memo.set(start, num);
			idx[i] = start;
			return;
		}else {
			memo.set(mid+1, num);
			idx[i] = mid+1;
		}
	}
}
