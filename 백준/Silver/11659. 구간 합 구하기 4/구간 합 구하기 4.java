import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");

        int count = Integer.parseInt(st1.nextToken());
        int iter = Integer.parseInt(st1.nextToken());

        int[] dp = new int[count];

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        dp[0] = Integer.parseInt(st2.nextToken());
        for (int i = 1; i < count; i++) {
            dp[i] = dp[i-1] + Integer.parseInt(st2.nextToken());
        }

        int result = 0;
        for (int i = 0; i < iter; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine(), " ");
            int front = Integer.parseInt(line.nextToken());
            int end = Integer.parseInt(line.nextToken());

            if (front > 1) {
                result = dp[end-1] - dp[front-2];
                bw.write(result+ "\n");
            } else {
                bw.write(dp[end-1]+ "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}