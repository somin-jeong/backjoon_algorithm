import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        int n = 1;
        for (int i = num2+1; i <= num1; i++) {
            n = n * i;
        }

        int j = 1;
        for (int i = 1; i <= num1-num2; i++) {
            j = j * i;
        }

        int result = n/j;
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}