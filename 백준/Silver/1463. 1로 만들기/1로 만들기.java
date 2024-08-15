import java.io.*;

/**
 * 동적계획법 bottom-top(‘작은 문제’부터 해결하여 ‘큰 문제’까지 해결하는 알고리즘 방식) 방식으로 풀기
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int[] dp = new int[num+1];

        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= num; i++) {
            if (i % 6 == 0) {
                int min = Math.min(dp[i/3], dp[i/2]);
                dp[i] = Math.min(min, dp[i-1]) + 1;
            } else if (i % 3 == 0) {
                dp[i] = Math.min(dp[i/3], dp[i-1]) + 1;
            } else if (i % 2 == 0) {
                dp[i] = Math.min(dp[i/2], dp[i-1]) + 1;
            } else {
                dp[i] = dp[i-1] + 1;
            }
        }

        bw.write(dp[num] + "\n");
        bw.flush();
        bw.close();
    }
}