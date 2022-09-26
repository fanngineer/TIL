# 순열
- 서로 다른 것들 중 몇개를 뽑아서 한 줄로 나열하는 것
- <sub>n</sub>P<sub>r</sub> = n * (n-1) * (n-2) * ... * (n-r+1)

## Swap을 통한 구현
```Java
import java.util.Arrays;

public class Permutation_swap {
	static int[] nums;
	static int N;

	public static void main(String[] args) {
		nums = new int[] { 0, 1, 2 };
		N = nums.length;
		perm(0);
	}
	static void perm(int idx) {
		if(idx==N) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		for(int i = idx; i<N; i++) {
			swap(i, idx);
			perm(idx+1);
			swap(i,idx);
			
		}
	}
	static void swap(int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
}


```
