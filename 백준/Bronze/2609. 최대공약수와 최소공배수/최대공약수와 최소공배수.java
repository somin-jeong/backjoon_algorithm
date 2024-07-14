import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        int min = Math.min(num1, num2);
        int max = Math.max(num1, num2);

        int gcd = 0; // 최대공약수
        for (int i = min; i > 0; i--) {
            if (num1 % i == 0 && num2 % i == 0) {
                gcd = i;
                break;
            }
        }

        int lcm = 0; // 최소공배수
        for (int i = max; i <= num1*num2; i++) {
            if (i % min == 0 && i % max == 0) {
                lcm = i;
                break;
            }
        }

        bw.write(gcd + "\n");
        bw.write(lcm + "\n");
        bw.flush();
        bw.close();
    }
}