import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = 0;
        int sum = 0;
        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (max < num) {
                max = num;
            }
            sum += num;
        }

        bw.write(sum*100.0/max/count + "\n");
        bw.flush();
        bw.close();
    }
}