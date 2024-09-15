import java.io.*;
import java.util.StringTokenizer;

// dp[i][j] 에는 (0,0), (0,1), (1,0), ... (i,j)까지의 모든 수의 합이 들어간다
//  (x1, y1)부터 (x2, y2)까지 합은 dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1]로 구할 수 있음

// x2, y2
// x1-1, y2
// x2, y1-1
// x1-1, y1-1

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int iter = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer graph = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0){
                    dp[0][0] = Integer.parseInt(graph.nextToken());
                } else if (i == 0) {
                    dp[i][j] = dp[i][j-1] + Integer.parseInt(graph.nextToken());
                } else if (j == 0) {
                    dp[i][j] = dp[i-1][j] + Integer.parseInt(graph.nextToken());
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + Integer.parseInt(graph.nextToken());
                }
            }
        }

        for (int i = 0; i < iter; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(line.nextToken())-1;
            int y1 = Integer.parseInt(line.nextToken())-1;
            int x2 = Integer.parseInt(line.nextToken())-1;
            int y2 = Integer.parseInt(line.nextToken())-1;

            int result = 0;
            if (x1 == 0 && y1 == 0){
                result = dp[x2][y2];
            } else if (x1 == 0) {
                result = dp[x2][y2] - dp[x2][y1-1];
            } else if (y1 == 0) {
                result = dp[x2][y2] - dp[x1-1][y2];
            } else {
                result = dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1];
            }

            bw.write(result+ "\n");
        }

        bw.flush();
        bw.close();
    }
}