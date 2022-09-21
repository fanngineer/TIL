# 부분집합
- 집합에 포함된 원소들을 선택하는 것
- 다수의 중요 알고리즘들이 원소들의 그룹에서 최적의 부분집합을 찾는 것
- N개의 원소를 포함한 집합
  - 자기 자신과 공집합 포함한 모든 부분집합의 개수는 2<sup>n</sup>
  - 원소의 수가 증가하면 부분집합의 개수는 지수적으로 증가

## 재귀함수를 통해서 부분집합 구하기
```Java
public class PowerSet {
	static String[] ingredient = { "계란", "참치", "햄" };
	static int N = ingredient.length;
	
	static boolean[] selected = new boolean[N];

	public static void main(String[] args) {
		powerset(0);
	}

	static void powerset(int idx) {
		if(idx == N) {
			StringBuilder sb = new StringBuilder();
			for(int i =0; i<N; i++) {
				if(selected[i])
					sb.append(ingredient[i]);
			}
			System.out.println(sb+"샌드위치");
			
		}
		else {
			selected[idx] = true;
			powerset(idx+1);
			selected[idx] = false;
			powerset(idx+1);
		}
			
	}
}
```

## 비트마스킹을 통해서 구하기
```Java
public class PowerSet_bitMasking {
	static String[] ingredient = { "계란", "참치", "햄" };
	static int N = ingredient.length;

	public static void main(String[] args) {
		for(int i=0; i< (1<<N);i++) {
			StringBuilder sb = new StringBuilder();
			for(int j=0; j<N; j++) {
				if((i&(1<<j))>0) {
					sb.append(ingredient[j]);
				}
			}
			System.out.println(sb+"샌드위치");
		}//for
	}//main
}
```
