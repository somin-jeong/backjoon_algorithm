import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int sountTokens = st.countTokens();
        int[] arr = new int[sountTokens];

        for (int i = 0; i < sountTokens; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int max = 0;
        for (int i = 0; i < count-3; i++) {
            for (int j = i+1; j < count-2; j++) {
                for (int k = j+1; k < count-1; k++) {
                    int group1 = 1;
                    for (int l = 0; l < i+1; l++) {
                        group1 *= arr[l];
                    }

                    int group2 = 1;
                    for (int l = i+1; l < j+1; l++) {
                        group2 *= arr[l];
                    }

                    int group3 = 1;
                    for (int l = j+1; l < k+1; l++) {
                        group3 *= arr[l];
                    }

                    int group4 = 1;
                    for (int l = k+1; l < count; l++) {
                        group4 *= arr[l];
                    }

                    sum = group1 + group2 + group3 + group4;

                    if (max < sum) {
                        max = sum;
                    }
                }
            }
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}
