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

## 방문체크를 통한 구현
```Java
package Self;

import java.util.Arrays;

public class Permutation_check {
	static boolean[] visited;
	static int[] nums;
	static int[] result; //순열의 결과 저장
	static int N;
	
	public static void main(String[] args) {
		nums = new int[] {1,2,3};
		N = nums.length;
		result = new int[N];
		visited = new boolean[N];
		perm(0);
	}
	static void perm(int k) {
		//기저조건
		if(k>=N) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for(int i=0; i<N;i++) {
			//k번째 원소에 할당하기
			if(visited[i]==false) {
				result[k]=nums[i];
				visited[i]=true;
				
				perm(k+1);
				//안할당하기
				visited[i]=false;
			}
		}
	}
}
```

## 비트마스킹을 통한 순열 생성
```Java
package Self;

import java.util.Arrays;

public class Permutation_bitmask {
	static int[] nums;
	static int[] result; //순열의 결과 저장
	static int N;
	public static void main(String[] args) {
		nums = new int[] {1,2,3};
		N = nums.length;
		result = new int[N];
		perm(0,0);
	}
	static void perm(int k,int bit) {
		if(k>=N) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for(int i =0; i<N;i++) {
			if((bit&(1<<i))==0) {
				result[k]=nums[i];
				perm(k+1,bit|(1<<i));
			}
		}
	}
}
```
