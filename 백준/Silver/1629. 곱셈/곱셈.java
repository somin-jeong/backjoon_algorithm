import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());


        bw.write(cal(A, B, C)+ "\n");
        bw.flush();
        bw.close();
    }

    public static long cal(long A, long B, long C) {
        if (B == 1) {
            return A%C;
        }

        if (B%2 == 1) {  // 홀수일 때
            long i = A % C;
            long j = cal(A, B-1, C);
            return ((i*j)%C);
        } else {  // 짝수일 때
            long result = cal(A, B/2, C);
            return (result*result)%C;
        }
    }
}