import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static List<String> list = new ArrayList<>();
	public static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int remainDay = Integer.parseInt(br.readLine());

		for (int i = 0; i < remainDay; i++) {
			list.add(br.readLine());
		}

		backtracking(remainDay, 0, 0);

		bw.write(result+"");
		bw.flush();
		bw.close();
	}

	public static void backtracking(int remainDay, int idx, int totalProfit) {
		if (remainDay <= idx) {
			result = Math.max(result, totalProfit);
			return;
		}

		for (int i = idx; i < remainDay; i++) {
			String dayCount_profit = list.get(i);
			StringTokenizer st = new StringTokenizer(dayCount_profit, " ");
			int dayCount = Integer.parseInt(st.nextToken());
			int profit = Integer.parseInt(st.nextToken());
			if (i+dayCount <= remainDay) {
				totalProfit += profit;
			}
			backtracking(remainDay, i+dayCount, totalProfit);
			if (i+dayCount <= remainDay) {
				totalProfit -= profit;
			}
		}
	}
}