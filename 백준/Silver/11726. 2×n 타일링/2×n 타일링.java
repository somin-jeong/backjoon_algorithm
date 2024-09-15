import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        int[] dp = new int[num+1];

        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < num; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        bw.write(dp[num-1] + "\n");
        bw.flush();
        bw.close();
    }
}