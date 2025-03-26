import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(bufferedReader.readLine());
        String line = bufferedReader.readLine();

        StringTokenizer st = new StringTokenizer(line, " ");
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[count];
        dp[0] = 1;
        for (int i = 1; i < count; i++) {
            int max = 0;
            for (int j = i-1; j >= 0; j--) {
                if (array[j] < array[i] && dp[j] > max) {
                    max = dp[j];
                }
            }
            if (max == 0) {
                dp[i] = 1;
            } else {
                dp[i] = max+1;
            }
        }

        int result = Arrays.stream(dp).max().getAsInt();
        bufferedWriter.write(result+"");

        bufferedWriter.flush();
        bufferedWriter.close();
    }
}