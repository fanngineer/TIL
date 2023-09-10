
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashSet<String> noHear = new HashSet<>();
		HashSet<String> noSee = new HashSet<>();
		HashSet<String> noHearSee = new HashSet<>();
		for(int i = 0; i<N; i++) {
			String noH = br.readLine();
			noHear.add(noH);
		}
		for(int i = 0; i<M; i++) {
			String noS = br.readLine();
			if(noHear.contains(noS))
			noHearSee.add(noS);
		}
		PriorityQueue<String> pq = new PriorityQueue<>();
		for(String nono : noHearSee) {
			pq.add(nono);
		}
		int cnt = pq.size();
		sb.append(cnt).append("\n");
		for(int i =0; i<cnt;i++) {
			sb.append(pq.poll());
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.close();
	}
}
