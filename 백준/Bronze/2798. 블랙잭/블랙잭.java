import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer line = new StringTokenizer(br.readLine(), " ");
        int countOfCard = Integer.parseInt(line.nextToken()); // 카드의 개수
        int m = Integer.parseInt(line.nextToken()); // 근접해야 하는 수

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int sountTokens = st.countTokens();
        int[] arr = new int[sountTokens];

        for (int i = 0; i < sountTokens; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int closeNum = 0;
        for (int i = 0; i < countOfCard - 2; i++) {
            for (int j = i+1; j < countOfCard - 1; j++) {
                for (int k = j+1; k < countOfCard; k++) {
                    sum = arr[k] + arr[j] + arr[i];
                    if (closeNum < sum && sum <= m) {
                        closeNum = sum;
                    }
                }
            }
        }

        bw.write(closeNum + "\n");
        bw.flush();
        bw.close();
    }
}