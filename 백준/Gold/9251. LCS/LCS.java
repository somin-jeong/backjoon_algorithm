import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line1 = br.readLine();
        char[] charArray1 = line1.toCharArray();
        String line2 = br.readLine();
        char[] charArray2 = line2.toCharArray();

        int[][] dp = new int[charArray1.length+1][charArray2.length+1];
        for (int i = 1; i <= charArray1.length; i++) {
            for (int j = 1; j <= charArray2.length; j++) {
                if (charArray1[i-1] == charArray2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int result = 0;
        for (int[] ints : dp) {
            result = Math.max(Arrays.stream(ints).max().orElse(0), result);
        }

        bw.write(result+"");

        bw.flush();
        bw.close();
    }
}