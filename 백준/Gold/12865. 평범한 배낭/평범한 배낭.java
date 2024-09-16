import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int itemCount = Integer.parseInt(st1.nextToken());
        int totalWeight = Integer.parseInt(st1.nextToken());

        int[] w = new int[itemCount+1];
        int[] v = new int[itemCount+1];

        for (int i = 1; i < itemCount+1; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine(), " ");
            int weight = Integer.parseInt(line.nextToken());
            int value = Integer.parseInt(line.nextToken());
            w[i] = weight;
            v[i] = value;
        }

        int[][] dp = new int[itemCount+1][totalWeight+1];
        for (int i = 1; i < itemCount+1; i++) {
            for (int j = 1; j < totalWeight+1; j++) {
                dp[i][j] = dp[i-1][j];
                if (j - w[i] >= 0) {
                    dp[i][j] = Math.max(dp[i-1][j], v[i] + dp[i-1][j-w[i]]);
                }
            }
        }

        bw.write(dp[itemCount][totalWeight]+ "\n");
        bw.flush();
        bw.close();
    }
}