import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int[] set;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		set = new int[21];
		for(int i = 0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			int num = 0;
			if(!order.equals("all") && !order.equals("empty")) {
				num = Integer.parseInt(st.nextToken());
			}
			switch(order) {
			case "add" :
				set[num] = 1;
				break;
			case "remove" :
				set[num] = 0;
				break;
			case "check" :
				sb.append(set[num]).append("\n");
				break;
			case "toggle" :
//				System.out.println(set[num]);
				set[num] = set[num]^1;
//				System.out.println(set[num]);
				break;
			case "all" :
				for(int j = 1; j<=20; j++) {
					set[j]=1;
				}
				break;
			case "empty" :
				for(int j = 1; j<=20; j++) {
					set[j]=0;
				}
				break;
			}
		}
		bw.write(sb.toString());
		bw.close();
	}
}
