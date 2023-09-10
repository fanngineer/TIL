import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static HashSet<Integer> set;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		set = new HashSet<>();
		for(int i = 0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			int num = 0;
			if(!order.equals("all") && !order.equals("empty")) {
				num = Integer.parseInt(st.nextToken());
			}
			switch(order) {
			case "add" :
				set.add(num);
				break;
			case "remove" :
				set.remove(num);
				break;
			case "check" :
				if(set.contains(num)) {
					sb.append(1).append("\n");
				}
				else {
					sb.append(0).append("\n");
				}
				break;
			case "toggle" :
				if(set.contains(num)) set.remove(num);
				else set.add(num);
				break;
			case "all" :
				for(int j = 1; j<=20; j++) {
					set.add(j);
				}
				break;
			case "empty" :
				set.clear();
				break;
			}
		}
		bw.write(sb.toString());
		bw.close();
	}
}
