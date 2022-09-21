# 조합
서로 다른 n개의 원소 중 r개를 순서 없이 골라낸 것

## 조합의 수식
<sub>n</sub>C<sub>r</sub> = <sub>n-1</sub>C<sub>r-1</sub>+<sub>n-1</sub>C<sub>r</sub>

## 재귀함수로 구현
```Java
public class Combination_recursion {
	static String[] data = { "A", "B", "C", "D" };
	static int N = data.length;
	static int R = 2;

	static String[] selected = new String[R];

	public static void main(String[] args) {
		combination(0,0);
	}

	static void combination(int idx, int sidx) {
		if (sidx == R) {

			System.out.println(Arrays.toString(selected));
			return;
		} else if (idx == N)
			return;
		else {
			selected[sidx] = data[idx];
			combination(idx + 1, sidx + 1);// 해당 데이터를 뽑은 상태
			combination(idx + 1, sidx); // 해당 idx번째 재료를 안뽑은 상태
		}
	}
}
```
## 재귀함수로 표현2
```Java
import java.util.Arrays;

public class Combination_recursion2 {
	static String[] data = { "A", "B", "C", "D" };
	static int N = data.length;
	static int R = 2;

	static String[] selected = new String[R];

	public static void main(String[] args) {
		combination(0, 0);
	}

	static void combination(int idx, int sidx) {
		if (sidx == R) {

			System.out.println(Arrays.toString(selected));
			return;
		}
		else {
			for(int i=idx; i<=N-R+sidx; i++) {
				selected[sidx] = data[i];
				combination(i+1,sidx+1);
			}
		}
	}
}
```
