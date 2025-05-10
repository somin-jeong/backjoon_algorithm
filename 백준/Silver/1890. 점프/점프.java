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

		int count = Integer.parseInt(br.readLine());

		int[][] game = new int[count][count];

		for (int i = 0; i < count; i++) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line, " ");
			for (int j = 0; j < count; j++) {
				game[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		long[][] dp = new long[count][count];

		dp[0][0] = 1;
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < count; j++) {
				int num = game[i][j];
				if (num == 0 && i!=count-1 && j!=count-1) {
					bw.write(dp[count-1][count-1]+"");
					bw.flush();
					bw.close();
					return;
				}

				if (num == 0) {
					break;
				}

				if (i+num < count) {
					dp[i+num][j] += dp[i][j];
				}
				if (j+num < count) {
					dp[i][j+num] += dp[i][j];
				}
			}
		}
		bw.write(dp[count-1][count-1]+"");
		bw.flush();
		bw.close();
	}
}