import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int count1 = Integer.parseInt(br.readLine());

		String count2 = br.readLine();
		StringTokenizer st1 = new StringTokenizer(count2, " ");

		String line = br.readLine();
		StringTokenizer st2 = new StringTokenizer(line, " ");
		int inspectorCount = Integer.parseInt(st2.nextToken());
		int subInspectorCount = Integer.parseInt(st2.nextToken());

		long totalCount = 0;
		for (int i=0; i<count1; i++) {
			int candidate_count = Integer.parseInt(st1.nextToken());
			if (candidate_count - inspectorCount <= 0) {
				totalCount += 1;
				continue;
			}
			long minimumCount = (long) Math.ceil((float)(candidate_count - inspectorCount) / subInspectorCount);
			totalCount += minimumCount + 1L;
		}

		bw.write(totalCount+"");
		bw.flush();
		bw.close();
	}
}