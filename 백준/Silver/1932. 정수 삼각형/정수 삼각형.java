import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        int[][] dp = new int[count][count];
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < i+1; j++) {
                if (i == 0) {
                    dp[i][j] = Integer.parseInt(st.nextToken());
                    continue;
                }

                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + Integer.parseInt(st.nextToken());
                    continue;
                }

                if (j == i) {
                    dp[i][j] = dp[i-1][j-1] + Integer.parseInt(st.nextToken());
                    continue;
                }

                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + Integer.parseInt(st.nextToken());
            }
        }

        bw.write(findMax(dp[count-1]) + "\n");
        bw.flush();
        bw.close();
    }

    public static int findMax(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}