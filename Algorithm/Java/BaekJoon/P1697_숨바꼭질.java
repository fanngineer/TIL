import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1697_숨바꼭질 {

    static int N;
    static int K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        //큐 활용
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        queue.add(new int[] {N,1});
        visited[N] = true;
        int answer = 0;
            while (!queue.isEmpty()) {
                int[] temparray = queue.poll();
                int temp = temparray[0];
                int time = temparray[1];
                int temp_m1 = temp - 1;
                int temp_p1 = temp + 1;
                int temp_m2 = temp * 2;
                if (temp_m1 >= 0 && temp_m1 <= 100000 && visited[temp_m1] == false) {
                    if (temp_m1 == K) {
                        answer = time;
                        break;
                    } else {
                        queue.add(new int[] {temp_m1,time+1});
                        visited[temp_m1] = true;
                    }
                }
                if (temp < K) {
                    if (temp_p1 >= 0 && temp_p1 <= 100000 && visited[temp_p1] == false) {
                        if (temp_p1 == K) {
                            answer = time;
                            break;
                        } else {
                            queue.add(new int[] {temp_p1,time+1});
                            visited[temp_p1] = true;
                        }
                    }
                    if (temp_m2 >= 0 && temp_m2 <= 100000 && visited[temp_m2] == false) {
                        if (temp_m2 == K) {
                            answer = time;
                            break;
                        } else {
                            queue.add(new int[] {temp_m2,time+1});
                            visited[temp_m2] = true;
                        }
                    }
                }
            }
        System.out.println(answer);
    }
}