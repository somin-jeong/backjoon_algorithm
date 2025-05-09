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

		String input = br.readLine();

		StringTokenizer st = new StringTokenizer(input, " ");
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		int[] dp = new int[Math.max(num1, num2)+2];

		int result = 0;
		if (num1 >= num2) {
			result = num1 - num2;
		} else {
			for (int i = 1; i <= num2+1; i++) {
				if (i <= num1) {
					dp[i] = num1 - i;
				} else {
					if (i % 2 == 1) {
						dp[i] = dp[i-1]+1;
					}
					if (i % 2 == 0) {
						dp[i] = Math.min(i - num1, dp[i/2]+1);
						if (i != num1+1) {
							dp[i-1] = Math.min(dp[i-2]+1, dp[i]+1);
						}
					}
				}
			}

			result = dp[num2];
		}

		bw.write(result+"");
		bw.flush();
		bw.close();
	}
}