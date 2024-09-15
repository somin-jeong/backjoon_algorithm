import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        int[][] array = new int[count][2];
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array, (a, b) -> {
            if (a[1] > b[1]) {
                return 1;
            } else if (a[1] == b[1] && a[0] > b[0]) {
                return 1;
            } else if (a[1] == b[1] && a[0] == b[0]) {
                return 0;
            } else {
                return -1;
            }
        });

        int end = 0;
        int result = 0;
        for (int i = 0; i < count; i++) {
            if (array[i][0] >= end) {
                end = array[i][1];
                result++;
            }
        }

        bw.write(result+ "\n");
        bw.flush();
        bw.close();
    }
}