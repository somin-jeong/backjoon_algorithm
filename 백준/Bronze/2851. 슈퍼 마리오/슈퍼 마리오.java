import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;

            if (sum > 100 && Math.abs(sum-100) > Math.abs(sum-num-100)) {
                sum -= num;
                break;
            }
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}