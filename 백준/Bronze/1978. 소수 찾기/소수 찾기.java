import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        String sNum = br.readLine();
        StringTokenizer st = new StringTokenizer(sNum, " ");
        int sountTokens = st.countTokens();
        int[] arr = new int[sountTokens];

        for (int i = 0; i < sountTokens; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int prime_count = 0;
        for(int i=0; i<count; i++) {
            if (arr[i] == 1) {
                continue;
            } else {
                boolean isPrime = true;
                for (int j = 2; j < arr[i]; j++) {
                    if (arr[i] % j == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime)
                    prime_count += 1;
            }
        }

        bw.write(prime_count + "\n");
        bw.flush();
        bw.close();
    }
}
