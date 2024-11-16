import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            int count = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][count];
            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < count; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[count][2];
            dp[0][0] = arr[0][0];
            dp[0][1] = arr[1][0];
            for (int j = 1; j < count; j++) {
                if (j == 1) {
                    dp[j][0] = dp[j-1][1] + arr[0][j];
                    dp[j][1] = dp[j-1][0] + arr[1][j];
                    continue;
                }

                dp[j][0] = Math.max(dp[j-1][1] + arr[0][j], dp[j-2][1] + arr[0][j]);
                dp[j][1] = Math.max(dp[j-1][0] + arr[1][j], dp[j-2][0] + arr[1][j]);
            }

            list.add(Math.max(dp[count-1][0], dp[count-1][1]));
        }

        for (Integer integer : list) {
            bw.write(integer + "\n");
        }
        bw.flush();
        bw.close();
    }
}