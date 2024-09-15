import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[n+2];
            dp[0] = 1;
            dp[1] = 2;
            dp[2] = 4;
            if (n > 2) {
                for (int j = 3; j < n; j++) {
                    dp[j] = dp[j-3] + dp[j-2] + dp[j-1];
                }
            }

            bw.write(dp[n-1] + "\n");
        }
        bw.flush();
        bw.close();
    }
}