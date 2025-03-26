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
        Arrays.fill(dp, 1);

        for (int i = 1; i < count; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int result = Arrays.stream(dp).max().getAsInt();
        bufferedWriter.write(result+"");

        bufferedWriter.flush();
        bufferedWriter.close();
    }
}