package Programmers;

public class kakao2019intern_징검다리건너기 {
	public int solution(int[] stones, int k) {
		int answer = 0;
		int min = 1;
		int max = 200000000;
		int n = stones.length;
		while (min < max) {
			int mid = (min + max) / 2;
			boolean pass = true;
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				int stone = stones[i] - mid;
                if (stone<= 0) {
					cnt++;
				} else
					cnt = 0;
				if (cnt == k) {
					pass = false;
					break;
				}
			}
			if (pass == false) {
				max = mid;
			} else {
				min = mid+1;
			}
		}//while;
        answer = max;
		return answer;
	}
}
