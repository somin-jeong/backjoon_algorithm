import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[9];

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }


        int sum = 0;
        ArrayList<Integer> result = new ArrayList<>();
        boolean flag = false;

        for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    if (k==i || k==j) {
                        continue;
                    }
                    result.add(arr[k]);
                    sum += arr[k];
                }
                if (sum == 100) {
                    flag = true;
                    break;
                }
                result.clear();
                sum = 0;
            }
            if (flag) {
                break;
            }
        }

        Collections.sort(result);

        for (int s = 0; s < 7; s++) {
            bw.write(String.valueOf(result.get(s)) + "\n");
        }

        bw.flush();
        bw.close();
    }
}